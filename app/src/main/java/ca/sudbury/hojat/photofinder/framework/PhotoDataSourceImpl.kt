package ca.sudbury.hojat.photofinder.framework

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import ca.sudbury.hojat.core.data.PhotoDataSource
import ca.sudbury.hojat.core.domain.Photo
import ca.sudbury.hojat.photofinder.framework.model.UnsplashJSON
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Hojat Ghasemi at 2022-04-24
 * contact the author at "https://github.com/hojat72elect"
 */
class PhotoDataSourceImpl(
    val owner: LifecycleOwner
) :
    PhotoDataSource {

    fun getRetrofitInstance(): Retrofit {

        // The logging interceptor for Retrofit
        val interceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

        // The builder class for OkHttpClient
        val client = OkHttpClient.Builder().apply {
            this.addInterceptor(interceptor)
        }.build()

        return Retrofit.Builder()
            .baseUrl(NetworkModel.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }

    override fun getAll(): List<Photo> {

        val photosList = mutableListOf<Photo>()
        val retService = getRetrofitInstance().create(NetworkModel::class.java)
        val responseLiveData: LiveData<Response<UnsplashJSON>> = liveData {

            val response = retService.getPhotos()
            emit(response)
        }

        responseLiveData.observe(owner) {
            val JSONBody = it.body()?.listIterator()

            if (JSONBody != null) {
                while (JSONBody.hasNext()) {
                    val nextUnsplashPhoto = JSONBody.next()
                    Log.d("next_unsplash_photo", nextUnsplashPhoto.toString())
                    val nextPhoto = Photo(
                        nextUnsplashPhoto.id,
                        nextUnsplashPhoto.likes ?: 0,
                        nextUnsplashPhoto.description,
                        nextUnsplashPhoto.urls?.full,
                        nextUnsplashPhoto.urls?.regular
                    )

                    Log.d("next_photo", nextPhoto.toString())
                    photosList.add(nextPhoto)

                }
            } else {
                Log.e("error_JSON_body_empty", "The JSON body is empty")
            }
            Log.d("PhotoDataSourceImpl", photosList.toString())

        }
        return photosList
    }
}
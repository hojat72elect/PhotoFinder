package ca.sudbury.hojat.photofinder.framework

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
                    val nextPhoto = JSONBody.next()
                    photosList.add(
                        Photo(
                            nextPhoto.id,
                            nextPhoto.likes ?: 0,
                            nextPhoto.description,
                            nextPhoto.urls?.full,
                            nextPhoto.urls?.regular
                        )
                    )

                }
            }
        }
        return photosList
    }
}
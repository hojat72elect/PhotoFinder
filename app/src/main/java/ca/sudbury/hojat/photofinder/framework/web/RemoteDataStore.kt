package ca.sudbury.hojat.photofinder.framework.web

import ca.sudbury.hojat.photofinder.framework.web.data.UnsplashJSON
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Created by Hojat Ghasemi at 2022-04-24
 * Contact the author at "https://github.com/hojat72elect"
 */
interface RemoteDataStore {


    // I have to define this function with suspend; otherwise it threw some weird errors.
    @GET("/photos/?client_id=_htwco9giNp8TaA8kshIB3VP0eUZq5Y4pFWHLQuNPRU")
    suspend fun getPhotos(): Response<UnsplashJSON>

    companion object {
        const val BASE_URL = "https://api.unsplash.com/"

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
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
        }


    }
}
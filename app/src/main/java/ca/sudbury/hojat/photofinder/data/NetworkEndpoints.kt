package ca.sudbury.hojat.photofinder.data

import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Hojat Ghasemi at 2022-05-16
 * Contact the author at "https://github.com/hojat72elect"
 *
 * Retrofit endpoints definition.
 */
interface NetworkEndpoints {

    @GET("collections/317099/photos")
    fun loadPhotos(
        @Query("client_id") clientId: String,
        @Query("page") page: Int,
        @Query("per_page") pageSize: Int
    ): Observable<Response<List<UnsplashPhoto>>>

    companion object {
        const val BASE_URL = "https://api.unsplash.com/"
    }
}
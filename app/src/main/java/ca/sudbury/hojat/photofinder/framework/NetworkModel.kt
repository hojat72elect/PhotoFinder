package ca.sudbury.hojat.photofinder.framework

import ca.sudbury.hojat.photofinder.framework.model.UnsplashJSON
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Hojat Ghasemi at 2022-04-24
 * Contact the author at "https://github.com/hojat72elect"
 */
interface NetworkModel {


    @GET("/photos/?client_id=_htwco9giNp8TaA8kshIB3VP0eUZq5Y4pFWHLQuNPRU")
    suspend fun getPhotos(): Response<UnsplashJSON>


    companion object {
        const val BASE_URL = "https://api.unsplash.com/"
    }
}
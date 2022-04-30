package ca.sudbury.hojat.photofinder.framework.web


import ca.sudbury.hojat.core.data.PhotoDataSource
import ca.sudbury.hojat.core.domain.Photo
import ca.sudbury.hojat.photofinder.framework.web.data.UnsplashJSON
import ca.sudbury.hojat.photofinder.toPhoto
import io.reactivex.Observable
import retrofit2.Response
import kotlin.properties.ObservableProperty

/**
 * Created by Hojat Ghasemi at 2022-04-24
 * contact the author at "https://github.com/hojat72elect"
 */
class RemotePhotoDataSource() : PhotoDataSource {
    private val accessKey = "_htwco9giNp8TaA8kshIB3VP0eUZq5Y4pFWHLQuNPRU"

    override suspend fun getPhotos(): List<Photo> {

        val photosList = mutableListOf<Photo>()


        val JSONBody = NetworkEndpoints.getRetrofitInstance()
            .create(NetworkEndpoints::class.java)
            .getPhotos()
            .body()
            ?.listIterator()

        if (JSONBody != null) {
            while (JSONBody.hasNext()) {
                val nextPhoto = JSONBody.next().toPhoto()
                photosList.add(nextPhoto)
            }
        }
        return photosList
    }

    override suspend fun getPhoto(uuid: String): Photo {
        TODO("Not yet implemented")
    }

    override suspend fun deletePhoto(photo: Photo) {
        TODO("this function doesn't imply in this situation")
    }

    override suspend fun addPhoto(photo: Photo) {
        TODO("this function doesn't imply in this situation")
    }


}
package ca.sudbury.hojat.photofinder.framework


import ca.sudbury.hojat.core.data.PhotoDataSource
import ca.sudbury.hojat.core.domain.Photo
import ca.sudbury.hojat.photofinder.framework.web.RemoteDataSource
import ca.sudbury.hojat.photofinder.toPhoto

/**
 * Created by Hojat Ghasemi at 2022-04-24
 * contact the author at "https://github.com/hojat72elect"
 */
class PhotoDataSourceImpl() : PhotoDataSource {
    override suspend fun getPhotos(): List<Photo> {

        val photosList = mutableListOf<Photo>()

        val JSONBody = RemoteDataSource.getRetrofitInstance()
            .create(RemoteDataSource::class.java)
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

}
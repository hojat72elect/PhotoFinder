package ca.sudbury.hojat.photofinder.framework


import ca.sudbury.hojat.core.data.PhotoDataSource
import ca.sudbury.hojat.core.domain.Photo
import ca.sudbury.hojat.photofinder.framework.web.NetworkModel

/**
 * Created by Hojat Ghasemi at 2022-04-24
 * contact the author at "https://github.com/hojat72elect"
 */
class PhotoDataSourceImpl() : PhotoDataSource {
    override suspend fun getAllPhotos(): List<Photo> {

        val photosList = mutableListOf<Photo>()

        val JSONBody = NetworkModel.getRetrofitInstance()
            .create(NetworkModel::class.java)
            .getPhotos()
            .body()
            ?.listIterator()

        if (JSONBody != null) {
            while (JSONBody.hasNext()) {
                val nextUnsplashPhoto = JSONBody.next()
                val nextPhoto = Photo(
                    nextUnsplashPhoto.id,
                    nextUnsplashPhoto.likes ?: 0,
                    nextUnsplashPhoto.description,
                    nextUnsplashPhoto.urls?.full,
                    nextUnsplashPhoto.urls?.regular
                )

                photosList.add(nextPhoto)

            }
        }
        return photosList
    }
}
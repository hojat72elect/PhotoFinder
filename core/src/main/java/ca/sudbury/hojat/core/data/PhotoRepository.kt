package ca.sudbury.hojat.core.data

/**
 * Created by Hojat Ghasemi at 2022-04-24
 * Contact the author at "https://github.com/hojat72elect"
 */
class PhotoRepository(private val photoDataSource: PhotoDataSource) {
    fun getPhotos() = photoDataSource.getAll()
}
package ca.sudbury.hojat.photofinder.framework

import ca.sudbury.hojat.core.domain.Photo
import ca.sudbury.hojat.photofinder.framework.db.PhotoDAO
import ca.sudbury.hojat.photofinder.toPhoto
import ca.sudbury.hojat.photofinder.toPhotoEntity

/**
 * Created by Hojat Ghasemi at 2022-04-28
 * Contact the author at "https://github.com/hojat72elect"
 */
class PhotoRepository(
    private val roomDataSource: PhotoDAO,
//    private val remoteDataSource: RemoteDataSource
) {

    fun getAllRoomPhotos() = roomDataSource.getAllPhotos()

    fun getRoomPhoto(photoID: String) = roomDataSource.getPhoto(photoID).toPhoto()

    suspend fun deleteRoomPhoto(photo: Photo) = roomDataSource.deletePhoto(photo.toPhotoEntity())

    suspend fun addRoomPhoto(photo: Photo) = roomDataSource.insertPhoto(photo.toPhotoEntity())

//    suspend fun getAllRemotePhotos() = remoteDataSource.getPhotos()
}
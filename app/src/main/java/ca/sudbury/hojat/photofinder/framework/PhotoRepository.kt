package ca.sudbury.hojat.photofinder.framework

//import ca.sudbury.hojat.core.domain.Photo
//import ca.sudbury.hojat.photofinder.framework.db.RoomPhotoDataSource
import ca.sudbury.hojat.photofinder.framework.web.RemotePhotoDataSource

/**
 * Created by Hojat Ghasemi at 2022-04-28
 * Contact the author at "https://github.com/hojat72elect"
 */
class PhotoRepository(
//    private val roomPhotoDataSource: RoomPhotoDataSource,
    private val remotePhotoDataSource: RemotePhotoDataSource
) {

//    suspend fun getAllRoomPhotos() = roomPhotoDataSource.getPhotos()

//    suspend fun getRoomPhoto(photoID: String) = roomPhotoDataSource.getPhoto(photoID)

//    suspend fun deleteRoomPhoto(photo: Photo) = roomPhotoDataSource.deletePhoto(photo)

//    suspend fun addRoomPhoto(photo: Photo) = roomPhotoDataSource.addPhoto(photo)

    suspend fun getAllRemotePhotos() = remotePhotoDataSource.getPhotos()
}
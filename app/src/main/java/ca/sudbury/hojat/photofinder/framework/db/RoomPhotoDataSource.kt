package ca.sudbury.hojat.photofinder.framework.db

import android.content.Context
import ca.sudbury.hojat.core.data.PhotoDataSource
import ca.sudbury.hojat.core.domain.Photo
import ca.sudbury.hojat.photofinder.toPhoto
import ca.sudbury.hojat.photofinder.toPhotoEntity

/**
 * Created by Hojat Ghasemi at 2022-04-29
 * Contact the author at "https://github.com/hojat72elect"
 */
class RoomPhotoDataSource(context: Context) : PhotoDataSource {

    private val photoDAO = PhotoDatabase.getInstance(context).photoDao()


    override suspend fun getPhotos(): List<Photo> = photoDAO.getAllPhotos().map {
        it.toPhoto()
    }

    override suspend fun getPhoto(uuid: String): Photo = photoDAO.getPhoto(uuid).toPhoto()

    override suspend fun deletePhoto(photo: Photo) = photoDAO.deletePhoto(photo.toPhotoEntity())

    override suspend fun addPhoto(photo: Photo) = photoDAO.insertPhoto(photo.toPhotoEntity())

}
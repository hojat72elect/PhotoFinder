package ca.sudbury.hojat.core.data

import ca.sudbury.hojat.core.domain.Photo
import kotlin.properties.ObservableProperty

/**
 * Created by Hojat Ghasemi at 2022-04-24
 * Contact the author at "https://github.com/hojat72elect"
 */
interface PhotoDataSource {

    suspend fun getPhotos(): List<Photo>

    suspend fun getPhoto(uuid: String): Photo

    suspend fun deletePhoto(photo: Photo)

    suspend fun addPhoto(photo: Photo)


}
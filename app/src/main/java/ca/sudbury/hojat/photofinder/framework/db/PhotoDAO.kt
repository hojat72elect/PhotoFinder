package ca.sudbury.hojat.photofinder.framework.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

/**
 * Created by Hojat Ghasemi at 2022-04-28
 * Contact the author at "https://github.com/hojat72elect"
 *
 * just a DAO for our photos in the Room database.
 */
@Dao
interface PhotoDAO {

    @Insert(onConflict = REPLACE)
    suspend fun insertPhoto(photo: PhotoEntity)

    @Delete
    suspend fun deletePhoto(photo: PhotoEntity)

    @Query("SELECT * FROM photo_data_table")
    fun getAllPhotos(): List<PhotoEntity>

    @Query("SELECT * FROM photo_data_table WHERE photo_uuid = :uuid")
    fun getMyPhoto(uuid: String): PhotoEntity
}
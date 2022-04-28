package ca.sudbury.hojat.photofinder.framework.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

/**
 * Created by Hojat Ghasemi at 2022-04-28
 * Contact the author at "https://github.com/hojat72elect"
 */
@Dao
interface RoomDataSource {

    @Insert(onConflict = REPLACE)
    suspend fun insertPhoto(photo: PhotoEntity)

    @Delete
    suspend fun deletePhoto(photo: PhotoEntity)

    @Query("SELECT * FROM photo_data_table")
    fun getAllPhotos(): LiveData<List<PhotoEntity>>

    @Query("SELECT * FROM photo_data_table WHERE photo_uuid = :uuid")
    fun getPhoto(uuid: String): PhotoEntity
}
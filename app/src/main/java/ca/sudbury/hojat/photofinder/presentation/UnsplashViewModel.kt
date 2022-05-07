package ca.sudbury.hojat.photofinder.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import ca.sudbury.hojat.core.domain.Photo
import ca.sudbury.hojat.photofinder.framework.PhotoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Hojat Ghasemi at 2022-04-26
 * Contact the author at "https://github.com/hojat72elect"
 */
class UnsplashViewModel(application: Application, private val repository: PhotoRepository) :
    AndroidViewModel(application) {


    fun getAllRemotePhotos() = liveData(Dispatchers.IO) {
        emit(repository.getAllRemotePhotos())
    }

//    fun getAllRoomPhotos() = liveData(Dispatchers.IO) {
//        emit(repository.getAllRoomPhotos())
//    }

//    fun getRoomPhoto(photoId: String) = liveData(Dispatchers.IO) {
//        emit(repository.getRoomPhoto(photoId))
//    }

//    fun deleteRoomPhoto(photo: Photo) {
//        viewModelScope.launch {
//            repository.deleteRoomPhoto(photo)
//        }
//    }

//    fun addRoomPhoto(photo: Photo) {
//        viewModelScope.launch {
//            repository.addRoomPhoto(photo)
//        }
//    }
}
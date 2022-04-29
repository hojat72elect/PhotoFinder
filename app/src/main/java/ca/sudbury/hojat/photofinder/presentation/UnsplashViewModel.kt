package ca.sudbury.hojat.photofinder.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import ca.sudbury.hojat.photofinder.framework.web.RemotePhotoDataSource
import kotlinx.coroutines.Dispatchers

/**
 * Created by Hojat Ghasemi at 2022-04-26
 * Contact the author at "https://github.com/hojat72elect"
 */
class UnsplashViewModel(private val repository: RemotePhotoDataSource) : ViewModel() {

    fun getAllPhotos() = liveData(Dispatchers.IO) {
        emit(repository.getPhotos())
    }

}
package ca.sudbury.hojat.photofinder.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import ca.sudbury.hojat.core.domain.Photo
import ca.sudbury.hojat.photofinder.framework.PhotoDataSourceImpl
import kotlinx.coroutines.Dispatchers

/**
 * Created by Hojat Ghasemi at 2022-04-26
 * Contact the author at "https://github.com/hojat72elect"
 */
class UnsplashViewModel(private val repository: PhotoDataSourceImpl) : ViewModel() {

    fun getAllPhotos() = liveData(Dispatchers.IO) {
        emit(repository.getAll())
    }

}
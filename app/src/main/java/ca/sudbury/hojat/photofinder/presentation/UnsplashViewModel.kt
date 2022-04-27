package ca.sudbury.hojat.photofinder.presentation

import androidx.lifecycle.ViewModel
import ca.sudbury.hojat.core.domain.Photo
import ca.sudbury.hojat.photofinder.framework.PhotoDataSourceImpl

/**
 * Created by Hojat Ghasemi at 2022-04-26
 * Contact the author at "https://github.com/hojat72elect"
 */
class UnsplashViewModel(private val repository: PhotoDataSourceImpl) : ViewModel() {

    fun getAllPhotos(): List<Photo> {
        return repository.getAll()
    }
}
package ca.sudbury.hojat.photofinder.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ca.sudbury.hojat.photofinder.domain.PhotoRepository

/**
 * Created by Hojat Ghasemi at 2022-05-16
 * Contact the author at "https://github.com/hojat72elect"
 *
 * this factory uses the [PhotoRepository] to create an
 * instance of The [PhotoViewModel].
 */

class PhotoViewModelFactory constructor(private val repository: PhotoRepository) :
    ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PhotoViewModel::class.java)) {
            return PhotoViewModel(repository) as T
        } else {
            throw IllegalArgumentException("The ViewModel class should be assignable from PhotoViewModel")
        }
    }
}
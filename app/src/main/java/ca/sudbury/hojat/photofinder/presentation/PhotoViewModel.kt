package ca.sudbury.hojat.photofinder.presentation

import androidx.lifecycle.ViewModel
import ca.sudbury.hojat.photofinder.PhotoFinder
import ca.sudbury.hojat.photofinder.domain.PhotoRepository

/**
 * Created by Hojat Ghasemi at 2022-05-16
 * Contact the author at "https://github.com/hojat72elect"
 */
class PhotoViewModel(private val repository: PhotoRepository) : ViewModel() {

    fun getAllPhotos() = repository.loadPhotos(PhotoFinder.getPageSize())
}
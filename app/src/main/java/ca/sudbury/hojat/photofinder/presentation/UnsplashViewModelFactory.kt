package ca.sudbury.hojat.photofinder.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ca.sudbury.hojat.photofinder.framework.PhotoDataSourceImpl

/**
 * Created by Hojat Ghasemi at 2022-04-26
 * Contact the author at "https://github.com/hojat72elect"
 */
class UnsplashViewModelFactory(private val repository: PhotoDataSourceImpl) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        // boilerplate that will be used for all ViewModel factories
        if (modelClass.isAssignableFrom(UnsplashViewModel::class.java)) {
            return UnsplashViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }
}
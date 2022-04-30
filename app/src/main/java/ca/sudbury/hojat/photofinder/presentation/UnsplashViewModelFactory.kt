package ca.sudbury.hojat.photofinder.presentation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ca.sudbury.hojat.photofinder.framework.PhotoRepository

/**
 * Created by Hojat Ghasemi at 2022-04-26
 * Contact the author at "https://github.com/hojat72elect"
 */
object UnsplashViewModelFactory : ViewModelProvider.Factory {

    lateinit var application: Application
    lateinit var repository: PhotoRepository


    fun inject(application: Application, repository: PhotoRepository) {
        UnsplashViewModelFactory.application = application
        UnsplashViewModelFactory.repository = repository
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (UnsplashViewModel::class.java.isAssignableFrom(modelClass)) {
            return modelClass.getConstructor(Application::class.java, repository::class.java)
                .newInstance(
                    application,
                    repository
                )
        } else {
            throw IllegalStateException("ViewModel must extend UnsplahViewModel")
        }
    }
}
package ca.sudbury.hojat.photofinder.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import ca.sudbury.hojat.photofinder.Injector
import ca.sudbury.hojat.photofinder.data.UnsplashPhoto
import ca.sudbury.hojat.photofinder.domain.PhotoRepository
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Created by Hojat Ghasemi at 2022-05-16
 * Contact the author at "https://github.com/hojat72elect"
 */
class PhotoViewModel(private val repository: PhotoRepository) : ViewModel() {

    private val mPhotosLiveData = MutableLiveData<PagedList<UnsplashPhoto>>()
    val photosLiveData: LiveData<PagedList<UnsplashPhoto>> get() = mPhotosLiveData

    fun registerPhotosLiveData() = repository
        .loadPhotos(Injector.getPageSize())
        .subscribe(object : Observer<PagedList<UnsplashPhoto>> {
            override fun onSubscribe(d: Disposable) {
                //todo: take care of the disposable
            }

            override fun onNext(value: PagedList<UnsplashPhoto>) {
                mPhotosLiveData.postValue(value)

            }

            override fun onError(e: Throwable) {
                Log.e("Error in PhotoViewModel", e.message.toString())
            }

            override fun onComplete() {
                // nothing for now
            }
        })
}
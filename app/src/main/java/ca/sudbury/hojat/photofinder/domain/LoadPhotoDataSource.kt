package ca.sudbury.hojat.photofinder.domain

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import ca.sudbury.hojat.photofinder.Injector
import ca.sudbury.hojat.photofinder.data.NetworkEndpoints
import ca.sudbury.hojat.photofinder.data.UnsplashPhoto
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import retrofit2.Response

/**
 * Created by Hojat Ghasemi at 2022-05-16
 * Contact the author at "https://github.com/hojat72elect"
 */
class LoadPhotoDataSource(private val networkEndpoints: NetworkEndpoints) :
    PageKeyedDataSource<Int, UnsplashPhoto>() {

    private val TAG = "LoadPhotoDataSource"
    val networkState = MutableLiveData<NetworkState>()
    private var totalPages: Int? = null

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, UnsplashPhoto>
    ) {
        //first time that a page is being loaded
        networkState.postValue(NetworkState.LOADING)
        networkEndpoints.loadPhotos(
            Injector.accessKey,
            1,
            params.requestedLoadSize
        ).subscribe(
            object : Observer<Response<List<UnsplashPhoto>>> {
                override fun onSubscribe(d: Disposable) {
                    // we don't keep the disposable
                }

                override fun onNext(response: Response<List<UnsplashPhoto>>) {
                    if (response.isSuccessful) {
                        totalPages = response.headers()["x-total"]?.toInt()
                            ?.div(params.requestedLoadSize)
                        callback.onResult(response.body()!!, null, 2)
                        networkState.postValue(NetworkState.SUCCESS)
                    } else {
                        // the result of the network call was an error.
                        networkState.postValue(NetworkState.error(response.message()))
                        Log.e(TAG, response.message())

                    }
                }

                override fun onError(e: Throwable) {
                    networkState.postValue(NetworkState.error(e.message))
                    Log.e(TAG, e.message.toString())
                }

                override fun onComplete() {
                    // do nothing on this terminal event
                }

            }
        )

    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, UnsplashPhoto>
    ) {
        // all the future pages of the response that are being loaded.
        networkState.postValue(NetworkState.LOADING)
        networkEndpoints.loadPhotos(
            Injector.accessKey,
            params.key,
            params.requestedLoadSize
        ).subscribe(object : Observer<Response<List<UnsplashPhoto>>> {
            override fun onSubscribe(d: Disposable) {
                // we don't keep the disposable
            }

            override fun onNext(response: Response<List<UnsplashPhoto>>) {
                if (response.isSuccessful) {
                    val nextPage = if (params.key == totalPages) null else params.key + 1
                    callback.onResult(response.body()!!, nextPage)
                    networkState.postValue(NetworkState.SUCCESS)
                } else {
                    // The response wasn't successful
                    networkState.postValue(NetworkState.error(response.message()))
                    Log.e(TAG, response.message())


                }
            }

            override fun onError(e: Throwable) {
                networkState.postValue(NetworkState.error(e.message))
                Log.e(TAG, e.message.toString())
            }

            override fun onComplete() {
                // do nothing on this terminal event
            }
        })


    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, UnsplashPhoto>) {
        // we do nothing here because everything will be loaded
    }


}
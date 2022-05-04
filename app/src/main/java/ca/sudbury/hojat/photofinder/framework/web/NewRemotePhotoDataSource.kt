package ca.sudbury.hojat.photofinder.framework.web

import android.util.Log
import androidx.paging.PageKeyedDataSource
import ca.sudbury.hojat.photofinder.framework.PhotoFinderApplication
import ca.sudbury.hojat.photofinder.framework.web.newdata.NewUnsplashPhoto
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import retrofit2.Response

/**
 * Created by Hojat Ghasemi at 2022-05-03
 * Contact the author at "https://github.com/hojat72elect"
 */
class NewRemotePhotoDataSource(private val networkEndpoints: NetworkEndpoints) :
    PageKeyedDataSource<Int, NewUnsplashPhoto>() {

    private var lastPage: Int? = null


    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, NewUnsplashPhoto>
    ) {
        // API call for the first page (page number is 1)
        networkEndpoints.loadPhotosObservable(
            PhotoFinderApplication().accessKey,
            1,
            params.requestedLoadSize
        )
            .subscribe(
                object : Observer<Response<List<NewUnsplashPhoto>>> {
                    override fun onSubscribe(d: Disposable) {
                        //todo: we can keep the disposable
                        // and dispose it when we longer need it.
                    }

                    override fun onNext(response: Response<List<NewUnsplashPhoto>>) {
                        if (response.isSuccessful) {
                            // Calculates total number of pages which need to be loaded
                            lastPage = response.headers()["x-total"]?.toInt()
                                ?.div(params.requestedLoadSize)
                            callback.onResult(response.body()!!, null, 2)
                        } else {
                            Log.e("error_PhotoDataSource", response.message())
                        }
                    }

                    override fun onError(e: Throwable) {
                        Log.e("error_PhotoDataSource", e.message.toString())
                    }

                    override fun onComplete() {
                        // doing nothing on this terminal event
                    }

                }
            )

    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, NewUnsplashPhoto>
    ) {
        // API call for the subsequent pages
        networkEndpoints.loadPhotosObservable(
            PhotoFinderApplication().accessKey,
            params.key,
            params.requestedLoadSize
        ).subscribe(
            object : Observer<Response<List<NewUnsplashPhoto>>> {
                override fun onSubscribe(d: Disposable) {
                    //todo: it's better to keep the disposable so
                    // we can get rid of possible memory leaks down
                    // the road.
                }

                override fun onNext(response: Response<List<NewUnsplashPhoto>>) {
                    if (response.isSuccessful) {
                        val nextPage = if (params.key == lastPage) null else params.key + 1
                        callback.onResult(response.body()!!, nextPage)
                    } else {
                        // Some error has occured
                        Log.e("error_PhotoDataSource", response.message())
                    }

                }

                override fun onError(e: Throwable) {
                    Log.e("error_PhotoDataSource", e.message.toString())
                }

                override fun onComplete() {
                    // doing nothing in this terminal event.
                }

            }
        )

    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, NewUnsplashPhoto>
    ) {
        // doing nothing in here.
    }

}
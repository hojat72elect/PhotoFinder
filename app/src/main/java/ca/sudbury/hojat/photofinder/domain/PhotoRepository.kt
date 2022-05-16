package ca.sudbury.hojat.photofinder.domain

import androidx.paging.PagedList
import androidx.paging.RxPagedListBuilder
import ca.sudbury.hojat.photofinder.data.NetworkEndpoints
import ca.sudbury.hojat.photofinder.data.UnsplashPhoto
import io.reactivex.Observable

/**
 * Created by Hojat Ghasemi at 2022-05-16
 * Contact the author at "https://github.com/hojat72elect"
 *
 * used by ViewModels to fetch data.
 */
class PhotoRepository constructor(private val networkEndpoints: NetworkEndpoints) {

    fun loadPhotos(pageSize: Int):Observable<PagedList<UnsplashPhoto>> {
        return RxPagedListBuilder(
            LoadPhotoDataSourceFactory(networkEndpoints),
            PagedList.Config.Builder()
                .setInitialLoadSizeHint(pageSize)
                .setPageSize(pageSize)
                .build()
        ).buildObservable()
    }
}
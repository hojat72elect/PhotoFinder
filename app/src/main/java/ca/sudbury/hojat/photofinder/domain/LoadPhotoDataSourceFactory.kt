package ca.sudbury.hojat.photofinder.domain

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import ca.sudbury.hojat.photofinder.data.NetworkEndpoints
import ca.sudbury.hojat.photofinder.data.UnsplashPhoto

/**
 * Created by Hojat Ghasemi at 2022-05-16
 * Contact the author at "https://github.com/hojat72elect"
 *
 * Android paging library data source factory.
 * This will create the load photo data source.
 */
class LoadPhotoDataSourceFactory constructor(private val networkEndpoints: NetworkEndpoints) :
    DataSource.Factory<Int, UnsplashPhoto>() {

    val sourceLiveData = MutableLiveData<LoadPhotoDataSource>()

    override fun create(): DataSource<Int, UnsplashPhoto> {
        // The data source is firstly loaded into a
        // MutableLiveData and then goes to the place
        // that has used this factory for getting access
        // to it.
        val source = LoadPhotoDataSource(networkEndpoints)
        sourceLiveData.postValue(source)
        return source
    }

}
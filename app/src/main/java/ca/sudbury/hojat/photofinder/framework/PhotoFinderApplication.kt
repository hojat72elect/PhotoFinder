package ca.sudbury.hojat.photofinder.framework

import android.app.Application
//import ca.sudbury.hojat.photofinder.framework.db.RoomPhotoDataSource
import ca.sudbury.hojat.photofinder.framework.web.RemotePhotoDataSource
import ca.sudbury.hojat.photofinder.presentation.UnsplashViewModelFactory

/**
 * Created by Hojat Ghasemi at 2022-04-29
 * Contact the author at "https://github.com/hojat72elect"
 */
class PhotoFinderApplication : Application() {

internal val accessKey="_htwco9giNp8TaA8kshIB3VP0eUZq5Y4pFWHLQuNPRU"
internal val secretKey="2LCXsb9sP2coqIQ0McGNzgWJZsPVLL6Lcvr-HGO5Ydc"

    override fun onCreate() {
        super.onCreate()
        val photoRepository = PhotoRepository(
//            RoomPhotoDataSource(this),
            RemotePhotoDataSource())

        UnsplashViewModelFactory.inject(this, photoRepository)

    }
}
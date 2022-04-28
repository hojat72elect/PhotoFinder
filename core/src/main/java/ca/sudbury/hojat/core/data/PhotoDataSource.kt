package ca.sudbury.hojat.core.data

import ca.sudbury.hojat.core.domain.Photo

/**
 * Created by Hojat Ghasemi at 2022-04-24
 * Contact the author at "https://github.com/hojat72elect"
 */
interface PhotoDataSource {

    // get a List of all the photos to be displayed in main page.
    suspend fun getAllPhotos(): List<Photo>
}
package ca.sudbury.hojat.photofinder.framework.web.newdata

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Hojat Ghasemi at 2022-05-03
 * Contact the author at "https://github.com/hojat72elect"
 */
@Parcelize
data class NewUnsplashLinks(
    val self: String,
    val html: String,
    val photos: String?,
    val likes: String?,
    val portfolio: String?,
    val download: String?,
    val download_location: String?
) : Parcelable

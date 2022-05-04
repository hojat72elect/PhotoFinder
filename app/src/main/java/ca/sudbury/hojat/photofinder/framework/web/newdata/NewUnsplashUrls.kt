package ca.sudbury.hojat.photofinder.framework.web.newdata

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Hojat Ghasemi at 2022-05-03
 * Contact the author at "https://github.com/hojat72elect"
 */
@Parcelize
data class NewUnsplashUrls(
    val thumb: String?,
    val small: String,
    val medium: String?,
    val regular: String?,
    val large: String?,
    val full: String?,
    val raw: String?
) : Parcelable

package ca.sudbury.hojat.photofinder.framework.web.newdata

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 *
 *Created by Hojat Ghasemi at 2022-05-03
 *
 *contact the author at "https://github.com/hojat72elect"
 *
 */
@Parcelize
data class NewUnsplashPhoto(
    val id: String,
    val created_at: String,
    val width: Int,
    val height: Int,
    val color: String? = "#000000",
    val likes: Int,
    val description: String?,
    val urls: NewUnsplashUrls,
    val links: NewUnsplashLinks,
    val user: NewUnsplashUser
) : Parcelable


package ca.sudbury.hojat.photofinder.framework.web.newdata

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Hojat Ghasemi at 2022-05-03
 * Contact the author at "https://github.com/hojat72elect"
 */
@Parcelize
data class NewUnsplashUser(
    val id: String,
    val username: String,
    val name: String,
    val portfolio_url: String?,
    val bio: String?,
    val location: String?,
    val total_likes: Int,
    val total_photos: Int,
    val total_collection: Int,
    val profile_image: NewUnsplashUrls,
    val links: NewUnsplashLinks
) : Parcelable

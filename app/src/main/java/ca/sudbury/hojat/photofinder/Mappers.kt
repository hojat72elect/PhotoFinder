package ca.sudbury.hojat.photofinder

import ca.sudbury.hojat.core.domain.Photo
import ca.sudbury.hojat.core.domain.Photographer
import ca.sudbury.hojat.core.domain.SocialHandles
import ca.sudbury.hojat.photofinder.framework.db.PhotoEntity
import ca.sudbury.hojat.photofinder.framework.web.data.SocialX
import ca.sudbury.hojat.photofinder.framework.web.data.UnsplashPhoto
import ca.sudbury.hojat.photofinder.framework.web.data.User

/**
 * Created by Hojat Ghasemi at 2022-04-28
 * Contact the author at "https://github.com/hojat72elect"
 *
 * All the mappers used throughout this project.
 */

fun UnsplashPhoto.toPhoto(): Photo {
    return Photo(
        this.id,
        this.likes ?: 0,
        this.description,
        this.urls?.full,
        this.urls?.regular
    )
}

fun User.toPhotographer(): Photographer {

    return Photographer(
        this.id,
        this.username,
        this.name,
        this.bio,
        this.location,
        this.total_likes,
        this.total_photos,
        this.total_collections,
        this.profile_image?.medium,
        this.for_hire,
        this.social?.toSocialHandles()
    )


}

fun SocialX.toSocialHandles(): SocialHandles {
    return SocialHandles(
        this.instagram_username,
        this.paypal_email.toString(),
        this.portfolio_url,
        this.twitter_username.toString()

    )
}

fun Photo.toPhotoEntity(): PhotoEntity {
    return PhotoEntity(
        this.id ?: "",
        this.likes,
        this.description ?: "",
        this.url_full ?: "",
        this.url_regular ?: ""
    )
}

fun PhotoEntity.toPhoto(): Photo {
    return Photo(
        this.uuid,
        this.likes,
        this.description,
        this.url_full,
        this.url_regular
    )
}
package ca.sudbury.hojat.photofinder

import ca.sudbury.hojat.core.domain.Photo
import ca.sudbury.hojat.photofinder.framework.web.data.UnsplashPhoto

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
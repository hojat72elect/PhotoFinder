package ca.sudbury.hojat.core.domain

/**
 * Created by Hojat Ghasemi at 2022-04-24
 * Contact the author at "https://github.com/hojat72elect"
 *
 * The main data object that will be used throughout the project.
 *
 */

data class Photo(
    val id: String?,
    val likes: Int,
    val description: String?,
    val url_full: String?,
    val url_regular: String?,
)

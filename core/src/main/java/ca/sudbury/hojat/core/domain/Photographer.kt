package ca.sudbury.hojat.core.domain

/**
 * Created by Hojat Ghasemi at 2022-04-24
 * Contact the author at "https://github.com/hojat72elect"
 */
data class Photographer(
    val id: String?,
    val username: String?,
    val name: String?,
    val bio: String?,
    val location: String?,
    val total_likes: Int?,
    val total_photos: Int?,
    val total_collections: Int?,
    val profile_image: String?,
    val for_hire: Boolean?,
    val social: SocialHandles?
)

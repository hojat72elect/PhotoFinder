package ca.sudbury.hojat.photofinder.framework.web.data

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("accepted_tos")
    val accepted_tos: Boolean?,
    @SerializedName("bio")
    val bio: String?,
    @SerializedName("first_name")
    val first_name: String?,
    @SerializedName("for_hire")
    val for_hire: Boolean?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("instagram_username")
    val instagram_username: String?,
    @SerializedName("last_name")
    val last_name: String?,
    @SerializedName("links")
    val links: LinksXX?,
    @SerializedName("location")
    val location: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("portfolio_url")
    val portfolio_url: String?,
    @SerializedName("profile_image")
    val profile_image: ProfileImageX?,
    @SerializedName("social")
    val social: SocialX?,
    @SerializedName("total_collections")
    val total_collections: Int?,
    @SerializedName("total_likes")
    val total_likes: Int?,
    @SerializedName("total_photos")
    val total_photos: Int?,
    @SerializedName("twitter_username")
    val twitter_username: Any?,
    @SerializedName("updated_at")
    val updated_at: String?,
    @SerializedName("username")
    val username: String?
)
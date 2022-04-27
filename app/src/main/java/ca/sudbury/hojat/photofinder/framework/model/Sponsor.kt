package ca.sudbury.hojat.photofinder.framework.model

import com.google.gson.annotations.SerializedName

data class Sponsor(
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
    val last_name: Any?,
    @SerializedName("links")
    val links: LinksX?,
    @SerializedName("location")
    val location: Any?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("portfolio_url")
    val portfolio_url: String?,
    @SerializedName("profile_image")
    val profile_image: ProfileImage?,
    @SerializedName("social")
    val social: Social?,
    @SerializedName("total_collections")
    val total_collections: Int?,
    @SerializedName("total_likes")
    val total_likes: Int?,
    @SerializedName("total_photos")
    val total_photos: Int?,
    @SerializedName("twitter_username")
    val twitter_username: String?,
    @SerializedName("updated_at")
    val updated_at: String?,
    @SerializedName("username")
    val username: String?
)
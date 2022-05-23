package ca.sudbury.hojat.photofinder.data.datamodel


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Photo(
    @Json(name = "aperture")
    val aperture: String?,
    @Json(name = "camera")
    val camera: String?,
    @Json(name = "category")
    val category: Int?,
    @Json(name = "comments_count")
    val commentsCount: Int?,
    @Json(name = "created_at")
    val createdAt: String?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "editored_by")
    val editoredBy: Any?,
    @Json(name = "editors_choice")
    val editorsChoice: Boolean?,
    @Json(name = "editors_choice_date")
    val editorsChoiceDate: Any?,
    @Json(name = "feature")
    val feature: String?,
    @Json(name = "feature_date")
    val featureDate: String?,
    @Json(name = "fill_switch")
    val fillSwitch: FillSwitch,
    @Json(name = "focal_length")
    val focalLength: String?,
    @Json(name = "has_nsfw_tags")
    val hasNsfwTags: Boolean,
    @Json(name = "height")
    val height: Int,
    @Json(name = "highest_rating")
    val highestRating: Double?,
    @Json(name = "highest_rating_date")
    val highestRatingDate: String?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "image_format")
    val imageFormat: String?,
    @Json(name = "image_url")
    val imageUrl: List<String>?,
    @Json(name = "images")
    val images: List<Image>,
    @Json(name = "iso")
    val iso: String?,
    @Json(name = "latitude")
    val latitude: Double?,
    @Json(name = "lens")
    val lens: String?,
    @Json(name = "liked")
    val liked: Any?,
    @Json(name = "location")
    val location: String?,
    @Json(name = "longitude")
    val longitude: Double?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "nsfw")
    val nsfw: Boolean?,
    @Json(name = "positive_votes_count")
    val positiveVotesCount: Int?,
    @Json(name = "privacy")
    val privacy: Boolean?,
    @Json(name = "privacy_level")
    val privacyLevel: Int?,
    @Json(name = "profile")
    val profile: Boolean?,
    @Json(name = "rating")
    val rating: Double?,
    @Json(name = "shutter_speed")
    val shutterSpeed: String?,
    @Json(name = "status")
    val status: Int?,
    @Json(name = "taken_at")
    val takenAt: Any?,
    @Json(name = "times_viewed")
    val timesViewed: Int?,
    @Json(name = "url")
    val url: String?,
    @Json(name = "user")
    val user: User?,
    @Json(name = "user_id")
    val userId: Int?,
    @Json(name = "voted")
    val voted: Any?,
    @Json(name = "votes_count")
    val votesCount: Int?,
    @Json(name = "watermark")
    val watermark: Boolean?,
    @Json(name = "width")
    val width: Int?
)
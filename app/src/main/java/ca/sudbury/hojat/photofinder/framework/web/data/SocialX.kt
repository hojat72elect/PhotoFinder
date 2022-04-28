package ca.sudbury.hojat.photofinder.framework.web.data

import com.google.gson.annotations.SerializedName

data class SocialX(
    @SerializedName("instagram_username")
    val instagram_username: String?,
    @SerializedName("paypal_email")
    val paypal_email: Any?,
    @SerializedName("portfolio_url")
    val portfolio_url: String?,
    @SerializedName("twitter_username")
    val twitter_username: Any?
)
package ca.sudbury.hojat.photofinder.framework.web.data

import com.google.gson.annotations.SerializedName

data class ProfileImageX(
    @SerializedName("large")
    val large: String?,
    @SerializedName("medium")
    val medium: String?,
    @SerializedName("small")
    val small: String?
)
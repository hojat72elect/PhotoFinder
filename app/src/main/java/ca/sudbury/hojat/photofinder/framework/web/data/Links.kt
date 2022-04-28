package ca.sudbury.hojat.photofinder.framework.web.data

import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("download")
    val download: String?,
    @SerializedName("download_location")
    val download_location: String?,
    @SerializedName("html")
    val html: String?,
    @SerializedName("self")
    val self: String?
)
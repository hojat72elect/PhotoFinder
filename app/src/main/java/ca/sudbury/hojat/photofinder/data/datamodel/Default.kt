package ca.sudbury.hojat.photofinder.data.datamodel

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Default(
    @Json(name = "https")
    val https: String
)
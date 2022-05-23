package ca.sudbury.hojat.photofinder.data.datamodel


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Filters(
    @Json(name = "category")
    val category: Boolean?,
    @Json(name = "exclude")
    val exclude: Boolean?
)
package com.example.eventi.data.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiResponse(
    @field:Json(name = "count")
    var count: Int = 0,

    @field:Json(name = "overflow")
    var overflow: Boolean = false,

    @field:Json(name = "next")
    var next: String?,

    @field:Json(name = "previous")
    var previous: String?,

    @field:Json(name = "results")
    var results: List<EventResponse> = listOf(),
)
package com.example.eventi.data.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EventResponse(
    @field:Json(name = "id")
    var id: String,

    @field:Json(name = "title")
    var title: String,

    @field:Json(name = "description")
    var description: String,

    @field:Json(name = "category")
    var category: String,

    @field:Json(name = "start")
    var start: String,

    @field:Json(name = "end")
    var end: String,

    @field:Json(name = "updated")
    var updated: String,

    @field:Json(name = "timezone")
    var timezone: String,

    @field:Json(name = "duration")
    var duration: Int = 0,

    @field:Json(name = "rank")
    var rank: Int = 0,

    @field:Json(name = "local_rank")
    var localRank: Int = 0,

    @field:Json(name = "aviation_rank")
    var aviationRank: Int = 0,

    @field:Json(name = "country")
    var country: String,

    @field:Json(name = "location")
    var location: List<Double> = listOf()
)
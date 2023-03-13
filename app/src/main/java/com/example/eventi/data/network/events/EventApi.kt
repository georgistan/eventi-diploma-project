package com.example.eventi.data.network.events

import retrofit2.http.GET
import retrofit2.http.Query


interface EventApi {
    @GET("events")
    suspend fun getResponse(
        @Query("q") query: String
    ): ApiResponse
}

enum class EventApiStatus {
    LOADING,
    ERROR,
    DONE
}

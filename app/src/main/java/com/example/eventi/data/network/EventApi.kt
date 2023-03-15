package com.example.eventi.data.network

import retrofit2.http.GET
import retrofit2.http.Query


interface EventApi {
    @GET("events")
    suspend fun findEventsByCategory(
        @Query("q") category: String,
        @Query("sort") sortBy: String
    ): ApiResponse

    @GET("events")
    suspend fun findEventById(
        @Query("id") eventId: String
    ): ApiResponse
}

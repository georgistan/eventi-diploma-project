package com.example.eventi.data.network.events

import retrofit2.http.GET


interface EventApi {
    @GET("events/?q=sports/")
    suspend fun getResponse(): ApiResponse
}

enum class EventApiStatus {
    LOADING,
    ERROR,
    DONE
}

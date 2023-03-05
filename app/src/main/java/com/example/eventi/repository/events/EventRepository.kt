package com.example.eventi.repository.events

import com.example.eventi.data.network.events.Event

interface EventRepository {
    suspend fun getSingleEvent(title: String): Event
    suspend fun getEvents(): List<Event>
}

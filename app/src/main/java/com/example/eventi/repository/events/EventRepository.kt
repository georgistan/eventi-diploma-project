package com.example.eventi.repository.events

import com.example.eventi.data.network.Event
import com.example.eventi.data.network.EventResponse

interface EventRepository {
    suspend fun findEventsByCategory(category: String): List<Event>

    suspend fun findEventById(eventId: String): Event
}

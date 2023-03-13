package com.example.eventi.repository.events

import com.example.eventi.data.network.events.Event

interface EventRepository {
    suspend fun getEventsByCategory(category: String): List<Event>
}

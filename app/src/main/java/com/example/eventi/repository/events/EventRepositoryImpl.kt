package com.example.eventi.repository.events

import com.example.eventi.data.network.events.EventApi
import com.example.eventi.data.EntityMapper
import com.example.eventi.data.network.events.Event
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EventRepositoryImpl @Inject constructor(
    private val eventApi: EventApi
) : EventRepository, EntityMapper() {

    override suspend fun getEventsByCategory(category: String): List<Event> {
        return eventApi.getResponse(category).results.map { it.mapToDomain() }
    }

}

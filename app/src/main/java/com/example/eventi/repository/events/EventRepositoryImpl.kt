package com.example.eventi.repository.events

import com.example.eventi.data.network.events.EventApi
import com.example.eventi.data.network.events.EventResponse
import com.example.eventi.data.network.model.EntityMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EventRepositoryImpl @Inject constructor(
    private val eventApi: EventApi
) : EventRepository, EntityMapper() {

    override suspend fun getSingleEvent(title: String): Event {
        return eventApi.getResponse().results
            .map { it.mapToDomain() }
            .first{ it.title == title}
    }

    override suspend fun getEvents(): List<Event> {
        return eventApi.getResponse().results.map { it.mapToDomain() }
    }
}

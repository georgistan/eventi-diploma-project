package com.example.eventi.repository.events

import com.example.eventi.data.EntityMapper
import com.example.eventi.data.network.Event
import com.example.eventi.data.network.EventApi

class EventRepositoryImpl(
    private val eventApi: EventApi,
    private val mapper: EntityMapper
) : EventRepository {

    lateinit var responseResults: List<Event>

    override suspend fun findEventsByCategory(category: String): List<Event> {
        return mapper.mapToEventList(
            eventApi
                .findEventsByCategory(category = category, sortBy = "rank")
                .results
                .also {
                    responseResults = mapper.mapToEventList(it)
                }
        )
    }

    override suspend fun findEventById(eventId: String): Event {
        return mapper.mapToEvent(
            eventApi.findEventById(eventId).results.first()
        )
    }

}

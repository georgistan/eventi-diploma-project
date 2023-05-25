package com.example.eventi.repository.events

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.eventi.data.EntityMapper
import com.example.eventi.data.network.Event
import com.example.eventi.data.network.EventApi

class EventRepositoryImpl(
    private val eventApi: EventApi,
    private val mapper: EntityMapper
) : EventRepository {

    lateinit var responseResults: List<Event>

    @RequiresApi(Build.VERSION_CODES.O)
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

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun findEventById(eventId: String): Event {
        return mapper.mapToEvent(
            eventApi.findEventById(eventId).results.first()
        )
    }

}

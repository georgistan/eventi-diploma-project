package com.example.eventi.data.network.model

import com.example.eventi.data.network.events.EventResponse
import com.example.eventi.repository.events.Event

class EventMapper {
    fun EventResponse.mapToDomain(): Event {
        return Event(
            title = this.title,
            description = this.description,
            category = this.category,
            startsAt = this.start,
            predictedEnd = this.end,
            rank = this.rank
        )
    }
}
package com.example.eventi.data.network.model

import com.example.eventi.data.network.events.EventResponse
import com.example.eventi.repository.events.Event

open class EntityMapper {
    open fun EventResponse.mapToDomain(): Event {
        return Event(
            id = this.id,
            title = this.title,
            description = this.description,
            category = this.category,
            startsAt = this.start,
            predictedEnd = this.end,
            rank = this.rank
        )
    }
}
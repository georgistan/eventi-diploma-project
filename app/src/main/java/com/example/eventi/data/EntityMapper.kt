package com.example.eventi.data

import com.example.eventi.data.network.events.EventResponse
import com.example.eventi.data.network.events.Event
import com.example.eventi.data.local.interests.Interest
import com.example.eventi.data.local.interests.InterestEntity

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

    open fun mapFromInterestEntity(interestEntity: InterestEntity): Interest {
        return Interest(
            id = interestEntity.id,
            label = interestEntity.content.lowercase()
        )
    }

    open fun mapToInterestEntity(interest: Interest): InterestEntity {
        return InterestEntity(
            id = interest.id,
            content = interest.label.lowercase()
        )
    }
}
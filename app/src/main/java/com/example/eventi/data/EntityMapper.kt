package com.example.eventi.data

import com.example.eventi.data.local.events.RealmEvent
import com.example.eventi.data.network.EventResponse
import com.example.eventi.data.network.Event
import com.example.eventi.data.local.interests.Interest
import com.example.eventi.data.local.interests.InterestEntity

open class EntityMapper {
    fun mapToEvent(eventResponse: EventResponse): Event {
        return Event(
            id = eventResponse.id,
            title = eventResponse.title,
            description = eventResponse.description,
            category = eventResponse.category,
            startsAt = eventResponse.start,
            predictedEnd = eventResponse.end,
            rank = eventResponse.rank
        )
    } 
    
    fun mapToEventList(initial: List<EventResponse>): List<Event> {
        return initial.map { mapToEvent(it) }
    }

    fun mapFromInterestEntity(interestEntity: InterestEntity): Interest {
        return Interest(
            id = interestEntity.id,
            label = interestEntity.content.lowercase()
        )
    }

    fun mapToInterestEntity(interest: Interest): InterestEntity {
        return InterestEntity(
            id = interest.id,
            content = interest.label.lowercase()
        )
    }

    fun mapToRealmEvent(event: Event): RealmEvent {
        return RealmEvent(
            id = event.id,
            title = event.title,
            description = event.description,
            category = event.category,
            isAttended = true,
            startsAt = event.startsAt,
            predictedEnd = event.predictedEnd,
            rank = event.rank
        )
    }
    
    fun mapFromRealmEvent(realmEvent: RealmEvent): Event {
        return Event(
            id = realmEvent.id,
            title = realmEvent.title,
            description = realmEvent.description,
            category = realmEvent.category,
            startsAt = realmEvent.startsAt,
            predictedEnd = realmEvent.predictedEnd,
            rank = realmEvent.rank
        )
    }
}
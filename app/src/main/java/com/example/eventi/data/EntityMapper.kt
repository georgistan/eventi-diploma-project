package com.example.eventi.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.eventi.data.local.events.RealmEvent
import com.example.eventi.data.network.EventResponse
import com.example.eventi.data.network.Event
import com.example.eventi.data.local.interests.Interest
import com.example.eventi.data.local.interests.InterestEntity
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

open class EntityMapper {
    @RequiresApi(Build.VERSION_CODES.O)
    fun mapToEvent(eventResponse: EventResponse): Event {
        return Event(
            id = eventResponse.id,
            title = eventResponse.title,
            description = eventResponse.description,
            category = eventResponse.category,
            startsAt = formatDate(eventResponse.start),
            predictedEnd = formatDate(eventResponse.end),
            rank = eventResponse.rank
        )
    } 
    
    @RequiresApi(Build.VERSION_CODES.O)
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

@RequiresApi(Build.VERSION_CODES.O)
fun formatDate(date: String): String {
    val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
    val formattedDate = LocalDateTime.parse(date, dateFormatter)
    return DateTimeFormatter.ofPattern("MMMM dd, yyyy | hh:mma").format(formattedDate) // August 04, 2017 | 6:39pm
}
package com.example.eventi.data

import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.eventi.data.local.events.RealmEvent
import com.example.eventi.data.local.interests.Interest
import com.example.eventi.data.local.interests.InterestEntity
import com.example.eventi.data.network.Event
import com.example.eventi.data.network.EventResponse
import dagger.hilt.android.qualifiers.ApplicationContext
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import javax.inject.Inject

class EntityMapper @Inject constructor(
    @ApplicationContext context: Context
) {
    private val mContext = context
    @RequiresApi(Build.VERSION_CODES.O)
    fun mapToEvent(eventResponse: EventResponse): Event {
        return Event(
            id = eventResponse.id,
            title = eventResponse.title,
            description = eventResponse.description,
            category = eventResponse.category,
            startsAt = formatDate(eventResponse.start),
            predictedEnd = formatDate(eventResponse.end),
            rank = eventResponse.rank,
            address = formatAddress(eventResponse.location, mContext)
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
            rank = event.rank,
            address = event.address
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
            rank = realmEvent.rank,
            address = realmEvent.address
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
private fun formatDate(date: String): String {
    val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
    val formattedDate = LocalDateTime.parse(date, dateFormatter)
    return DateTimeFormatter.ofPattern("MMMM dd, yyyy | hh:mma")
        .format(formattedDate)
}
private fun formatAddress(addressCoordinates: List<Double>, context: Context): String {
    val geocoder = Geocoder(context, Locale.getDefault())

    if(addressCoordinates[1] !in -90.0..90.0 || addressCoordinates[0] !in -180.0..180.0) {
        return "Invalid address"
    }

    val addresses: List<Address> = geocoder.getFromLocation(
        addressCoordinates[1],
        addressCoordinates[0],
        1
    ) ?: listOf()

    if (addresses.isNotEmpty()) {
        if (addresses[0].getAddressLine(0) == null) {
            return "Most relevant address found was: " + addresses[0].countryName
        }

        return addresses[0]
            .getAddressLine(0)
            .split(",")
            .toMutableList()
            .reversed()
            .toString()
            .replace("[", "")
            .replace("]", "")
            .substring(1)
    }

    return "No exact address provided"
}
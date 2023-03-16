package com.example.eventi.repository.interests

import com.example.eventi.data.local.interests.Interest
import com.example.eventi.data.network.Event
import kotlinx.coroutines.flow.Flow

interface LocalStorageRepository {
    suspend fun addInterests(interests: List<Interest>)

    fun getInterests(): Flow<List<Interest>>

    suspend fun clearAllInterests()

    suspend fun manageEventAttendance(event: Event)

    suspend fun checkEventStored(eventId: String): Boolean

    suspend fun getEvents() : Flow<List<Event>>
}


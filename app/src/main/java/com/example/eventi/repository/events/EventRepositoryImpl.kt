package com.example.eventi.repository.events

import com.example.eventi.data.network.events.EventApi
import com.example.eventi.data.EntityMapper
import com.example.eventi.data.local.interests.InterestEntity
import com.example.eventi.data.network.events.Event
import com.example.eventi.di.DispatcherIO
import io.realm.Realm
import io.realm.kotlin.executeTransactionAwait
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class EventRepositoryImpl @Inject constructor(
    private val eventApi: EventApi
) : EventRepository, EntityMapper() {

    override suspend fun getEvents(): List<Event> {
        return eventApi.getResponse().results.map { it.mapToDomain() }
    }

}

package com.example.eventi.repository.events

interface EventRepository {
    suspend fun getSingleEvent(title: String): Event
    suspend fun getEvents(): List<Event>
}

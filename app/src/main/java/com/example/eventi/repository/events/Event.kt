package com.example.eventi.repository.events

// domain model
data class Event(
    val id: String,
    val title: String,
    val description: String,
    val category: String,
    val startsAt: String,
    val predictedEnd: String,
    val rank: Int
    // and so on..
)
package com.example.eventi.data.network.events

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
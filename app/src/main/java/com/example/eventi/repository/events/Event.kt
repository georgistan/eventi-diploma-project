package com.example.eventi.repository.events

// domain model
data class Event(
    var title: String,
    var description: String,
    var category: String,
    var startsAt: String,
    var predictedEnd: String,
    var rank: Int
    // and so on..
)
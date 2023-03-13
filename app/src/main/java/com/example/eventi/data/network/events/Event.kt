package com.example.eventi.data.network.events

data class Event(
    val id: String,
    val title: String,
    val description: String,
    val category: String,
    val startsAt: String,
    val predictedEnd: String,
    val rank: Int,
    var isAttended: Boolean = false
)
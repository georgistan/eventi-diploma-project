package com.example.eventi.data.network

data class Event(
    val id: String,
    val title: String,
    val description: String,
    val category: String,
    val startsAt: String,
    val predictedEnd: String,
    val rank: Int,
    val address: String,
    var isAttended: Boolean = false
) {
    constructor() : this("", "", "", "", "", "", 0, "", false)
}
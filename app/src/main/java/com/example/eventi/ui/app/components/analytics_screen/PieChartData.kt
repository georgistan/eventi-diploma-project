package com.example.eventi.ui.app.components.analytics_screen

data class PieChartData(
    var eventCategory: String?,
    var attendedEventsOfCategory: Float?
)

val getPieChartData = listOf(
    PieChartData("sports", 6f),
    PieChartData("expos", 1f),
    PieChartData("performing-arts", 2F),
    PieChartData("community", 10F),
)
package com.example.eventi.ui.app.components.analytics_screen

data class PieChartData(
    var browserName: String?,
    var value: Float?
)

val getPieChartData = listOf(
    PieChartData("sports", 34.68F),
    PieChartData("expos", 16.60F),
    PieChartData("performing-arts", 16.15F),
    PieChartData("community", 15.62F),
)
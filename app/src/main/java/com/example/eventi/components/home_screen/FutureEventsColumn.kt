package com.example.eventi.components.home_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FutureEventsColumn(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        SectionHeading(contentTitle = "This week")
        FutureEventElement(
            Event(
                id = 0,
                imagesList[0],
                "28.12.2022 20:30:00",
                title = "Music concert",
                eventType = EventType.LIVE
            )
        )
        Spacer(Modifier.height(16.dp))
        FutureEventElement(
            Event(
                id = 1,
                imagesList[1],
                "28.12.2022 20:30:00",
                title = "Wedding",
                eventType = EventType.LIVE
            )
        )
        Spacer(Modifier.height(16.dp))
        FutureEventElement(
            Event(
                id = 2,
                imagesList[2],
                "28.12.2022 20:30:00",
                title = "Rooftop party",
                eventType = EventType.ONLINE
            )
        )
        Spacer(Modifier.height(16.dp))
    }
}
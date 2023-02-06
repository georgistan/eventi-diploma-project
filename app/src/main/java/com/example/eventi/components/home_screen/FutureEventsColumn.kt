package com.example.eventi.components.home_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FutureEventsColumn(
    modifier: Modifier,
    onClickFutureEventElement: (Event) -> Unit,
    onClickViewAllButton: () -> Unit
) {
    Column(
        modifier = modifier
    ) {
        SectionHeading(
            modifier = modifier,
            contentTitle = "This week",
            onClick = onClickViewAllButton
        )
        FutureEventElement(
            modifier = modifier,
            Event(
                id = 0,
                imagesList[0],
                "28.12.2022 20:30:00",
                title = "Music concert",
                eventType = EventType.LIVE
            ),
            onClickEvent = onClickFutureEventElement
        )
        Spacer(modifier.height(16.dp))
        FutureEventElement(
            modifier = modifier,
            Event(
                id = 1,
                imagesList[1],
                "28.12.2022 20:30:00",
                title = "Wedding",
                eventType = EventType.LIVE
            ),
            onClickEvent = onClickFutureEventElement
        )
        Spacer(modifier.height(16.dp))
        FutureEventElement(
            modifier = modifier,
            Event(
                id = 2,
                imagesList[2],
                "28.12.2022 20:30:00",
                title = "Rooftop party",
                eventType = EventType.ONLINE
            ),
            onClickEvent = onClickFutureEventElement
        )
        Spacer(modifier.height(16.dp))
    }
}
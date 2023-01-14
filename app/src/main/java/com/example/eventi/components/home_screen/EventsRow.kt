package com.example.eventi.components.home_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EventsRow(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        SectionHeading(contentTitle = "We suggest you")
        LazyRow(
            contentPadding = PaddingValues(start = 16.dp),
            modifier = modifier
        ) {
            item {
                EventCard(Event(0, imagesList[0], "28.12.2022 20:30", "Music Concert", EventType.LIVE))
                EventCard(Event(1, imagesList[1], "28.12.2022 20:30", "Wedding", EventType.LIVE))
                EventCard(Event(2, imagesList[2], "28.12.2022 20:30", "Rooftop Party", EventType.ONLINE))
            }
        }
    }
}
package com.example.eventi.ui.app.components.home_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.eventi.data.network.Event

@Composable
fun EventsRow(
    modifier: Modifier,
    onClickEventCard: (String) -> Unit,
    events: List<Event>
) {
    Column(
        modifier = modifier.padding(bottom = 16.dp)
    ) {
        SectionHeading(
            modifier = modifier,
            sectionCategory = events[0].category
        )
        LazyRow(
            contentPadding = PaddingValues(start = 16.dp),
            modifier = modifier
        ) {
            items(events) { item ->
                EventCard(
                    modifier = modifier,
                    event = item,
                    onClickCard = onClickEventCard
                )
            }
        }
    }
}
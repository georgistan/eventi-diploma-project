package com.example.eventi.ui.app.components.home_screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.eventi.data.network.events.Event

@Composable
fun EventsSection(
    modifier: Modifier,
    sortedEvents: List<List<Event>>,
    onClickEventCard: (String) -> Unit,
    onClickViewAllEvents: () -> Unit,
) {
    for (listOfEvents in sortedEvents) {
        EventsRow(
            modifier = modifier,
            onClickEventCard = onClickEventCard,
            onCLickViewAllButton = onClickViewAllEvents,
            events = listOfEvents
        )
    }
}
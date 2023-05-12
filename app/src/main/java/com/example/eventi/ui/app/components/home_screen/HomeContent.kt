package com.example.eventi.ui.app.components.home_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.eventi.data.network.Event

@Composable
fun HomeContent(
    modifier: Modifier,
    onClickEventCard: (String) -> Unit,
    sortedListsOfEvents: List<List<Event>>
) {
    LazyColumn(
        modifier = modifier,
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Bottom
    ) {
        item {
            Header(
                modifier = modifier
            )
        }
        item {
            EventsProgressBar(isDisplayed = sortedListsOfEvents.isEmpty())
        }
        item {
            EventsSection(
                modifier = modifier,
                sortedEvents = sortedListsOfEvents,
                onClickEventCard = onClickEventCard,
            )
        }
        item {
            Spacer(modifier = modifier.height(80.dp))
        }
    }
}

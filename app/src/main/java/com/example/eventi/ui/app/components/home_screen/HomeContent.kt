package com.example.eventi.ui.app.components.home_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.eventi.repository.events.Event
import com.example.eventi.viewmodels.EventsViewModel

@Composable
fun HomeContent(
    modifier: Modifier,
    onClickChangeLocation: () -> Unit,
    onClickEventCard: (String) -> Unit,
    onClickViewAllEvents: () -> Unit,
    onClickFutureEventCard: () -> Unit,
    onClickViewAllFutureEvents: () -> Unit,
    onClickExploreItem: () -> Unit,
    onClickViewAllExploreCategories: () -> Unit,
    events: List<Event>
) {

    LazyColumn(
        modifier = modifier,
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Bottom
    ) {
        item {
            Header(
                modifier = modifier,
                onClickChangeLocation = onClickChangeLocation
            )
        }
        item {
            EventsRow(
                modifier = modifier,
                onClickEventCard = onClickEventCard,
                onCLickViewAllButton = onClickViewAllEvents,
                events = events
            )
        }
    }
}

package com.example.eventi.ui.app.components.home_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.eventi.R
import com.example.eventi.repository.events.Event

@Composable
fun EventsRow(
    modifier: Modifier,
    onClickEventCard: (String) -> Unit,
    onCLickViewAllButton: () -> Unit,
    events: List<Event>
) {
    Column(
        modifier = modifier.padding(bottom = 16.dp)
    ) {
        SectionHeading(
            modifier = modifier,
            contentTitle = stringResource(R.string.we_suggest_you),
            onClick = onCLickViewAllButton
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
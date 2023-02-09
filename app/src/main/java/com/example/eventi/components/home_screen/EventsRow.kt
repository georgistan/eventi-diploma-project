package com.example.eventi.components.home_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.eventi.R

@Composable
fun EventsRow(
    modifier: Modifier,
    onClickEventCard: () -> Unit,
    onCLickViewAllButton: () -> Unit
) {
    Column(
        modifier = modifier
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
            item {
                EventCard(
                    modifier = modifier,
                    Event(0, imagesList[0], "28.12.2022 20:30", "Music Concert", EventType.LIVE),
                    onClickCard = onClickEventCard
                )
                EventCard(
                    modifier = modifier,
                    Event(1, imagesList[1], "28.12.2022 20:30", "Wedding", EventType.LIVE),
                    onClickCard = onClickEventCard
                )
                EventCard(
                    modifier = modifier,
                    Event(2, imagesList[2], "28.12.2022 20:30", "Rooftop Party", EventType.ONLINE),
                    onClickCard = onClickEventCard
                )
            }
        }
    }
}
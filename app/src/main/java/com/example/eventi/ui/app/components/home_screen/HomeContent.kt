package com.example.eventi.ui.app.components.home_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eventi.R
import com.example.eventi.data.network.Event
import com.example.eventi.ui.theme.EventiTypography

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
            Column {
                Row(
                    modifier = modifier
                        .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                ) {
                    Text(
                        text = stringResource(R.string.home),
                        style = EventiTypography.h2
                    )
                }
                Divider()
            }
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

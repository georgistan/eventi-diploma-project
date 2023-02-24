package com.example.eventi.ui.theme.components.my_events_screen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.eventi.R
import com.example.eventi.ui.theme.components.home_screen.EventCard
import com.example.eventi.viewmodels.EventsViewModel

@Composable
fun MyEventsContent(
    modifier: Modifier,
    onClickEventCard: () -> Unit,
    viewModel: EventsViewModel = hiltViewModel()
) {
    val events by viewModel.events.collectAsState()

    LazyColumn {
        item {
            Row(
                modifier = modifier
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
            ) {
                Text(
                    text = stringResource(R.string.my_events),
                    style = TextStyle(
                        fontSize = 20.sp
                    )
                )
            }
        }
        item { Divider() }
        item { Spacer(Modifier.height(16.dp)) }
        items(events) { item ->
            EventCard(
                modifier = modifier,
                event = item,
                onClickCard = onClickEventCard,
            )
        }
        item {
            Spacer(modifier = modifier.height(80.dp))
        }
    }
}

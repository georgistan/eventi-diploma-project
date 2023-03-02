package com.example.eventi.ui.app.components.my_events_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.eventi.R
import com.example.eventi.ui.app.components.home_screen.EventCard
import com.example.eventi.viewmodels.EventsViewModel

@Composable
fun MyEventsContent(
    modifier: Modifier,
    onClickEventCard: (String) -> Unit,
    viewModel: EventsViewModel = hiltViewModel()
) {
    val events by viewModel.events.collectAsState()

    Column {
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
        Divider()
//        LazyColumn(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            contentPadding = PaddingValues(
//                top = 16.dp,
//                end = 16.dp,
//                bottom = 80.dp,
//                start = 16.dp
//            )
//        ) {
//            items(events) { item ->
//                EventCard(
//                    modifier = modifier
//                        .padding(all = 18.dp)
//                        .fillMaxWidth(),
//                    event = item,
//                    onClickCard = onClickEventCard,
//                )
//            }
//        }
    }
}

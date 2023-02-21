package com.example.eventi.ui.theme.components.my_events_screen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eventi.R

@Composable
fun MyEventsContent(
    modifier: Modifier,
    onClickEventCard: () -> Unit
) {
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
//        item {
//            Column(
//                modifier = modifier
//                    .padding(start = 16.dp, end = 16.dp)
//            ) {
//                EventCard(
//                    modifier = modifier,
//                    Event(0, imagesList[0], "28.12.2022 20:30", "Music Concert", EventType.LIVE),
//                    onClickCard = onClickEventCard
//                )
//                Spacer(modifier.height(16.dp))
//                EventCard(
//                    modifier= modifier,
//                    Event(1, imagesList[1], "28.12.2022 20:30", "Wedding", EventType.LIVE),
//                    onClickCard = onClickEventCard
//                )
//                Spacer(modifier.height(16.dp))
//                EventCard(
//                    modifier = modifier,
//                    Event(2, imagesList[2], "28.12.2022 20:30", "Rooftop Party", EventType.ONLINE),
//                    onClickCard = onClickEventCard
//                )
//                Spacer(modifier.height(16.dp))
//            }
//        }
    }
}

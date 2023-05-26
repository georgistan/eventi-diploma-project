package com.example.eventi.ui.app.components.memories_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.example.eventi.ui.app.components.home_screen.EventCard
import com.example.eventi.ui.theme.EventiTypography

@Composable
fun MemoriesContent(
    modifier: Modifier = Modifier,
    attendedEvents: List<Event>,
    onClickEventCard: (String) -> Unit
) {
    Column {
        Column {
            Row(
                modifier = modifier
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
            ) {
                Text(
                    text = stringResource(R.string.memories),
                    style = EventiTypography.h2
                )
            }
            Divider()
        }
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            contentPadding = PaddingValues(start = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Spacer(modifier = modifier.height(16.dp))
            }
            items(attendedEvents) { item ->
                EventCard(
                    modifier = modifier,
                    event = item,
                    onClickCard = onClickEventCard
                )
            }
            item {
                Spacer(modifier = modifier.height(80.dp))
            }
        }
    }
}
package com.example.eventi.ui.theme.components.home_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.eventi.R
import com.example.eventi.repository.events.Event

@Composable
fun FutureEventsColumn(
    modifier: Modifier,
    onClickFutureEventElement: () -> Unit,
    onClickViewAllButton: () -> Unit,
    events: List<Event>
) {
    Column {
        SectionHeading(
            modifier = modifier,
            contentTitle = stringResource(R.string.this_week),
            onClick = onClickViewAllButton
        )
        LazyRow(
            modifier = modifier,
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            items(events) { item ->
                FutureEventElement(
                    modifier = modifier,
                    item,
                    onClickEvent = onClickFutureEventElement
                )
            }
        }
    }
}
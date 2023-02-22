package com.example.eventi.ui.theme.components.home_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
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
    onClickViewAllButton: () -> Unit
) {
    Column(
        modifier = modifier
    ) {
        SectionHeading(
            modifier = modifier,
            contentTitle = stringResource(R.string.this_week),
            onClick = onClickViewAllButton
        )
        FutureEventElement(
            modifier = modifier,
            Event(
               title = "alo",
                description = "da",
                category = "kuche",
                startsAt = "utre",
                predictedEnd = "dnes",
                rank = 100
            ),
            onClickEvent = onClickFutureEventElement
        )
        Spacer(modifier.height(16.dp))

        Spacer(modifier.height(16.dp))

        Spacer(modifier.height(16.dp))
    }
}
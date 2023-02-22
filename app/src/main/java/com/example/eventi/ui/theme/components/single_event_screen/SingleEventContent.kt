package com.example.eventi.ui.theme.components.single_event_screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SingleEventContent(
    modifier: Modifier,
    eventId: Long?
) {
    Text(text = "Hello, $eventId")
}
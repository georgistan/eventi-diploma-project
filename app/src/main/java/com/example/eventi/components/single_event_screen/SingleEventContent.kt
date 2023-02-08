package com.example.eventi.components.single_event_screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.eventi.components.home_screen.Event

@Composable
fun SingleEventContent(
    modifier: Modifier,
    event: Event?
) {
    Text(text = "Hello, ${event?.title}")
}
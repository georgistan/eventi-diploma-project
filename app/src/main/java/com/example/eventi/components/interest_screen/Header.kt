package com.example.eventi.components.interest_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.eventi.ui.theme.EventiTypography

@Composable
fun Header(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = "Your interests",
            style = EventiTypography.h2
        )
        Text(
            text = "Pick your favorite interest to find events related to you",
            style = EventiTypography.subtitle1
        )
    }
}
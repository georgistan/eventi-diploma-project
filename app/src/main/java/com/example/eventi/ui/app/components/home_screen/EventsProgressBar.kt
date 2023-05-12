package com.example.eventi.ui.app.components.home_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.eventi.ui.theme.EventiTypography
import com.example.eventi.ui.theme.PrimaryGray

@Composable
fun EventsProgressBar(
    isDisplayed: Boolean
) {
    if (isDisplayed) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp)
        ) {
            CircularProgressIndicator(
                color = PrimaryGray
            )
            Spacer(modifier = Modifier.width(width = 8.dp))
            Text(
                text = "Loading...",
                style = EventiTypography.h2
            )
        }
    }
}
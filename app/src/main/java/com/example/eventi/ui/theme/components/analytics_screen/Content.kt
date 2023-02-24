package com.example.eventi.ui.theme.components.analytics_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Content(
    modifier: Modifier
) {
    Column {
        Row(
            modifier = modifier
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
        ) {
            Text(
                text = "Analytics",
                style = TextStyle(
                    fontSize = 20.sp
                )
            )
        }
        Divider()
    }
}
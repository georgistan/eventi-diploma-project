package com.example.eventi.ui.theme.components.home_screen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.eventi.ui.theme.EventiTypography
import com.example.eventi.ui.theme.PrimaryBlue

@Composable
fun SectionHeading(
    modifier: Modifier,
    contentTitle: String,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .padding(top = 40.dp, start = 16.dp, end = 16.dp)
    ) {
        Text(
            modifier = modifier.weight(1f),
            text = contentTitle,
            style = EventiTypography.h2
        )
        TextButton(
            onClick = onClick
        ) {
            Text(
                text = "View all",
                color = PrimaryBlue,
                style = EventiTypography.subtitle1
            )
        }
    }
}
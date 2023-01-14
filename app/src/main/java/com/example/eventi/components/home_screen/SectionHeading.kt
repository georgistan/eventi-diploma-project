package com.example.eventi.components.home_screen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eventi.ui.theme.Blue

@Composable
fun SectionHeading(
    contentTitle: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(top = 40.dp, start = 16.dp, end = 16.dp)
    ) {
        Text(
            modifier = modifier.weight(1f),
            text = contentTitle,
            style = TextStyle(
                fontSize = 20.sp
            )
        )
        TextButton(onClick = { /*TODO*/ }) {
            Text(
                "View all",
                color = Blue
            )
        }
    }
}
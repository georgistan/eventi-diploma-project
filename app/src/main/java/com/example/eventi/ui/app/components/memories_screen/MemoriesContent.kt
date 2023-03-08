package com.example.eventi.ui.app.components.memories_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eventi.R

@Composable
fun MemoriesContent(
    modifier: Modifier = Modifier
) {
    Column {
        Row(
            modifier = modifier
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
        ) {
            Text(
                text = stringResource(R.string.memories),
                style = TextStyle(
                    fontSize = 20.sp
                )
            )
        }
        Divider()
    }
}
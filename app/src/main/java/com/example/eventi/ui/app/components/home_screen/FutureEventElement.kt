package com.example.eventi.ui.app.components.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.eventi.R
import com.example.eventi.repository.events.Event

@Composable
fun FutureEventElement(
    modifier: Modifier,
    event: Event,
    onClickEvent: () -> Unit
) {
    Surface(
        modifier = modifier
            .clickable { onClickEvent() },
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Image(
                painterResource(R.drawable.img),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .size(76.dp)
                    .clip(RoundedCornerShape(4.dp))
            )
            Column(
                modifier = Modifier.padding(horizontal = 16.dp),
            ) {
                Text(
                    text = event.startsAt,
                    color = Color.Gray
                )
                Spacer(Modifier.height(6.dp))
                Text(
                    text = event.title,
                )
                Spacer(Modifier.height(6.dp))
            }
            Spacer(modifier = modifier.width(16.dp))
        }
    }
}
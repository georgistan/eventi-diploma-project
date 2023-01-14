package com.example.eventi.components.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.eventi   .ui.theme.Blue

@Composable
fun FutureEventElement(
    event: Event,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .clickable {  },
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Image(
                painterResource(event.image),
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
                    text = event.date,
                    color = Color.Gray
                )
                Spacer(Modifier.height(6.dp))
                Text(
                    text = event.title,
                )
                Spacer(Modifier.height(6.dp))
                Row {
                    if (event.eventType == EventType.LIVE) {
                        Icon(
                            Icons.Default.NearMe,
                            contentDescription = null,
                            tint = Color.Gray
                        )
                        Spacer(
                            Modifier.width(6.dp)
                        )
                        Text(
                            text = "Live event",
                            color = Color.Gray
                        )
                    } else {
                        Icon(
                            Icons.Default.Videocam,
                            contentDescription = null,
                            tint = Color.Gray
                        )
                        Spacer(
                            Modifier.width(6.dp)
                        )
                        Text(
                            text = "Online event",
                            color = Color.Gray
                        )
                    }
                }
            }
            IconButton(
                onClick = {}
            ) {
                Icon(
                    Icons.Outlined.Bookmark,
                    contentDescription = "Save event",
                    tint = Blue,
                    modifier = modifier
                )
            }
        }
    }
}
package com.example.eventi.components.home_screen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.eventi.R
import com.example.eventi.ui.theme.Blue
import com.example.eventi.ui.theme.PrimaryOrange

@Composable
fun EventCard(
    event: Event,
    modifier: Modifier = Modifier
) {
    Row {
        Card(
            modifier = modifier
                .shadow(elevation = 4.dp)
                .clickable { print("Card clicked!") }
                .height(240.dp)
                .width(290.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column {
                Image(
                    painterResource(event.image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .fillMaxWidth()
                        .weight(1f)
                )
                Spacer(Modifier.height(16.dp))
                Column(
                    modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp)
                ) {
                    Column {
                        Text(
                            text = event.date,
                            color = Color.Gray
                        )
                        Spacer(Modifier.height(8.dp))
                        Text(
                            text = event.title,
                            color = PrimaryOrange
                        )
                    }
                    Spacer(Modifier.height(8.dp))
                    EventTypeRow(modifier, event.eventType)
                }
            }
        }
        Spacer(Modifier.width(16.dp))
    }
}

data class Event(
    val id: Int,
    @DrawableRes val image: Int,
    val date: String,
    val title: String,
    val eventType: EventType
)

enum class EventType {
    ONLINE,
    LIVE
}

val imagesList = listOf(
    R.drawable.img,
    R.drawable.img_1,
    R.drawable.img_2
)

@Composable
fun EventTypeRow(
    modifier: Modifier,
    eventType: EventType
){
    if (eventType == EventType.LIVE){
        return Row(
        ) {
            Icon(
                Icons.Default.LocationOn,
                contentDescription = null
            )
            Text(
                text = stringResource(R.string.online_event),
                modifier.paddingFromBaseline(top = 20.dp)
            )
            Spacer(modifier = modifier.weight(2f))
            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    Icons.Outlined.Bookmark,
                    contentDescription = null,
                    tint = Blue
                )
            }
        }
    } else {
        return Row {
            Icon(
                Icons.Default.AccountBox,
                contentDescription = null,
                modifier.padding(end = 6.dp)
            )
            Text(
                text = stringResource(R.string.live_event),
                modifier.paddingFromBaseline(top = 20.dp)
            )
            Spacer(modifier = modifier.weight(2f))
            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    Icons.Outlined.Bookmark,
                    contentDescription = null,
                    tint = Blue
                )
            }
        }
    }
}
package com.example.eventi.ui.app.components.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.eventi.R
import com.example.eventi.data.network.Event
import com.example.eventi.ui.theme.EventiTypography
import com.example.eventi.ui.theme.PrimaryOrange

@Composable
fun EventCard(
    modifier: Modifier,
    event: Event,
    onClickCard: (String) -> Unit
) {
    Row(
        modifier = modifier.padding(bottom = 16.dp)
    ) {
        Card(
            modifier = modifier
                .clickable {
                    onClickCard(event.id)
                }
                .height(240.dp)
                .width(290.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {
            Column {
                Image(
                    painterResource(chooseImage()),
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
                            text = event.startsAt,
                            color = Color.Gray,
                            style = EventiTypography.subtitle2
                        )
                        Spacer(Modifier.height(8.dp))
                        Text(
                            text = event.title,
                            color = PrimaryOrange,
                            style = EventiTypography.body1,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    Spacer(Modifier.height(8.dp))
                }
            }
        }
        Spacer(Modifier.width(16.dp))
    }
}
private fun chooseImage(): Int = listOf(R.drawable.img, R.drawable.img_1, R.drawable.img_3).random()
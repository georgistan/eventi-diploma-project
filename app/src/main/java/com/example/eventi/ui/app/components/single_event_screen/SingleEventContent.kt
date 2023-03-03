package com.example.eventi.ui.app.components.single_event_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.eventi.R
import com.example.eventi.data.network.events.Event
import com.example.eventi.ui.theme.BackgroundGray
import com.example.eventi.ui.theme.EventiTypography
import com.example.eventi.ui.theme.PrimaryBlue
import com.example.eventi.ui.theme.SecondaryGray

@Composable
fun SingleEventContent(
    modifier: Modifier,
    event: Event?,
    onPopScreen: () -> Unit,
    onClickAttendButton: () -> Unit
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier.verticalScroll(scrollState)
    ) {
        FloatingActionButton(
            onClick = onPopScreen,
            containerColor = SecondaryGray,
            contentColor = Color.White,
            shape = RoundedCornerShape(16.dp)
        ) {
            Icon(
                Icons.Default.ArrowBack,
                contentDescription = "back to home screen"
            )
        }
        Image(
            painterResource(R.drawable.img_2),
            contentDescription = "event image",
            contentScale = ContentScale.Crop,
            modifier = modifier.fillMaxWidth()
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = modifier.height(16.dp))
            if (event != null) {
                Text(
                    text = event.title,
                    style = EventiTypography.h1
                )
            }
            Spacer(modifier = modifier.height(10.dp))
            Text(
                text = "Will you be attending this event?",
                style = EventiTypography.subtitle1
            )
            Spacer(modifier = modifier.height(20.dp))
            OutlinedButton(
                shape = RoundedCornerShape(10.dp),
                onClick = onClickAttendButton,
                modifier = modifier,
                contentPadding = ButtonDefaults.ButtonWithIconContentPadding
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Attend",
                        style = EventiTypography.subtitle1,
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    Icon(
                        Icons.Filled.Done,
                        contentDescription = "date of event",
                        modifier = modifier.size(ButtonDefaults.IconSize),
                        tint = Color.Black
                    )
                }
            }
            Spacer(modifier = modifier.height(20.dp))
            Divider(thickness = 16.dp, color = BackgroundGray)
            Column(
                modifier = modifier.padding(top = 18.dp, end = 18.dp, bottom = 18.dp)
            ) {
                Row {
                    Icon(
                        imageVector = Icons.Filled.CalendarViewMonth,
                        contentDescription = "date of event",
                        tint = PrimaryBlue,
                        modifier = modifier.weight(1f)
                    )
                    if (event != null) {
                        Text(
                            text = event.startsAt,
                            modifier.weight(3f),
                            style = EventiTypography.subtitle1
                        )
                    }
                }
                Spacer(modifier = Modifier.height(18.dp))
                Row {
                    Icon(
                        imageVector = Icons.Filled.LocationOn,
                        contentDescription = "location of event",
                        tint = PrimaryBlue,
                        modifier = modifier.weight(1f)
                    )
                    if (event != null) {
                        Text(
                            text = "Sofia, Hipodruma",
                            modifier.weight(3f),
                            style = EventiTypography.subtitle1,
                        )
                    }
                }
                Spacer(modifier = Modifier.height(18.dp))
                Row {
                    Icon(
                        imageVector = Icons.Filled.Category,
                        contentDescription = "category of event",
                        tint = PrimaryBlue,
                        modifier = modifier.weight(1f)
                    )
                    if (event != null) {
                        Text(
                            text = event.category,
                            modifier.weight(3f),
                            style = EventiTypography.subtitle1,
                        )
                    }
                }
                Spacer(modifier = Modifier.height(18.dp))
                Row {
                    Icon(
                        imageVector = Icons.Filled.
                        Grade,
                        contentDescription = "rank of event",
                        tint = PrimaryBlue,
                        modifier = modifier.weight(1f)
                    )
                    if (event != null) {
                        Text(
                            text = "${event.rank}/100",
                            modifier.weight(3f),
                            style = EventiTypography.subtitle1,
                        )
                    }
                }
                Spacer(modifier = Modifier.height(18.dp))
            }
            Divider(thickness = 16.dp, color = BackgroundGray)
            Column(
                modifier = modifier.padding(top = 18.dp, bottom = 18.dp, end = 18.dp, start = 40.dp)
            ) {
                Row {
                    Text(
                        text = "About",
                        style = EventiTypography.h2,
                        modifier = modifier
                            .padding(bottom = 10.dp)
                            .weight(1f)
                    )
                    Spacer(modifier = modifier.weight(2f))
                }
                if (event != null) {
                    Text(
                        text = event.description,
                        style = EventiTypography.subtitle1
                    )
                }
            }
        }
        Spacer(modifier = modifier.height(80.dp))
    }
}
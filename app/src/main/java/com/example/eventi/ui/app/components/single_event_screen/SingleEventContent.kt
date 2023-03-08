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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.eventi.R
import com.example.eventi.data.network.events.Event
import com.example.eventi.ui.theme.*

@Composable
fun SingleEventContent(
    modifier: Modifier,
    event: Event?,
    onPopScreen: () -> Unit,
    onClickAttendButton: (Event) -> Unit
) {
    val scrollState = rememberScrollState()
    val selected = rememberSaveable { mutableStateOf(false) }

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
                contentDescription = stringResource(id = R.string.back_to_home)
            )
        }
        Image(
            painterResource(R.drawable.img_2),
            contentDescription = stringResource(id = R.string.event_image),
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
                text = stringResource(id = R.string.attendance_question),
                style = EventiTypography.subtitle1
            )
            Spacer(modifier = modifier.height(20.dp))
            OutlinedButton(
                shape = RoundedCornerShape(10.dp),
                onClick = {
                    selected.value = !selected.value
                    event?.isAttended = !event?.isAttended!!
                    onClickAttendButton(event)
                },
                modifier = modifier,
                contentPadding = ButtonDefaults.ContentPadding,
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (selected.value) ValidationGreen else Color.White
                )
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = if (selected.value) {
                            stringResource(id = R.string.attending)
                        } else {
                            stringResource(id = R.string.attend)
                        },
                        style = EventiTypography.subtitle1,
                        color = if (selected.value) Color.White else Color.Black
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    if (selected.value) {
                        Icon(
                            Icons.Filled.Done,
                            contentDescription = stringResource(id = R.string.attendance_confirm),
                            modifier = modifier.size(ButtonDefaults.IconSize),
                            tint = if (selected.value) Color.White else Color.Black
                        )
                    }
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
                        contentDescription = stringResource(id = R.string.date_of_event),
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
                        contentDescription = stringResource(id = R.string.location_of_event),
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
                        contentDescription = stringResource(id = R.string.category_of_event),
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
                        imageVector = Icons.Filled.Grade,
                        contentDescription = stringResource(id = R.string.rank_of_event),
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
                        text = stringResource(id = R.string.event_about),
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
package com.example.eventi.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.eventi.R
import com.example.eventi.components.home_screen.Event
import com.example.eventi.components.home_screen.EventCard
import com.example.eventi.components.home_screen.EventType
import com.example.eventi.components.home_screen.imagesList
import com.example.eventi.navigation.BottomNavigation

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyEventsScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Scaffold(
        modifier = modifier
            .padding(top = 16.dp),
        bottomBar = {
            BottomNavigation(
                navController = navController,
            )
        }
    ) {
        LazyColumn {
            item {
                Row(
                    modifier = modifier
                        .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                ) {
                    Text(
                        text = stringResource(R.string.my_events),
                        style = TextStyle(
                            fontSize = 20.sp
                        )
                    )
                }
            }
            item { Divider() }
            item { Spacer(Modifier.height(16.dp)) }
            item {
                Column(
                    modifier = modifier
                        .padding(start = 16.dp, end = 16.dp)
                ) {
                    EventCard(Event(0, imagesList[0], "28.12.2022 20:30", "Music Concert", EventType.LIVE))
                    Spacer(Modifier.height(16.dp))
                    EventCard(Event(1, imagesList[1], "28.12.2022 20:30", "Wedding", EventType.LIVE))
                    Spacer(Modifier.height(16.dp))
                    EventCard(Event(2, imagesList[2], "28.12.2022 20:30", "Rooftop Party", EventType.ONLINE))
                    Spacer(Modifier.height(16.dp))
                }
            }
        }
    }
}
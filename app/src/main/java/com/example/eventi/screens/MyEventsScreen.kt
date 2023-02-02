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
import com.example.eventi.components.my_events_screen.MyEventsContent
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
        MyEventsContent(
            modifier = modifier,
            onClickEventCard = {

            }
        )
    }
}
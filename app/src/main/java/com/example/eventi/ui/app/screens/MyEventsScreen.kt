package com.example.eventi.ui.app.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.eventi.navigation.BottomNavigation
import com.example.eventi.ui.app.components.my_events_screen.MyEventsContent

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
package com.example.eventi.ui.app.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.eventi.navigation.BottomNavigation
import com.example.eventi.navigation.Screen
import com.example.eventi.navigation.navigateSingleTopTo
import com.example.eventi.ui.app.components.home_screen.HomeContent
import com.example.eventi.viewmodels.EventsViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: EventsViewModel = hiltViewModel()
) {
    val events by viewModel.events.collectAsState()

    Scaffold(
        modifier = modifier.padding(top = 16.dp),
        bottomBar = {
            BottomNavigation(
                navController = navController,
            )
        }
    ) {
        HomeContent(
            modifier = modifier,
            onClickChangeLocation = {

            },
            onClickEventCard = { eventId ->
                navController.navigateToSingleEvent(eventId)
            },
            onClickViewAllEvents = {

            },
            onClickFutureEventCard = {

            },
            onClickViewAllFutureEvents = {

            },
            onClickExploreItem = {

            },
            onClickViewAllExploreCategories = {

            },
            events = events
        )
    }
}

private fun NavHostController.navigateToSingleEvent(eventId: String) {
    this.navigateSingleTopTo("${Screen.SingleEventScreen.route}/$eventId")
}

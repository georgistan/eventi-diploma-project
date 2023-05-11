package com.example.eventi.ui.app.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.eventi.navigation.BottomNavigation
import com.example.eventi.navigation.navigateToSingleEvent
import com.example.eventi.ui.app.components.home_screen.HomeContent
import com.example.eventi.viewmodels.HomeViewModel
import timber.log.Timber

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    viewModel.fetchEvents()
    val eventsData = viewModel.events.collectAsState()

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
            onClickEventCard = { eventId ->
                navController.navigateToSingleEvent(eventId)
            },
            onClickViewAllEvents = {

            },
            sortedListsOfEvents = eventsData.value
        )
    }
}

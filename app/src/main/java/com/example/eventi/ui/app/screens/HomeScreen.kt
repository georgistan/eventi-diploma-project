package com.example.eventi.ui.app.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavHostController
import com.example.eventi.navigation.BottomNavigation
import com.example.eventi.navigation.navigateToSingleEvent
import com.example.eventi.ui.app.components.home_screen.HomeContent
import com.example.eventi.viewmodels.HomeViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val lifecycleEvent = rememberLifecycleEvent()

    LaunchedEffect(key1 = lifecycleEvent) {
        if (lifecycleEvent == Lifecycle.Event.ON_RESUME) {
            viewModel.fetchEvents()
        }
    }
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
            sortedListsOfEvents = eventsData.value
        )
    }
}

@Composable
fun rememberLifecycleEvent(
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current
): Lifecycle.Event {
    var state by remember { mutableStateOf(Lifecycle.Event.ON_ANY) }

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            state = event
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    return state
}

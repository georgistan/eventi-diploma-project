package com.example.eventi.ui.app.screens

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.eventi.navigation.BottomNavigation
import com.example.eventi.navigation.Screen
import com.example.eventi.ui.app.components.single_event_screen.SingleEventContent
import com.example.eventi.viewmodels.SingleEventViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SingleEventScreen(
    eventId: String,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: SingleEventViewModel = hiltViewModel()
) {
    viewModel.fetchEventById(eventId)
    val event = viewModel.queriedEvent.collectAsState()

    viewModel.checkEventAttended(eventId)
    val isEventAttended = viewModel.isQueriedEventAttended.collectAsState()

    Scaffold(
        modifier = modifier,
        bottomBar = {
            BottomNavigation(
                navController = navController
            )
        }
    ) {
        SingleEventContent(
            modifier = modifier,
            event = event.value,
            isAttended = isEventAttended.value,
            onPopScreen = {
                navController.popBackStack()
            },
            onClickAttendButton = { event ->
                viewModel.manageEventAttendance(event)
            }
        )
    }
}

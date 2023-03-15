package com.example.eventi.ui.app.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.eventi.navigation.BottomNavigation
import com.example.eventi.navigation.navigateToSingleEvent
import com.example.eventi.ui.app.components.memories_screen.MemoriesContent
import com.example.eventi.viewmodels.MemoriesViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MemoriesScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: MemoriesViewModel = hiltViewModel()
) {
    val attendedEvents = viewModel.attendedEvents.collectAsState()

    Scaffold(
        modifier = modifier
            .padding(top = 16.dp),
        bottomBar = {
            BottomNavigation(
                navController = navController,
            )
        }
    ) {
        MemoriesContent(
            attendedEvents = attendedEvents.value,
            onClickEventCard = { eventId ->
                    navController.navigateToSingleEvent(eventId)
            }
        )
    }
}
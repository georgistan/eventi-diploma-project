package com.example.eventi.ui.theme.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.eventi.navigation.BottomNavigation
import com.example.eventi.navigation.Screen
import com.example.eventi.navigation.navigateSingleTopTo
import com.example.eventi.ui.theme.components.home_screen.HomeContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
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
            onClickEventCard = {

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
        )
    }
}

private fun NavHostController.navigateToSingleEvent(eventId: String) {
    this.navigateSingleTopTo("${Screen.SingleEventScreen.route}/${eventId}")
}

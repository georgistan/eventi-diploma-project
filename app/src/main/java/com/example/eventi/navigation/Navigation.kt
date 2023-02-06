package com.example.eventi.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.eventi.components.home_screen.Event
import com.example.eventi.screens.*
import com.google.gson.Gson

@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.InterestsScreen.route
    ) {
        composable(route = Screen.InterestsScreen.route) {
            InterestsScreen(
                onClickDoneButton = {
                    navController.navigateSingleTopTo(Screen.HomeScreen.route)
                }
            )
        }
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(
                navController = navController
            )
        }
        composable(route = Screen.MyEventsScreen.route) {
            MyEventsScreen(
                navController = navController
            )
        }
        composable(route = Screen.MemoriesScreen.route) {
            MemoriesScreen(
                navController = navController
            )
        }
        composable(route = Screen.AnalyticsScreen.route) {
            AnalyticsScreen(
                navController = navController
            )
        }
        composable(
            route = "${Screen.SingleEventScreen.route}/{event}",
            arguments = listOf(
                navArgument("event") {
                    type = EventArgType()
                }
            )
        ) { navBackStackEntry ->
            val event = navBackStackEntry.arguments
                ?.getString("event")
                ?.let { Gson().fromJson(it, Event::class.java) }

            SingleEventScreen(
                event = event,
                navController = navController
            )
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) { launchSingleTop = true }

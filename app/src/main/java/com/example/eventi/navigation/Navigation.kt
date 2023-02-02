package com.example.eventi.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.eventi.screens.*

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
        composable(MyEvents.screen.route) {
            MyEventsScreen(
                navController = navController
            )
        }
        composable(Memories.screen.route) {
            MemoriesScreen(
                navController = navController
            )
        }
        composable(Analytics.screen.route) {
            AnalyticsScreen(
                navController = navController
            )
        }
        composable(
            route = SingleEventScreen.routeWithArgs,
            arguments = SingleEventScreen.arguments
        ){ navBackStackEntry ->
            val eventInfo =
                navBackStackEntry.arguments?.getString(SingleEventScreen.eventInfoArg)

            SingleEventScreen(eventInfo)
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) { launchSingleTop = true }

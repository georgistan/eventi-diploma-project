package com.example.eventi.navigation

import androidx.compose.runtime.Composable
import androidx.datastore.core.DataStore
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.eventi.ui.theme.screens.*

@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(route = Screen.SplashScreen.route) {
            AnimatedSplashScreen(
                popSplashScreen = {
                    navController.popBackStack()
                },
                navigateToNextScreen = {
                    navController.navigateSingleTopTo(Screen.InterestsScreen.route)
                }
            )
        }
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
                    type = NavType.LongType
                }
            )
        ) { navBackStackEntry ->
            val eventId = navBackStackEntry.arguments
                ?.getString("eventId")
                ?.toLong()

            SingleEventScreen(
                eventId = eventId,
                navController = navController
            )
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) { launchSingleTop = true }

package com.example.eventi.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.eventi.repository.interests.Interest
import com.example.eventi.ui.app.screens.*

@Composable
fun Navigation(
    navController: NavHostController
) {
    val databaseInterestsList = listOf(Interest(0, "Joro"))
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
                    if (databaseInterestsList.isNotEmpty()) {
                        navController.navigateSingleTopTo(Screen.InterestsScreen.route)
                    } else {
                        navController.navigateSingleTopTo(Screen.HomeScreen.route)
                    }
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
            route = "${Screen.SingleEventScreen.route}/{eventId}",
            arguments = listOf(
                navArgument("eventId") {
                    type = NavType.StringType
                }
            )
        ) { navBackStackEntry ->
            val eventId = navBackStackEntry.arguments
                ?.getString("eventId")

            if (eventId != null) {
                SingleEventScreen(
                    eventId = eventId,
                    navController = navController
                )
            }
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }

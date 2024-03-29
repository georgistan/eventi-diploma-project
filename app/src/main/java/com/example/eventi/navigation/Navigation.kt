package com.example.eventi.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.eventi.ui.app.screens.*
import com.example.eventi.viewmodels.InterestsViewModel

@Composable
fun Navigation(
    navController: NavHostController,
    viewModel: InterestsViewModel = hiltViewModel()
) {
    val databaseInterestsList = viewModel.savedInterests.collectAsState()

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
                    if (databaseInterestsList.value.isEmpty()) {
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
                    navController.popInterestsScreenNavigateHome()
                }
            )
        }
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(
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

fun NavHostController.popInterestsScreenNavigateHome() =
    this.navigate("home_screen"){
        popUpTo(
            0
        ) {
            saveState
        }
        launchSingleTop = true
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

fun NavHostController.navigateToSingleEvent(eventId: String) {
    this.navigateSingleTopTo("${Screen.SingleEventScreen.route}/$eventId")
}

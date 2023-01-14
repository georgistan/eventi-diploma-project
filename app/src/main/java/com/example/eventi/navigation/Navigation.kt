package com.example.eventi.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.eventi.screens.*

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.InterestsScreen.route
    ) {
        composable(route = Screen.InterestsScreen.route) {
            InterestsScreen(navController = navController)
        }
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(BottomNavItem.Home.screen_route){
            HomeScreen(navController = navController)
        }
        composable(BottomNavItem.MyEvents.screen_route){
            MyEventsScreen(navController = navController)
        }
        composable(BottomNavItem.Memories.screen_route){
            MemoriesScreen(navController = navController)
        }
        composable(BottomNavItem.Analytics.screen_route){
            AnalyticsScreen(navController = navController)
        }
    }
}
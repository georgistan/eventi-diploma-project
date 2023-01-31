package com.example.eventi.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.CalendarViewDay
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Memory
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val route: String
) {
    object InterestsScreen : Screen("interests_screen")
    object HomeScreen : Screen("home_screen")
    object MyEventsScreen : Screen("my_events_screen")
    object MemoriesScreen : Screen("memories_screen")
    object AnalyticsScreen : Screen("analytics_screen")
    object SingleEventScreen : Screen("single_event_screen")
}

sealed class BottomNavItem(
    val title: String,
    val icon: ImageVector,
    val screen: Screen
) {
    object Home : BottomNavItem("Home", Icons.Default.Home, Screen.HomeScreen)
    object MyEvents : BottomNavItem("My Events", Icons.Default.CalendarViewDay, Screen.MyEventsScreen)
    object Memories : BottomNavItem("Memories", Icons.Default.Memory, Screen.MemoriesScreen)
    object Analytics : BottomNavItem("Analytics", Icons.Default.Analytics, Screen.AnalyticsScreen)
}
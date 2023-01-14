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
}

sealed class BottomNavItem(
    val title: String,
    val icon: ImageVector,
    val screen_route: String
) {
    object Home : BottomNavItem("Home", Icons.Default.Home, "home")
    object MyEvents : BottomNavItem("My Events", Icons.Default.CalendarViewDay, "my_events")
    object Memories : BottomNavItem("Memories", Icons.Default.Memory, "memories")
    object Analytics : BottomNavItem("Analytics", Icons.Default.Analytics, "analytics")
}
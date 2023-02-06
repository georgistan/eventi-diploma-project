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

interface BottomNavItem {
    val title: String
    val icon: ImageVector
    val screens: List<Screen>
}

object Home : BottomNavItem {
    override val title: String = "Home"
    override val icon: ImageVector = Icons.Default.Home
    override val screens: List<Screen> = listOf(Screen.HomeScreen, Screen.SingleEventScreen)
}

object MyEvents : BottomNavItem {
    override val title: String = "My Events"
    override val icon: ImageVector = Icons.Default.CalendarViewDay
    override val screens: List<Screen> = listOf(Screen.MyEventsScreen)
}

object Memories : BottomNavItem {
    override val title: String = "Memories"
    override val icon: ImageVector = Icons.Default.Memory
    override val screens: List<Screen> = listOf(Screen.MemoriesScreen)
}

object Analytics : BottomNavItem {
    override val title: String = "Analytics"
    override val icon: ImageVector = Icons.Default.Analytics
    override val screens: List<Screen> = listOf(Screen.AnalyticsScreen)
}

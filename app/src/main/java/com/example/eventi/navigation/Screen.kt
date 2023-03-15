package com.example.eventi.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val route: String
) {
    object SplashScreen : Screen("splash_screen")
    object InterestsScreen : Screen("interests_screen")
    object HomeScreen : Screen("home_screen")
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

object Memories : BottomNavItem {
    override val title: String = "Memories"
    override val icon: ImageVector = Icons.Default.EventNote
    override val screens: List<Screen> = listOf(Screen.MemoriesScreen)
}

object Analytics : BottomNavItem {
    override val title: String = "Analytics"
    override val icon: ImageVector = Icons.Default.Analytics
    override val screens: List<Screen> = listOf(Screen.AnalyticsScreen)
}

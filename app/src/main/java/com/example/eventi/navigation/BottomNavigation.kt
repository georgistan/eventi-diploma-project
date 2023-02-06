package com.example.eventi.navigation

import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.eventi.ui.theme.OrangeLight
import com.example.eventi.ui.theme.OrangeLightest

@Composable
fun BottomNavigation(
    navController: NavController
) {
    val items = listOf(
        Home,
        MyEvents,
        Memories,
        Analytics
    )

    androidx.compose.material.BottomNavigation(
        backgroundColor = OrangeLightest,
        contentColor = OrangeLight
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    item.icon
                    item.title
                },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 9.sp
                    )
                },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black.copy(0.4f),
                alwaysShowLabel = true,
                selected = item.screens.firstOrNull { it.route == currentRoute } != null,
                onClick = {
                    navController.navigate( item.screens.first().route ) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}


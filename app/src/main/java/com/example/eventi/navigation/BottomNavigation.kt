package com.example.eventi.navigation

import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.eventi.ui.theme.DarkIconOrange
import com.example.eventi.ui.theme.EventiTypography
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
        backgroundColor = OrangeLightest
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title,
                        tint = DarkIconOrange
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        style = EventiTypography.subtitle2.copy(color = DarkIconOrange, fontSize = 10.sp)
                    )
                },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black,
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


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
        BottomNavItem.Home,
        BottomNavItem.MyEvents,
        BottomNavItem.Memories,
        BottomNavItem.Analytics
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
//                    when (item.title) {
//                        "Home" -> Icon(Icons.Default.Home, contentDescription = null)
//                        "My Events" -> Icon(Icons.Default.CalendarToday, contentDescription = null)
//                        "Memories" -> Icon(Icons.Default.EditCalendar, contentDescription = null)
//                        "Analytics" -> Icon(Icons.Default.Analytics, contentDescription = null)
//                    }
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
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {

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
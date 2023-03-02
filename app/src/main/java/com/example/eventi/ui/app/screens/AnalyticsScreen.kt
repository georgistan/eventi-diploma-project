package com.example.eventi.ui.app.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.eventi.navigation.BottomNavigation
import com.example.eventi.ui.app.components.analytics_screen.AnalyticsContent
import com.example.eventi.ui.app.components.memories_screen.MemoriesContent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AnalyticsScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Scaffold(
        modifier = modifier
            .padding(top = 16.dp),
        bottomBar = {
            BottomNavigation(
                navController = navController,
            )
        }
    ) {
        AnalyticsContent(
            modifier = modifier
        )
    }
}
package com.example.eventi.permissions

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.eventi.navigation.Navigation

@Composable
fun PermissionGivenContent(
) {
    val navController = rememberNavController()

    Navigation(
        navController = navController,
    )
}
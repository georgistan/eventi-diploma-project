package com.example.eventi.screens

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.eventi.navigation.BottomNavigation

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MemoriesScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Scaffold(
        modifier = modifier,
        bottomBar = {
            BottomNavigation(
                navController = navController,
            )
        }
    ) {

    }
}
package com.example.eventi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.eventi.navigation.Navigation
import com.example.eventi.repository.interests.Interest
import com.example.eventi.ui.theme.EventiTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EventiTheme {
                val navController = rememberNavController()

                Navigation(
                    navController = navController,
                )
            }
        }
    }
}
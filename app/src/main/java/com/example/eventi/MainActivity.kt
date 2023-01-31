package com.example.eventi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.eventi.navigation.Navigation
import com.example.eventi.ui.theme.EventiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EventiTheme {
                val navController = rememberNavController()

                Navigation(
                    navController = navController
                )
            }
        }
    }
}

val interestsData = listOf(
    "Business",
    "Science & Tech",
    "Health",
    "Community",
    "Family & Education",
    "Fashion",
    "School Activities",
    "Music",
    "Film & Media",
    "Travel & Outdoor",
    "Charity & Causes",
    "Government",
    "Home & Lifestyle",
    "Auto, Boat & Air",
    "Hobbies"
)
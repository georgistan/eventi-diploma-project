package com.example.eventi

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.datastore.dataStore
import androidx.navigation.compose.rememberNavController
import com.example.eventi.navigation.Navigation
import com.example.eventi.ui.theme.EventiTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
//    private val Context.dataStore by dataStore("eventi-application", AppSettingsSerializer)
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

val interestsData = listOf(
    "Academic",
    "Community",
    "Concerts",
    "Conferences",
    "Expos",
    "Festivals",
    "Performing Arts",
    "Sports"
)
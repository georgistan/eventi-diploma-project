package com.example.eventi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.eventi.navigation.Navigation
import com.example.eventi.ui.theme.EventiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EventiTheme {
                Navigation()
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
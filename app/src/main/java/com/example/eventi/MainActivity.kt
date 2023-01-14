package com.example.eventi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
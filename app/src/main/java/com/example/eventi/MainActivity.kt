package com.example.eventi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.eventi.permissions.RequestLocationPermission
import com.example.eventi.ui.theme.EventiTheme
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        setContent {
            EventiTheme {
                RequestLocationPermission(permission = android.Manifest.permission.ACCESS_FINE_LOCATION)
            }
        }
    }
}
package com.example.eventi.data.local.interests

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class Interest(
    val id: Int,
    var label: String,
    initialSelected: Boolean = false
) {
    var isSelected: Boolean by mutableStateOf(initialSelected)
}
package com.example.eventi.components.interest_screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.example.eventi.ui.theme.EventiTypography
import com.example.eventi.ui.theme.PrimaryOrange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InterestItem(
    content: String
) {
    var selected by rememberSaveable { mutableStateOf(false) }

    InputChip(
        selected = selected,
        onClick = { selected = !selected },
        label = {
            Text(
                text = content,
                color = if (selected) Color.White else Color.Gray,
                style = EventiTypography.subtitle1
            )
        },
        trailingIcon = {
            when {
                selected -> Icon(
                    Icons.Default.Close,
                    contentDescription = "Close",
                    tint = Color.White
                )
                else -> Icon(
                    Icons.Default.Add,
                    contentDescription = "Add",
                    tint = Color.Gray
                )
            }
        },
        colors = InputChipDefaults.inputChipColors(
            selectedContainerColor = PrimaryOrange
        )
    )
}
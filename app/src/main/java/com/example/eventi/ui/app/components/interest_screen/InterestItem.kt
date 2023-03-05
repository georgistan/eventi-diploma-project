package com.example.eventi.ui.app.components.interest_screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import com.example.eventi.ui.theme.EventiTypography
import com.example.eventi.ui.theme.PrimaryOrange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InterestItem(
    itemLabel: String,
    selected: Boolean,
    onClick: (Boolean) -> Unit,
) {
    InputChip(
        selected = selected,
        onClick = { onClick(!selected) },
        label = {
            Text(
                text = itemLabel,
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
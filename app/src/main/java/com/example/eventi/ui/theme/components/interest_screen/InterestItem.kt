package com.example.eventi.ui.theme.components.interest_screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import com.example.eventi.ui.theme.EventiTypography
import com.example.eventi.ui.theme.PrimaryOrange
import com.example.eventi.viewmodels.InterestsViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InterestItem(
    content: String,
//    viewModel: InterestsViewModel = viewModel()
) {
    var selected by rememberSaveable { mutableStateOf(false) }
//    var interestsList by viewModel.interests.collectAsState()

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
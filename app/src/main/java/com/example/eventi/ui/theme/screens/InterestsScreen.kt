package com.example.eventi.ui.theme.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.eventi.ui.theme.components.interest_screen.DoneButton
import com.example.eventi.ui.theme.components.interest_screen.Header
import com.example.eventi.ui.theme.components.interest_screen.InterestItemsGrid

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun InterestsScreen(
    onClickDoneButton: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold {
        Column(
            modifier = modifier
                .padding(top = 16.dp, bottom = 25.dp, start = 16.dp, end = 16.dp)
        ) {
            Header()
            InterestItemsGrid(modifier = modifier.weight(2f))
            DoneButton(onClickDoneButton = onClickDoneButton)
        }
    }
}
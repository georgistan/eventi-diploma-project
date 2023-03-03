package com.example.eventi.ui.app.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.eventi.ui.app.components.interest_screen.DoneButton
import com.example.eventi.ui.app.components.interest_screen.Header
import com.example.eventi.ui.app.components.interest_screen.InterestItemsGrid
import com.example.eventi.viewmodels.InterestsViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun InterestsScreen(
    onClickDoneButton: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: InterestsViewModel = hiltViewModel()
) {
    Scaffold {
        Column(
            modifier = modifier
                .padding(top = 16.dp, bottom = 25.dp, start = 16.dp, end = 16.dp)
        ) {
            Header()
            InterestItemsGrid(
                modifier = modifier.weight(2f),
                list = viewModel.interestsData,
                onClickItem = { item, selected ->
                    viewModel.changeInterestSelected(item, selected)
                }
            )
            DoneButton(
                onClickDoneButton = onClickDoneButton,
                onAddUserInterests = { viewModel.addInterestsToStorage() }
            )
        }
    }
}
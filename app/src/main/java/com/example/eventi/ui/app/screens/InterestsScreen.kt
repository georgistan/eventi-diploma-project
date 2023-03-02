package com.example.eventi.ui.app.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.eventi.ui.app.components.interest_screen.DoneButton
import com.example.eventi.ui.app.components.interest_screen.Header
import com.example.eventi.ui.app.components.interest_screen.InterestItemsGrid
import com.example.eventi.viewmodels.TestViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun InterestsScreen(
    onClickDoneButton: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: TestViewModel = viewModel()
) {
    Scaffold {
        Column(
            modifier = modifier
                .padding(top = 16.dp, bottom = 25.dp, start = 16.dp, end = 16.dp)
        ) {
            Header()
            InterestItemsGrid(
                modifier = modifier.weight(2f),
                list = viewModel.interestsList,
                onClickItem = { item, selected ->
                    viewModel.changeTaskChecked(item, selected)
                }
            )
            DoneButton(onClickDoneButton = onClickDoneButton)
        }
    }
}
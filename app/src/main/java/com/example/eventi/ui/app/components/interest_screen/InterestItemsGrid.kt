package com.example.eventi.ui.app.components.interest_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.eventi.data.local.interests.Interest

@Composable
fun InterestItemsGrid(
    modifier: Modifier,
    list: List<Interest>,
    onClickItem: (Interest, Boolean) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(top = 32.dp, bottom = 32.dp),
        modifier = modifier
    ) {
        items(
            items = list,
            key = { item -> item.id }
        ) { item ->
            InterestItem(
                itemLabel = item.label,
                selected = item.isSelected,
                onClick = { selected -> onClickItem(item, selected) }
            )
        }
    }
}
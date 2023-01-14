package com.example.eventi.components.interest_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.eventi.interestsData

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun InterestItemsGrid(
    modifier: Modifier
) {
    LazyVerticalGrid(
//                columns = object : GridCells{
//                    override fun Density.calculateCrossAxisCellSizes(
//                        availableSize: Int,
//                        spacing: Int
//                    ): List<Int> {
//                        val firstColumnWidth = (availableSize - spacing) * 2 / 3
//                        val secondColumnWidth = availableSize - spacing - firstColumnWidth
//                        return listOf(firstColumnWidth, secondColumnWidth)
//                    }
//                },
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(top = 32.dp, bottom = 32.dp),
        modifier = modifier
    ) {
        items(
            interestsData
        ) { item ->
            InterestItem(content = item)
        }
    }
}
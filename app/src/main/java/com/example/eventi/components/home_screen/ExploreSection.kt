package com.example.eventi.components.home_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Air
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.eventi.interestsData

@Composable
fun ExploreSection(
    modifier: Modifier,
    onClickExploreItem: () -> Unit,
    onClickViewAllButton: () -> Unit
) {
    Column(
        modifier = modifier
    ) {
        SectionHeading(
            modifier = modifier,
            contentTitle = "Explore others",
            onClick = onClickViewAllButton
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
        ) {
            items(
                interestsData.take(6)
            ) { item ->
                ExploreItem(
                    modifier = modifier,
                    contentTitle = item,
                    contentIcon = Icons.Default.Air,
                    onClick = onClickExploreItem
                )
            }
        }
    }
}

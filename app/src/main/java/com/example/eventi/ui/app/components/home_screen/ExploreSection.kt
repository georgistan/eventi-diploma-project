package com.example.eventi.ui.app.components.home_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.eventi.R

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
            contentTitle = stringResource(R.string.explore_others),
            onClick = onClickViewAllButton
        )
        Row {
            ExploreItem(
                modifier = modifier,
                contentTitle = "Education & Family",
                Icons.Outlined.FamilyRestroom,
                onClick = onClickExploreItem
            )
            ExploreItem(
                modifier = modifier,
                contentTitle = "Science",
                Icons.Outlined.Science,
                onClick = onClickExploreItem
            )
            ExploreItem(
                modifier = modifier,
                contentTitle = "Business",
                Icons.Outlined.Business,
                onClick = onClickExploreItem
            )
        }
        Spacer(modifier.height(16.dp))
        Row {
            ExploreItem(
                modifier = modifier,
                contentTitle = "Fast food",
                Icons.Outlined.Fastfood,
                onClick = onClickExploreItem
            )
            ExploreItem(
                modifier = modifier,
                contentTitle = "Film & Media",
                Icons.Outlined.MovieCreation,
                onClick = onClickExploreItem
            )
            ExploreItem(
                modifier = modifier,
                contentTitle = "Casino",
                Icons.Outlined.Casino,
                onClick = onClickExploreItem
            )
        }
    }
}

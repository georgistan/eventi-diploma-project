package com.example.eventi.ui.app.components.home_screen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.eventi.R
import com.example.eventi.ui.theme.EventiTypography
import com.example.eventi.ui.theme.PrimaryOrange

@Composable
fun SectionHeading(
    modifier: Modifier,
    sectionCategory: String
) {
    Row(
        modifier = modifier
            .padding(top = 40.dp, start = 16.dp, end = 16.dp, bottom = 8.dp)
    ) {
        Text(
            text = stringResource(id = R.string.we_suggest_you),
            style = EventiTypography.h2,
        )
        Text(
            text = " $sectionCategory",
            style = EventiTypography.h2,
            color = PrimaryOrange
        )
        Text(
            text = " events",
            style = EventiTypography.h2,
        )
    }
}
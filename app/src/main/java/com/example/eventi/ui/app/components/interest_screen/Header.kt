package com.example.eventi.ui.app.components.interest_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.eventi.R
import com.example.eventi.ui.theme.EventiTypography

@Composable
fun Header(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = R.string.your_interests),
            style = EventiTypography.h2
        )
        Text(
            text = stringResource(id = R.string.pick_interests_instruction),
            style = EventiTypography.subtitle1
        )
    }
}
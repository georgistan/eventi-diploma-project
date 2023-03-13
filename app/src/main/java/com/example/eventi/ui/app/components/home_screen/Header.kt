package com.example.eventi.ui.app.components.home_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.eventi.R
import com.example.eventi.ui.theme.EventiTypography
import com.example.eventi.ui.theme.OrangeLight
import com.example.eventi.ui.theme.OrangeLightest

@Composable
fun Header(
    modifier: Modifier,
) {
    Column(
        modifier = modifier
            .padding(end = 16.dp, start = 16.dp)
    ) {
        Surface(
            modifier = modifier,
            color = OrangeLightest,
            border = BorderStroke(1.dp, OrangeLight),
            shape = RoundedCornerShape(8.dp),
            elevation = 0.dp
        ) {
            Column(
                modifier = modifier
                    .padding(top = 10.dp, start = 16.dp, end = 16.dp, bottom = 10.dp)
            ) {
                Text(
                    text = stringResource(R.string.find_events_near),
                    style = EventiTypography.subtitle2
                )
                Row(
                    modifier = modifier
                        .fillMaxWidth(),
                ) {
                    Box(
                        modifier = modifier.weight(1f)
                    ) {
                        Text(
                            text = "Sofia",
                            style = EventiTypography.h1
                        )
                    }
                }
            }
        }
    }
}
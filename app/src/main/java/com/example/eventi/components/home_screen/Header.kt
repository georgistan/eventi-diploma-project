package com.example.eventi.components.home_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NearMe
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eventi.ui.theme.Blue
import com.example.eventi.ui.theme.OrangeLight
import com.example.eventi.ui.theme.OrangeLightest

@Composable
fun Header(
    modifier: Modifier,
    onClickChangeLocation: () -> Unit
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
                    text = "find event near"
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
                            style = MaterialTheme.typography.h4
                        )
                    }
                    // TODO: make those widgets into one
                    IconButton(
                        onClick = onClickChangeLocation
                    ) {
                        Icon(
                            Icons.Default.NearMe,
                            contentDescription = null,
                            tint = Blue
                        )
                    }
                    TextButton(
                        onClick = onClickChangeLocation
                    ) {
                        Text(
                            text = "change location",
                            color = Blue,
                            letterSpacing = 0.sp
                        )
                    }
                    // ---------------------------------
                }
            }
        }
        SearchBar(
            modifier = modifier
        )
    }
}
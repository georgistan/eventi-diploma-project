package com.example.eventi.ui.app.components.analytics_screen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eventi.R
import com.example.eventi.ui.theme.EventiTypography

@Composable
fun AnalyticsContent(
    modifier: Modifier
) {
    LazyColumn {
        item {
            Row(
                modifier = modifier
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.analytics),
                    style = EventiTypography.h2
                )
            }
        }
        item { Divider() }
        item { PieChart(modifier = modifier) }
    }
}

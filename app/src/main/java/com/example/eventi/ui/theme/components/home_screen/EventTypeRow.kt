package com.example.eventi.ui.theme.components.home_screen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.eventi.R
import com.example.eventi.ui.theme.EventiTypography
import com.example.eventi.ui.theme.PrimaryBlue

@Composable
fun EventTypeRow(
    modifier: Modifier
) {
    Row {
        Icon(
            Icons.Default.LocationOn,
            contentDescription = null
        )
        Text(
            text = stringResource(R.string.online_event),
            modifier.paddingFromBaseline(top = 20.dp),
            style = EventiTypography.subtitle2
        )
        Spacer(modifier = modifier.weight(2f))
        IconButton(
            onClick = { /*TODO*/ }
        ) {
            Icon(
                Icons.Outlined.Bookmark,
                contentDescription = null,
                tint = PrimaryBlue
            )
        }
    }
}
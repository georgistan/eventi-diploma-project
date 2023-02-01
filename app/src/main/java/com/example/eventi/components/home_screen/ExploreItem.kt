package com.example.eventi.components.home_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eventi.ui.theme.Blue

@Composable
fun ExploreItem(
    modifier: Modifier,
    contentTitle: String,
    contentIcon: ImageVector,
    onClick: () -> Unit
) {
    Surface(
        modifier = modifier
            .padding(start = 16.dp, end = 16.dp)
            .width(100.dp)
            .heightIn(min = 100.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(0.dp, Color.Gray)
    ) {
        Column(
            modifier = modifier
                .padding(top = 8.dp, start = 14.dp, end = 14.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                modifier = modifier
                    .widthIn(72.dp)
                    .heightIn(40.dp),
                color = Blue,
                shape = RoundedCornerShape(10.dp)
            ) {
                Icon(
                    contentIcon,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = modifier
                        .size(24.dp, 24.dp)
                )
            }
            Spacer(modifier.height(16.dp))
            Text(
                contentTitle,
                overflow = TextOverflow.Clip,
                maxLines = 2,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 12.sp
                )
            )
        }
    }
}

package com.example.eventi.ui.theme.components.interest_screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.eventi.ui.theme.EventiTypography
import com.example.eventi.ui.theme.PrimaryOrange

@Composable
fun DoneButton(
    onClickDoneButton: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        shape = RoundedCornerShape(10),
        onClick = onClickDoneButton,
        colors = ButtonDefaults.buttonColors(PrimaryOrange),
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Done",
            style = EventiTypography.subtitle1,
            color = Color.White
        )
    }
}
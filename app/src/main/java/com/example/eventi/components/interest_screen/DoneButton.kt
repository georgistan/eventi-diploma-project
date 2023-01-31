package com.example.eventi.components.interest_screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.eventi.navigation.Screen
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
            style = MaterialTheme.typography.subtitle1,
            color = Color.White
        )
    }
}
package com.example.coffe4coders.ui.componets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffe4coders.ui.theme.Coffe4codersTheme

typealias buttonAction = ()-> Unit

@Composable
fun customButton(label: String,action: buttonAction) {
    val uppercaedLabel = label.uppercase() //Para que siempre sea mayuscula el label que envíe
    
    Button(
        onClick = { action() },
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.secondary,
            contentColor = Color.White
        ),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 6.dp,
            pressedElevation = 8.dp,
            disabledElevation = 0.dp
        )

    ) {
        Text(uppercaedLabel)
    }
}

@Preview(
    showBackground = true
)
@Composable
fun customButtonPreview() {
    Coffe4codersTheme() {
        Box(
            modifier = Modifier.padding(16.dp)
        ) {
            customButton("Button"){

            }
        }

    }
}
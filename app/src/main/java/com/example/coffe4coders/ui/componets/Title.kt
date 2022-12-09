package com.example.coffe4coders.ui.componets

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.coffe4coders.ui.theme.Coffe4codersTheme

@Composable
fun titleText(title: String) {
    Text(title, style = MaterialTheme.typography.h3)
}

@Preview(
    showBackground = true
)
@Composable
fun titleTextPreview() {
    Coffe4codersTheme {
        titleText("Title")
    }

}
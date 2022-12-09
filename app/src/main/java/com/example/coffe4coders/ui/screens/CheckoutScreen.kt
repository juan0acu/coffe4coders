package com.example.coffe4coders.ui.screens

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.coffe4coders.ui.componets.customTextField
import com.example.coffe4coders.ui.componets.dropdownTextField
import com.example.coffe4coders.ui.theme.Coffe4codersTheme

@Composable
fun checkoutScreen() {
    val cities = listOf(
        "Ciudad de Mexico, Mexico",
        "La Habana, Cuba",
        "Buenos Aires, Argentina",
        "Bogota, Colombia",
        "Anzoategui, Venezuela",
    )
//    var name by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }


   /* customTextField(value = name, placeholder = "Nombre"){
            name = it
        }*/

    dropdownTextField(suggestions = cities, value = city, placeholder ="Ciudades"){
        city = it
    }
}

@Preview(showBackground = true)
@Composable
fun checkoutScreenView() {
    Coffe4codersTheme() {
        checkoutScreen()
    }

}
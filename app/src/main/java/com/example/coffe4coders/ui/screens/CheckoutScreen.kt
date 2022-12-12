package com.example.coffe4coders.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coffe4coders.ui.componets.*
import com.example.coffe4coders.ui.theme.Coffe4codersTheme

@Composable
fun checkoutScreen(navController: NavController, country: CountryIso) {
    val cities = listOf(
        "Ciudad de Mexico, Mexico",
        "La Habana, Cuba",
        "Buenos Aires, Argentina",
        "Bogota, Colombia",
        "Anzoategui, Venezuela",
    )
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }

    Scaffold (
        topBar ={
            customAppBar(navigationIcon = Icons.Filled.ArrowBack){
                navController.navigate("detail/${country.iso}")
            }
        }, content = {
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                productCard(name = "Café de Colombia",
                    summary ="Café de las montañas" ,
                    price =35.0 ,
                    currency ="USD" ,
                    country = country ) {
                }
                Column(
                    modifier = Modifier.padding(16.dp)) {
                    customTextField(value = name, placeholder = "Nombre completo"){
                        name = it
                    }
                    customTextField(value = email, placeholder = "Correo electronico", keyboardType = KeyboardType.Email){
                        email = it
                    }
                    customTextField(value = phone, placeholder = "Número de télefono",keyboardType = KeyboardType.Phone){
                        phone = it
                    }
                    customTextField(value = address, placeholder = "Dirección de envío"){
                        address = it
                    }
                    dropdownTextField(suggestions = cities, value = city, placeholder ="Ciudad"){
                        city = it
                    }
                    Column {
                        Row {
                            Text("Sub Total", style = MaterialTheme.typography.caption)
                            Text("$ 35.0 USD",
                                style = MaterialTheme.typography.body2,
                            modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.End)

                        }
                        Row {
                            Text("Envío", style = MaterialTheme.typography.caption)
                            Text("$ 15.0 USD", style = MaterialTheme.typography.body2,
                                modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.End)
                        }
                    }
                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        Text(
                            "$ 45.0 USD",
                            style = MaterialTheme.typography.h5,
                            textAlign = TextAlign.Start
                        )
                        customButton(label = "Finalizar pedido") {

                        }
                    }
                }
            }


        })

   /* customTextField(value = name, placeholder = "Nombre"){
            name = it
        }*/

}

@Preview(showBackground = true)
@Composable
fun checkoutScreenView() {
    val navController = rememberNavController()

    Coffe4codersTheme() {
        checkoutScreen(navController,CountryIso.COL)
    }

}
package com.example.coffe4coders.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coffe4coders.ui.componets.*
import com.example.coffe4coders.ui.theme.Coffe4codersTheme

@Composable
fun feedScreen(navController: NavController) {
    val list = listOf<CountryIso>(
        CountryIso.BRA,CountryIso.COL,CountryIso.CRI,CountryIso.NIC
    )

    Coffe4codersTheme {
        Scaffold (
            topBar = {
                customAppBar("Café4Coders")
            },
            content = {
                Surface(
                    color = MaterialTheme.colors.background) {
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        item {
                            Column(
                                modifier = Modifier.padding(8.dp)
                            ) {
                                titleText("Bienvenidos")
                                bodyText("Ordena tus maravillos cafés, en apenas un OnClick")
                            }
                        }
                        items(list){ country ->
                            productCard(
                                name = "Café Brasil" ,
                                summary = "Hecho en los mejores campos" ,
                                price = 35.0 ,
                                currency = "USD",
                                country = country){
                                navController.navigate("detail/${country.iso}"){
                                    launchSingleTop = true
                                }
                            }
                        }
                    }
                }
            }
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
fun feedScreenPreviwe() {
    val navController = rememberNavController()
    feedScreen(navController)
}
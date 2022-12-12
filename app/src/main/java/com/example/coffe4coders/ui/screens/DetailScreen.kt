package com.example.coffe4coders.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coffe4coders.ui.componets.*
import com.example.coffe4coders.ui.theme.Coffe4codersTheme

@Composable
fun detailScreen(navController: NavController,countryIso: CountryIso) {
    Scaffold(
        topBar = {
            //Ver que pasa aqui
            customAppBar(navigationIcon = Icons.Filled.ArrowBack) {
                navController.navigate("feed"){
                    popUpTo("feed")
                }
            }
        },
        content = {
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                Box (
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                        .padding(top = 5.dp)
                        ) {
                            Image(painter = painterResource(id = countryIso.getBackgroundImage()),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )
                }
                Column(modifier = Modifier.padding(16.dp)) {
                    titleText("Café de Colombia")
                    Text("Aroma de mujer",
                    style = MaterialTheme.typography.caption)
                    Spacer(modifier = Modifier.height(24.dp))
                    bodyText("Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit. Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit")
                    Spacer(modifier = Modifier.height(24.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        Text("$ 35.0 USD",
                        style = MaterialTheme.typography.h5,
                        textAlign = TextAlign.End
                        )
                        customButton(label = "Continuar") {
                            navController.navigate("checkout/${countryIso.iso}"){
                                launchSingleTop = true

                        }
                    }
                }
            }
        }
})
}

@Preview(
    showBackground = true
)
@Composable
fun detailScreenPreview() {
    val navController = rememberNavController()
    Coffe4codersTheme() {
        detailScreen(navController, CountryIso.COL)
    }
}
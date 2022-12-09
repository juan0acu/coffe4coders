package com.example.coffe4coders.ui.componets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffe4coders.R
import com.example.coffe4coders.ui.theme.Coffe4codersTheme
import com.example.coffe4coders.ui.theme.PlatziGreen

enum class CountryIso(val iso: String){
    //Clase me permite definir las diferentes acciones por opciones depende de lo que seleccione

    COL("COL"),
    BRA("BRA"),
    CRI("CRI"),
    NIC("Nic");

    fun getBackgroundImage(): Int{
        when(this){
            COL -> return R.drawable.co
            BRA -> return R.drawable.br
            CRI -> return R.drawable.ri
            NIC -> return R.drawable.ni

        }
    }

    fun getCountryFlag(): Int{
        when(this){
            COL -> return R.drawable.flagco
            BRA -> return R.drawable.flagbr
            CRI -> return R.drawable.flagri
            NIC -> return R.drawable.flagni
        }
    }

    fun getSurfaceColor(): androidx.compose.ui.graphics.Color {
        when(this){
            COL,NIC -> return PlatziGreen
            BRA,CRI -> return PlatziGreen
        }
    }
}

typealias selectionAction = () -> Unit

@Composable
fun productCard(name: String,
                summary: String,
                price: Double,
                currency: String,
                country: CountryIso,
                selected: selectionAction) {
  Card (
      modifier = Modifier
          .fillMaxWidth()
          .padding(16.dp)
          .clickable {
              selected()
          }
          .size(480.dp)
          , elevation = 10.dp
          , shape = MaterialTheme.shapes.medium
          ){
      Image(painter = painterResource(country.getBackgroundImage()), contentDescription = null)
      Surface(
          modifier = Modifier
              .fillMaxWidth()
              ,color = country.getSurfaceColor().copy(alpha = 0.2f) //Toque azulado al fondo
      ) { //Se coloca aca ya que necesitamos que este encima de la imagen que es lo que hace nuestra Surface
          Column (
              horizontalAlignment = Alignment.CenterHorizontally
              , modifier = Modifier.padding(16.dp)
                  ){
              Text(name, style = MaterialTheme.typography.h4)
              Text(summary, style = MaterialTheme.typography.body1)
              Column(
                  modifier = Modifier
                  .fillMaxSize() //para que ocupe el espacio restante
                  , verticalArrangement = Arrangement.Bottom //para que se cree al fondo
              ) {
                  Row {
                      Image(painter = painterResource(country.getCountryFlag()), contentDescription =null,
                      modifier = Modifier.size(32.dp,32.dp))
                      Text("$ $price $currency",
                      modifier = Modifier.fillMaxWidth()
                      , textAlign = TextAlign.End,
                      style = MaterialTheme.typography.h4)
                  }
              }
          }
      }
  }
}

@Preview(
    showBackground = true
)
@Composable
fun productCardPreview() {
    Coffe4codersTheme {
        productCard("Café de Brasil","Café de las mejores montañas",35.0,"USD", CountryIso.BRA){}
    }
}
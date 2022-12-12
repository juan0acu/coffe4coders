package com.example.coffe4coders.ui.componets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.toSize
import androidx.compose.runtime.setValue

@Composable
fun dropdownTextField(suggestions:List<String>,
                      value: String,
                      placeholder: String,
                      onChangeValue: (String)-> Unit
){
    var expanded by remember{ mutableStateOf(false) }
    var textFieldSize by remember{ mutableStateOf(Size.Zero) }
    val icon = Icons.Filled.ArrowDropDown

    Column {
        customTextField(
            value = value,
            placeholder = placeholder,
            onValueChange = onChangeValue,
            enabled = false,
            trailingIcon = {
                Icon(icon, contentDescription = null,
                modifier = Modifier.clickable {
                    expanded = !expanded
                })
            },
            onGlobalPositioned ={ coordinates ->
                textFieldSize = coordinates.size.toSize()
        }
        )

        DropdownMenu(expanded = expanded,
            onDismissRequest = { expanded = false },
        modifier = Modifier.width(with(LocalDensity.current){
            textFieldSize.width.toDp()
        })
        ) {
            suggestions.forEach { label ->
                DropdownMenuItem(onClick = {
                    onChangeValue(label)
                    expanded = !expanded
                }) {
                    Text(label, style = MaterialTheme.typography.body2)
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun dropdownTextFieldPreview() {
    val cities = listOf(
        "Ciudad de Mexico, Mexico",
        "La Habana, Cuba",
        "Buenos Aires, Argentina",
        "Bogota, Colombia",
        "Anzoategui, Venezuela",
    )
dropdownTextField(cities,"","Ciudades"){}
}
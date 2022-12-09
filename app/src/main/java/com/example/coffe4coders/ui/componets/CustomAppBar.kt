package com.example.coffe4coders.ui.componets

import android.widget.ImageButton
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

typealias navigationAction = () -> Unit
@Composable
fun customAppBar( title : String?=null,
                  navigationIcon: ImageVector?=null,
                  navigationAction: navigationAction? = null){
            val titleText = title ?:""
            if (navigationIcon != null && navigationAction != null){
                TopAppBar(
                    title = {Text(titleText)},
                    navigationIcon ={
                      IconButton(onClick = {
                          navigationAction() })
                      {
                          Icon(navigationIcon,"")
                      }
                    },
                    backgroundColor = MaterialTheme.colors.primary
                )
            } else {
                    TopAppBar(
                        title = {Text(titleText)},
                        backgroundColor = MaterialTheme.colors.primary
                    )
            }
}

@Preview(
    showBackground = true)
@Composable
fun customAppBarPreview() {
    MaterialTheme {
        customAppBar("Café4Coders")
    }
}
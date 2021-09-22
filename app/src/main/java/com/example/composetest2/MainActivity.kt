package com.example.composetest2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetest2.ui.theme.ComposeTest2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTest2Theme(darkTheme = true) {
                Greeting("Hello")
            }
        }
    }
}

@Composable
fun Greeting(txt: String) {
    var someText by remember { mutableStateOf(txt) }
    val styler = TextStyler()
    val listOfLabels by remember {mutableStateOf(
        MutableList<String>(styler.getAlphabetCount()) { txt }
    )}

    Column() {
        TextField(value = someText, onValueChange = {
            someText = it
            repeat(listOfLabels.count()) { _index ->
                listOfLabels[_index] = styler.switchToUnicode(it, _index)
            }
        })
        AddTextLabels(listOfLabels)
    }
}

@Composable
fun AddTextLabels(list: List<String>) {
    repeat(list.count()) {
        Text(list[it])
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTest2Theme { }
}
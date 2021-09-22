package com.example.composetest2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetest2.ui.theme.ComposeTest2Theme

class MainActivity : ComponentActivity() {
    val t = 11
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
fun Greeting(name: String) {
    var someText by remember { mutableStateOf(name) }
    val styler = TextStyler()

    val listOfLabels by remember {mutableStateOf(
        MutableList<String>(styler.getAlphabetCount()) { "" }

    )}


    Column() {
        TextField(value = someText, onValueChange = {
            someText = it
            repeat(listOfLabels.count()) { _index ->
                listOfLabels[_index] = styler.switchToUnicode(it, _index)
            }
            //someText2 = t.switchToUnicode(it, 1)
        })
        doSomeThing(listOfLabels)
    }
}

@Composable
fun doSomeThing(list: List<String>) {
    repeat(list.count()) {
        Text(list[it])
    }

}

fun useSomeState(someText: String) {
    println("some")
    Log.i("some", "123")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTest2Theme {

    }
}
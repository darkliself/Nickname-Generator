package com.example.composetest2.backup


class Backup {
    /*
    package com.example.composetest2

    import android.os.Bundle
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.compose.foundation.border
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.Row
    import androidx.compose.foundation.layout.size
    import androidx.compose.foundation.lazy.LazyColumn
    import androidx.compose.foundation.lazy.items
    import androidx.compose.material.*
    import androidx.compose.runtime.*
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.text.TextStyle
    import androidx.compose.ui.text.style.TextAlign
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.compose.ui.unit.dp
    import com.example.composetest2.ui.theme.ComposeTest2Theme
    import com.example.composetest2.ui.theme.border

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
        val listOfLabels by remember {
            mutableStateOf(
                MutableList<String>(styler.getAlphabetCount()) { txt }
            )
        }

        Column() {
            TextField(
                value = someText,
                modifier = Modifier
                    .border(border = border),
                textStyle = TextStyle(textAlign = TextAlign.Center),
                onValueChange = {
                    someText = it
                    repeat(listOfLabels.count()) { _index ->
                        listOfLabels[_index] = styler.rootToUnicode(it, _index)
                    }
                },
            )
            Row() {
                PrefixSuffixListView()
                PrefixSuffixListView()
            }
            AddTextLabels(listOfLabels)
        }
    }

    @Composable
    fun AddTextLabels(list: List<String>) {
        repeat(list.count()) {
            Text(
                list[it],
                Modifier
                    .border(border)
                    .size(800.dp, 30.dp),
                textAlign = TextAlign.Center
            )
        }
    }

    @Composable
    fun PrefixSuffixListView() {
        LazyColumn(
            Modifier
                .border(border)
                .size(50.dp, 100.dp)
        ) {
            items(listOf("123", "123", "213", "123", "123", "213")) { item ->
                Text(item)
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ComposeTest2Theme { }
    }
    */
}
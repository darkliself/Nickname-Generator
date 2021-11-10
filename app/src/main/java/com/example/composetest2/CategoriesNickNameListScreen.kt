package com.example.composetest2

import androidx.compose.foundation.Image
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetest2.components.Header
import com.example.composetest2.components.SmallButton

@ExperimentalComposeUiApi
@Composable
fun CategoriesNickNameListScreen() {
    val (item1, item2, item3) = remember { FocusRequester.createRefs() }
    var all by remember { mutableStateOf(Color.White) }
    var new by remember { mutableStateOf(Color.White) }
    var popular by remember { mutableStateOf(Color.White) }

    Image(
        ImageVector.vectorResource(id = R.drawable.view_01_bg),
        contentDescription = null,
        Modifier
            .fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
    Box(
        Modifier.fillMaxSize(),
    ) {
        SmallButton(
            modifier = Modifier
                .align(BiasAlignment(0f, -1f))
                .fillMaxHeight(0.1f),
            iconModifier = Modifier
                .align(Alignment.CenterStart),
            image = R.drawable.arrow_left_icon
        )
        Header(
            "Category name \"Emoji\"",
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.1f)
                .align(BiasAlignment(0f, -1f))
        )
        // Filter buttons
        Row(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.1f)
                .align(BiasAlignment(0f, -0.8f))
        ) {
            Button(
                onClick = {
                    item1.requestFocus()
                },
                modifier = Modifier
                    .focusRequester(item1)
                    .onFocusChanged { all = if (it.isFocused) Color.Green else Color.White }
                    .focusable(),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = all
                )
            ) {
                Text("ALL")
            }
            Button(
                onClick = {
                    item2.requestFocus()
                },
                modifier = Modifier
                    .focusRequester(item2)
                    .onFocusChanged { new = if (it.isFocused) Color.Green else Color.White }
                    .focusable(),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = new
                )
            ) {
                Text("NEW")
            }
            Button(
                onClick = {
                    item3.requestFocus()
                },
                modifier = Modifier
                    .focusRequester(item3)
                    .onFocusChanged { popular = if (it.isFocused) Color.Green else Color.White }
                    .focusable(),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = popular
                )
            ) {
                Text("POPULAR")
            }
        }
        LazyColumn(
            Modifier.fillMaxWidth().fillMaxHeight().align(BiasAlignment(-0.8f, 0.5f))
        ) {
            items(20) { index ->
                Text("Item: $index")
            }
        }
    }
}

@ExperimentalComposeUiApi
@Preview
@Composable
private fun Preview() {
    CategoriesNickNameListScreen()
}
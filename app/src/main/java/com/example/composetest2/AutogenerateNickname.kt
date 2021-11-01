package com.example.composetest2

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetest2.ui.theme.MenuButton
import com.example.composetest2.ui.theme.TextBox


@Composable
fun AutogenerateNickname() {
    Box(
        Modifier.fillMaxSize()
    ) {
        Header()
    }
}


@Preview
@Composable
private fun defPreview() {
    AutogenerateNickname()
}


@Composable
private fun Header() {
    Box(
        Modifier
            .fillMaxWidth(0.9f)
            .fillMaxHeight(0.1f),
        Alignment.Center

    ) {
        MenuButton(
            Modifier.align(BiasAlignment(1f, -1f))
        )
        TextBox(text = "Autogenerate nickname", modifier = Modifier.align(BiasAlignment(0f, 0f)))
    }
}
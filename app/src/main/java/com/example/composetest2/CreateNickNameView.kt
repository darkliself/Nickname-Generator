package com.example.composetest2

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetest2.ui.theme.Header
import com.example.composetest2.ui.theme.TextBox

@Composable
fun CreateNickNameView() {
    Box(
        Modifier.fillMaxSize()
    ) {
        Box(
            Modifier.fillMaxHeight(0.1f).fillMaxWidth()
        ) {
            Header(modifier = Modifier
                .align(BiasAlignment(0f, 0f))
                .fillMaxHeight(0.1f),
                iconModifier = Modifier
                    .align(Alignment.CenterEnd)
                    .clickable {
                        Log.i(">>>>>>>>>>>>>>>>>", "its here")
                    }
            )
            TextBox(
                "Create custom nickname",
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .fillMaxHeight(0.1f)
                    .align(BiasAlignment(0f, 0f))
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    CreateNickNameView()
}

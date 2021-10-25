package com.example.composetest2

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.composetest2.ui.theme.Header
import com.example.composetest2.ui.theme.TextBox


@Composable
fun SecondView(context: Context) {
    Image(
        ImageVector.vectorResource(id = R.drawable.view_02_bg),
        null,
        Modifier.fillMaxSize(),

        contentScale = ContentScale.FillBounds
    )
    Box(
        Modifier.fillMaxSize(),
        Alignment.TopCenter
    ) {
        Header( modifier = Modifier
            .align(BiasAlignment(0f, -1f))
            .fillMaxHeight(0.1f),
        iconModifier = Modifier.align(Alignment.CenterEnd)
           )
        TextBox(
            "Category",
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.1f)
                .align(BiasAlignment(0f, -1f))
        )

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    SecondView(LocalContext.current)
}

//
//fun testClickToast(context: Context) {
//    Toast.makeText(context, "its clicked", Toast.LENGTH_SHORT).show()
//}


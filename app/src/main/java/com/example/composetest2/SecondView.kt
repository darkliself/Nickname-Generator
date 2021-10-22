package com.example.composetest2

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
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


@Composable
fun SecondView(contex: Context) {
    Image(
        ImageVector.vectorResource(id = R.drawable.bg_category_view),
        null,
        Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
    Box(
        Modifier.fillMaxSize()
    ) {
        Header(contex)
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    //SecondView(LocalContext.current)
}

@Composable
fun Header(context: Context) {
    Box(
        Modifier
            .fillMaxWidth(0.8f)
            .fillMaxHeight(0.2f)
            .background(Color.Cyan)

    ) {
        Text("some text", Modifier.align(Alignment.Center))
        Image(
            ImageVector.vectorResource(id = R.drawable.menu),
            contentDescription = null,
            Modifier.align(
                BiasAlignment(0f, 0f)
            )
        )
    }
    Box(
        Modifier
            .fillMaxWidth(0.8f)
            .fillMaxHeight(0.2f)
            .background(Color.Cyan)

    )
}
//
//fun testClickToast(context: Context) {
//    Toast.makeText(context, "its clicked", Toast.LENGTH_SHORT).show()
//}
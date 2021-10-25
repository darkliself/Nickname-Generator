package com.example.composetest2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CreateNickNameView() {
    Image(ImageVector.vectorResource(R.drawable.view_01_bg), null, contentScale = ContentScale.FillBounds )
    Box(
        Modifier.fillMaxSize()
    ) {
        Box() {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    CreateNickNameView()
}

fun Header() {

}

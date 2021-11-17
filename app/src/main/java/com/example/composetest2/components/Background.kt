package com.example.composetest2.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import com.example.composetest2.R


@Composable
fun Background(
    @DrawableRes image: Int
) {
    Image(
        ImageVector.vectorResource(id = image),
        null,
        Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
}
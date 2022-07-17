package com.example.textstyler.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.textstyler.R

@Composable
fun SmallButton(
    modifier: Modifier = Modifier,
    iconModifier: Modifier = Modifier,
    @DrawableRes image: Int = R.drawable.btn_menu,
    onClick: () -> Unit = { println("clicked") }
) {
    Box(
        modifier = modifier
            .fillMaxWidth(0.15f)
            .fillMaxHeight(0.1f)
            .clickable { onClick() }
    ) {
        Image(
            ImageVector.vectorResource(image),
            contentDescription = null,
            modifier = iconModifier.size(30.dp, 30.dp).align(Alignment.Center),
        )
    }
}

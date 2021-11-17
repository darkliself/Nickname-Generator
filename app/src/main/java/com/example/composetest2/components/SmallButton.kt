package com.example.composetest2.components

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.composetest2.R


@Composable
fun SmallButton(
    modifier: Modifier,
    iconModifier: Modifier = Modifier.size(35.dp, 35.dp),
    @DrawableRes image: Int = R.drawable.btn_menu,
    onClick: () -> Unit = { println("clicked") }
) {
    Box(
        modifier
            .fillMaxHeight(0.2f)
            .fillMaxWidth(0.9f)
    ) {
        Image(
            ImageVector.vectorResource(image),
            contentDescription = null,
            modifier = iconModifier.clickable { onClick() }
        )
    }
}

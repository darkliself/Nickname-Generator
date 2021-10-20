package com.example.composetest2.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex


@Composable
@Note("You need to 2 elements in list for icon, first is background and second is center of the icon, its temporary until designer makes normal icons")
fun IconForButton(
    @DrawableRes iconId: List<Int>,
    modifier: Modifier,
) {
    Box(
        modifier = modifier,
        Alignment.Center,


    ) {
        Image(
            ImageVector.vectorResource(id = iconId[0]),
            null,
            Modifier
                .fillMaxSize()
                .zIndex(1f)
        )
        Image(
            ImageVector.vectorResource(id = iconId[1]),
            null,
            Modifier
                .fillMaxSize(0.5f)
                .zIndex(2f)
        )
    }
}

@Composable
fun ButtonWithImage(
    text: String,
    @DrawableRes image: Int,
    modifier: Modifier,
    textModifier: Modifier = Modifier.padding(start = 100.dp, bottom = 5.dp, end = 5.dp),
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            modifier = textModifier
                .zIndex(3F),
            color = Color.Black
        )
        Image(
            ImageVector.vectorResource(id = image),
            null,
            Modifier.fillMaxSize()
        )
    }
}

annotation class Note(val explain: String)
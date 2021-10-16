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
        Alignment.Center

    ) {
        Image(
            ImageVector.vectorResource(id = iconId[0]),
            "icon ${iconId[0]}",
            Modifier
                .fillMaxSize()
                .zIndex(1f)
        )
        Image(
            ImageVector.vectorResource(id = iconId[1]),
            "background ${iconId[1]}",
            Modifier
                .fillMaxSize(0.5f)
                .zIndex(2f)
        )
    }
}

@Composable
fun ButtonWithImages(
    txt: String,
    @DrawableRes imagesIds: List<Int>,
    modifier: Modifier,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = txt,
            Modifier
                .zIndex(3F)
                .padding(bottom = 5.dp, end = 5.dp),
            color = Color.Black
        )
        // icon box
        Image(
            ImageVector.vectorResource(id = imagesIds[0]),
            imagesIds.toString(),
            Modifier
                .size(300.dp, 180.dp)
                .zIndex(2f)
                .padding(bottom = 5.dp, end = 5.dp)
        )
        Image(
            ImageVector.vectorResource(id = imagesIds[1]), imagesIds.toString(),
            Modifier
                .size(300.dp, 180.dp)
                .zIndex(1f)
                .padding(top = 5.dp, start = 5.dp)
        )
    }
}

annotation class Note(val explain: String)
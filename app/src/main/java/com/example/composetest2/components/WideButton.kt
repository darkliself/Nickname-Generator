package com.example.composetest2.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.composetest2.R
import com.example.composetest2.Screen
import com.example.composetest2.TextStyler

@Composable
fun WideButton(
    @DrawableRes image: Int,
    text: String,
    modifier: Modifier = Modifier,
    imageModifier: Modifier = Modifier,
    textModifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center,
    fontSize: TextUnit = 18.sp,
    fontFamily: FontFamily = FontFamily(listOf(Font(R.font.montserrat_medium))),
    fontWeight: FontWeight = FontWeight.W900,
    ) {
    Box(
        modifier
            .fillMaxWidth(0.9f)
            .fillMaxHeight(0.15f)
        //.align(BiasAlignment(0f, 0.2f))
    ) {
        Image(
            ImageVector.vectorResource(image),
            null,
            imageModifier.align(Alignment.Center)
                //.wrapContentSize()
                .clickable {
                    println("clicked on $this")
                },
            contentScale = ContentScale.FillWidth

        )
        Text(
            text = text,
            modifier = textModifier.align(Alignment.Center),
            textAlign = textAlign,
            fontSize = fontSize,
            fontFamily = fontFamily,
            fontWeight = fontWeight,
        )
    }
}


object TextModifier {
    val modifier = Modifier
    val textAlign = TextAlign.Center
    val fontSize = 18.sp
    val fontFamily = FontFamily(listOf(Font(R.font.montserrat_medium)))
    val fontWeight = FontWeight.W900
}
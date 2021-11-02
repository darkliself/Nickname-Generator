package com.example.composetest2.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.composetest2.R

@Composable
fun WideButton(modifier: Modifier = Modifier,  @DrawableRes image: Int, text: String) {
    Box(
        modifier

            .fillMaxWidth(0.9f)
            .fillMaxHeight(0.15f)
        //.align(BiasAlignment(0f, 0.2f))
    ) {
        Image(
            ImageVector.vectorResource(image),
            null,
            Modifier
                .fillMaxSize()
                .wrapContentSize()
                .clickable {
                    println("clicked on $this")
                }
        )
        Text(
            text = text,
            modifier = Modifier.align(Alignment.Center),
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontFamily = FontFamily(listOf(Font(R.font.montserrat_medium))),
            fontWeight = FontWeight.W900,
        )
    }
}
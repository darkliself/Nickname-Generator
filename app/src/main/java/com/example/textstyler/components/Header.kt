package com.example.textstyler.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.textstyler.R
// import com.example.composetest2.ui.theme.TextBox


@Composable
fun Header(text: String, modifier: Modifier = Modifier, contentAlignment: Alignment = Alignment.Center) {
    Box(
        modifier = modifier
            .fillMaxWidth(0.8f)
            .fillMaxHeight(0.1f),
        contentAlignment = contentAlignment
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            fontFamily = FontFamily(listOf(Font(R.font.montserrat_medium))),
            fontWeight = FontWeight.W900,
        )
    }
}
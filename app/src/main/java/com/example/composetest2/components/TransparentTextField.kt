package com.example.composetest2.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.composetest2.R


@Composable
fun TransparentTextField(modifier: Modifier = Modifier) {
    var mutableText by remember {
        mutableStateOf("random nickname")
    }
    Box(
        modifier
            .fillMaxWidth(0.9f)
            .fillMaxHeight(0.2f)
    ) {
        TextField(
            value = mutableText, onValueChange = { mutableText = it },
            Modifier.align(Alignment.Center),
            textStyle = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                fontFamily = FontFamily(listOf(Font(R.font.montserrat_medium))),
                fontWeight = FontWeight.W900,
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            singleLine = true,
        )
    }
}
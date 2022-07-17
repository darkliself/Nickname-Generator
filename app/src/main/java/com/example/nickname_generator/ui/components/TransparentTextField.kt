package com.example.nickname_generator.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
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
import com.example.nickname_generator.R

@Composable
fun TransparentTextField(
    modifier: Modifier = Modifier,
    text: String = "random nickname",
    backgroundColor: Color = Color.Transparent,
    textFieldModifier: Modifier = Modifier,
    onValueChange: (String) -> Unit = {},
    readOnly: Boolean = false
) {
    Box(
        modifier
            .fillMaxWidth(0.9f)
            .fillMaxHeight(0.2f)
    ) {
        TextField(
            // text
            value = text, onValueChange = onValueChange,
            modifier = textFieldModifier
                .align(Alignment.Center)
                .fillMaxSize(),
            textStyle = TextStyle(
                textAlign = TextAlign.Center,
                // fontSize = 18.sp,
                fontFamily = FontFamily(listOf(Font(R.font.montserrat_medium))),
                fontWeight = FontWeight.W900,
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = backgroundColor,
                focusedIndicatorColor = backgroundColor,
                unfocusedIndicatorColor = backgroundColor,
            ),
            singleLine = true,
            readOnly = readOnly,
        )
    }
}
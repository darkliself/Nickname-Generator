package com.example.nickname_generator.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RoundedButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    selected: Boolean
) {
    // val focus = FocusRequester()
    var color by remember { mutableStateOf(Color.White) }
    color = if (!selected) Color.White else Color(0XFFFFD6CC)

    Button(
        onClick = {
            //focus.requestFocus()
            onClick()
        },
        modifier = modifier
            .clip(shape = RoundedCornerShape(30.dp))
            .border(1.dp, Color.Black, shape = RoundedCornerShape(30.dp)),
//            .focusRequester(focus)
//            .onFocusChanged { color = if (it.isFocused) Color(0XFFFFD6CC) else Color.White }
//            .focusable(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = color
        )
    ) {
        Text(text)
    }
}
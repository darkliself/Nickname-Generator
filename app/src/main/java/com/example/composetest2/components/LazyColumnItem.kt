package com.example.composetest2.components


import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LazyColumnItem(text: String, onClick: () -> Unit = {}) {
    var state by remember { mutableStateOf(false)}
    val focus = FocusRequester()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 10.dp)
            .focusRequester(focus)
            .onFocusChanged { state = it.isFocused }
            .focusable(),
            //.clickable { onClick() },
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            modifier = Modifier,
        )
        if (state) {
            Text("dsfdsfsdfdsf")
        }
//        Image(
//            ImageVector.vectorResource(id = R.drawable.icon_pencil),
//            contentDescription = null,
//            modifier = Modifier
//                .padding(end = 20.dp)
//            )
    }
    Divider(
        color = Color(0XFFE7F2D7),
        thickness = 1.dp,
    )
}
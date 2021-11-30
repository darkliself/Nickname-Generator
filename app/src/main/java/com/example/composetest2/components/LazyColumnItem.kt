package com.example.composetest2.components


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetest2.R

@ExperimentalAnimationApi
@Composable
fun LazyColumnItem(text: String, onClick: () -> Unit = {}) {
    var state by remember { mutableStateOf(false) }
    val focus by remember { mutableStateOf(FocusRequester()) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .focusRequester(focus)
            .onFocusChanged { state = it.isFocused }
            .focusable()
            .clickable { focus.requestFocus() },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
        )
        AnimatedVisibility(
            visible = state,
            enter = fadeIn(
                initialAlpha = 0.4f
            ),
            exit = fadeOut(
                animationSpec = tween(durationMillis = 250)
            )
        ) {
            Image(
                ImageVector.vectorResource(id = R.drawable.agree_button),
                contentDescription = null,
                modifier = Modifier
                    .padding( end = 20.dp)
                    .clickable {
                        onClick()
                    }
            )
        }
    }
    Divider(
        color = Color(0XFFE7F2D7),
        thickness = 1.dp,
    )
}
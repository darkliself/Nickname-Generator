package com.example.nickname_generator.ui.components


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Divider
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nickname_generator.R

@ExperimentalAnimationApi
@Composable
fun LazyColumnItem(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {},
    onIconClick: () -> Unit = {},
    onRemoveIconClick: (() -> Unit)? = null,
    selected: Boolean = false
) {
    var isNotDeleted by remember { mutableStateOf(true) }
    var arrangement by remember { mutableStateOf(Arrangement.End) }

    AnimatedVisibility(
        modifier = modifier
            .fillMaxWidth(),
        visible = isNotDeleted,
        enter = fadeIn(
            initialAlpha = 0.4f
        ),
        exit = fadeOut(
            animationSpec = tween(durationMillis = 250)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onClick()
                },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicTextField(
                value = text,
                onValueChange = {},
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 10.dp)
                    .fillMaxWidth(0.7f),
                textStyle = TextStyle(fontSize = 16.sp),
                singleLine = true,
                enabled = false
            )
            AnimatedVisibility(
                modifier = Modifier.padding(end = 20.dp),
                visible = selected,
                enter = fadeIn(
                    initialAlpha = 0.4f
                ),
                exit = fadeOut(
                    animationSpec = tween(durationMillis = 250)
                )
            ) {
                Row(
                    modifier = Modifier
                        .width(90.dp),
                    horizontalArrangement = arrangement
                ) {
                    if (onRemoveIconClick != null) {
                        arrangement = Arrangement.SpaceBetween
                        Image(
                            ImageVector.vectorResource(id = R.drawable.btn_remove),
                            contentDescription = null,
                            modifier = Modifier
                                .size(30.dp)
                                // .padding()
                                .clickable {
                                    onRemoveIconClick()
                                    isNotDeleted = false
                                }
                        )
                    }
                    Image(
                        ImageVector.vectorResource(id = R.drawable.btn_agree),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                            .clickable {
                                onIconClick()
                            }
                    )
                }
            }
        }
        Divider(
            color = Color(0XFFE7F2D7),
            thickness = 1.dp,
        )
    }
}
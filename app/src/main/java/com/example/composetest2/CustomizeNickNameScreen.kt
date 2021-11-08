package com.example.composetest2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetest2.components.Header
import com.example.composetest2.components.SmallButton
import com.example.composetest2.components.TransparentTextField
import com.example.composetest2.components.WideButton



@Composable
fun CustomizeNickNameScreen() {
    Box(
        Modifier.fillMaxSize()
    ) {
        SmallButton(
            modifier = Modifier
                .align(BiasAlignment(0f, -1f))
                .fillMaxHeight(0.1f),
            iconModifier = Modifier
                .align(Alignment.CenterStart),
            image = R.drawable.arrow_left_icon
        )
        Header(
            stringResource(id = R.string.view_02_header),
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.1f)
                .align(BiasAlignment(0f, -1f))
        )
        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.75f)
                .align(BiasAlignment(0f, -0.1f))
                .clip(RoundedCornerShape(60.dp))
                .border(1.dp, Color.Black, shape = RoundedCornerShape(60.dp))
                .background(Color(0xFFE7F2D7))
        ) {
            IconFace(Modifier.align(BiasAlignment(-0.7f, -0.8f)))
            TransparentTextField()
        }
        WideButton(
            image = R.drawable.btn_wide_pink,
            text = stringResource(id = R.string.view_05_btn_ready),
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .fillMaxHeight(0.1f)
                .align(BiasAlignment(0f, 0.95f)),
        )
    }
}


@Preview
@Composable
private fun Preview() {
    CustomizeNickNameScreen()
}

@Composable
private fun IconFace(modifier: Modifier) {
    Image(
        ImageVector.vectorResource(id = R.drawable.view_05_customize_icon),
        null,
        modifier
            .fillMaxWidth(0.3f)
            .fillMaxHeight(0.25f)
    )
}


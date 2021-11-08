package com.example.composetest2

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
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
import com.example.composetest2.components.SmallButton
import com.example.composetest2.components.WideButton
import com.example.composetest2.components.Header
import com.example.composetest2.components.TransparentTextField


@Composable
fun AutogenerateNickname() {
    Box(
        Modifier.fillMaxSize(),
        Alignment.Center
    ) {
        // header components
        SmallButton(
            modifier = Modifier
                .align(BiasAlignment(0f, -1f))
                .fillMaxHeight(0.1f),
            iconModifier = Modifier
                .align(Alignment.CenterEnd)
        )
        Header(
            stringResource(id = R.string.view_04_header),
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.1f)
                .align(BiasAlignment(0f, -1f))
        )
        // surface with all main elements
        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.85f)
                .align(BiasAlignment(0f, 0.6f))
                .clip(RoundedCornerShape(60.dp))
                .border(1.dp, Color.Black, RoundedCornerShape(60.dp))
                .background(Color(0xFFFFEFEB))
        ) {
            ImageBox(Modifier.align(BiasAlignment(0f, -0.7f)))

            TransparentTextField(Modifier.align(BiasAlignment(0f, -0.1f)))

            WideButton(
                R.drawable.btn_wide_pink,
                stringResource(R.string.view_04_btn_try_again),
                Modifier
                    .fillMaxHeight(0.1f)
                    .align(BiasAlignment(0f, 0.2f)),
            )

            WideButton(
                R.drawable.btn_wide_green,
                stringResource(R.string.view_04_btn_customise),
                Modifier
                    .fillMaxHeight(0.1f)
                    .align(BiasAlignment(0f, 0.5f)),
            )
        }
    }
}

@Preview
@Composable
private fun defPreview() {
    AutogenerateNickname()
}

@Composable
private fun ImageBox(modifier: Modifier = Modifier) {
    Box(
        modifier
            .fillMaxWidth(0.5f)
            .fillMaxHeight(0.3f)

    ) {
        Image(
            ImageVector.vectorResource(R.drawable.view_04_autogenerate_icon),
            contentDescription = null,
            Modifier.fillMaxSize()
        )
    }
}



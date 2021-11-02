package com.example.composetest2

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetest2.components.WideButton
import com.example.composetest2.ui.theme.MenuButton
import com.example.composetest2.ui.theme.TextBox


@Composable
fun AutogenerateNickname() {
    Box(
        Modifier.fillMaxSize(),
        Alignment.Center
    ) {

        Header(
            Modifier.align(BiasAlignment(0f, -1f))
        )
        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.85f)
                .align(BiasAlignment(0f, 0.6f))
        ) {
            Surface(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize(),
                border = BorderStroke(1.dp, Color.Black),
                //contentColor = Color.Blue,
                elevation = 8.dp,
                shape = RoundedCornerShape(60.dp),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFFFEFEB))
                ) {
                    WideButton(Modifier.align(BiasAlignment(0f, 0.2f)))
                    WideButton(Modifier.align(BiasAlignment(0f, 0.5f)))
                }
            }
        }
    }
}


@Preview
@Composable
private fun defPreview() {
    AutogenerateNickname()
}


@Composable
private fun Header(modifier: Modifier = Modifier) {
    Box(
        modifier
            .fillMaxWidth(0.9f)
            .fillMaxHeight(0.1f),
    ) {
        MenuButton(
            modifier = Modifier.fillMaxSize(),
            iconModifier = Modifier.align(BiasAlignment(1f, 0f))
        )
        TextBox(
            text = "Autogenerate nickname",
            modifier = Modifier.align(BiasAlignment(0f, 0f))
        )
    }
}



package com.example.composetest2

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAbsoluteAlignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetest2.components.Header
import com.example.composetest2.components.SmallButton
import com.example.composetest2.components.TransparentTextField
import com.example.composetest2.components.WideButton
import com.example.composetest2.ui.theme.Styles
import com.example.composetest2.ui.theme.TextFieldStyleColors


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
        ) {
            Surface(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize(),
                border = BorderStroke(1.dp, Color.Black),
                //elevation = 8.dp,
                shape = RoundedCornerShape(60.dp),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFE7F2D7))
                ) {
                    IconFace(Modifier.align(BiasAlignment(-0.7f, -0.8f)))

                    TransparentTextField()
                }
            }
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
private fun preview() {
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


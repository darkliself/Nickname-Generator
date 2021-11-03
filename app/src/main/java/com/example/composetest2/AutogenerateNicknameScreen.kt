package com.example.composetest2

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
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
import com.example.composetest2.components.SmallButton
import com.example.composetest2.components.WideButton
import com.example.composetest2.components.Header


@Composable
fun AutogenerateNickname() {
    Box(
        Modifier.fillMaxSize(),
        Alignment.Center
    ) {
        // header components
        SmallButton(modifier = Modifier
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
                    ImageBox(Modifier.align(BiasAlignment(0f, -0.7f)))

                    RandomNicknameTextField(Modifier.align(BiasAlignment(0f, -0.1f)))

                    WideButton(
                        Modifier.align(BiasAlignment(0f, 0.2f)),
                        R.drawable.view_02_btn_create,
                        stringResource(R.string.view_04_btn_try_again)
                    )

                    WideButton(
                        Modifier.align(BiasAlignment(0f, 0.5f)),
                        R.drawable.view_02_btn_create,
                        stringResource(R.string.view_04_btn_customise)
                    )
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

@Composable
private fun RandomNicknameTextField(modifier: Modifier = Modifier) {
    var randomName by remember {
        mutableStateOf("random nickname")
    }
    Box(
        modifier
            .fillMaxWidth(0.9f)
            .fillMaxHeight(0.2f)
    ) {
        TextField(
            value = randomName, onValueChange = { randomName = it },
            Modifier.align(Alignment.Center),
            textStyle = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                fontFamily = FontFamily(listOf(Font(R.font.montserrat_medium))),
                fontWeight = FontWeight.W900,
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color(0xFFFFEFEB),
                focusedIndicatorColor = Color(0xFFFFEFEB),
                unfocusedIndicatorColor = Color(0xFFFFEFEB)
            ),
            singleLine = true
        )
    }
}


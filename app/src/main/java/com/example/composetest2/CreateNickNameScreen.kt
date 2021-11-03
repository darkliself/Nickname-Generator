package com.example.composetest2

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
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
import com.example.composetest2.components.WideButton


@Composable
fun CreateNickNameView() {
    var nickname by remember { mutableStateOf("") }
    Box(
        Modifier.fillMaxSize()
    ) {
        SmallButton(modifier = Modifier
            .align(BiasAlignment(0f, -1f))
            .fillMaxHeight(0.1f),
            iconModifier = Modifier
                .align(Alignment.CenterEnd)
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
                .fillMaxHeight(0.85f)
                .align(BiasAlignment(0f, 0.6f))
        ) {
            Surface(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize(),
                border = BorderStroke(1.dp, Color.Black),
                elevation = 8.dp,
                shape = RoundedCornerShape(60.dp),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFE7F2D7))
                ) {
                    NicknameTextField(
                        Modifier.align(BiasAlignment(0f, -0.2f)),
                        nickname = nickname
                    )
                    WideButton(
                        Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.2f)
                            .align(BiasAlignment(0f, 0.25f)),
                        R.drawable.view_02_btn_create,
                        stringResource(id = R.string.view_02_btn_create)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview3() {
    CreateNickNameView()
}

@Composable
private fun NicknameTextField(modifier: Modifier = Modifier, nickname: String = "") {
    var mutableNickname by remember { mutableStateOf(nickname) }
    Surface(
        modifier
            .fillMaxWidth(0.9f)
            .fillMaxHeight(0.15f),
        border = BorderStroke(1.dp, Color.Black),
        shape = RoundedCornerShape(30.dp),
    ) {
        Box(
            Modifier.fillMaxSize()
        ) {
            TextField(
                value = mutableNickname,
                onValueChange = {
                    mutableNickname = it
                },
                Modifier
                    .align(Alignment.Center)
                    .border(0.dp, Color.White)
                    .background(Color.White),
                textStyle = TextStyle(
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp,
                    fontFamily = FontFamily(listOf(Font(R.font.montserrat_medium))),
                    fontWeight = FontWeight.W900,
                ),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color.White,
                    unfocusedIndicatorColor = Color.White
                ),
                placeholder = {
                    Text(
                        stringResource(R.string.view_02_nickname_placeholder),
                        Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center), textAlign = TextAlign.Center
                    )
                },
                singleLine = true
            )
        }
    }
}



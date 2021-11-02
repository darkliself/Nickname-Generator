package com.example.composetest2


import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
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
import com.example.composetest2.components.WideButton
import com.example.composetest2.ui.theme.MenuButton
import com.example.composetest2.ui.theme.TextBox

@Composable
fun CreateNickNameView() {
    var nickname by remember { mutableStateOf("") }
    Box(
        Modifier.fillMaxSize()
    ) {
        Header()
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
                        .background(Color(0xFFE7F2D7))
                ) {
                    NicknameTextField(
                        Modifier.align(BiasAlignment(0f, -0.2f)),
                        nickname
                    )
                    WideButton(Modifier.align(BiasAlignment(0f, 0.2f)),
                        R.drawable.view_02_btn_create, "fsfds")
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
private fun Header() {
    Box(
        Modifier
            .fillMaxHeight(0.1f)
            .fillMaxWidth()
    ) {
        MenuButton(modifier = Modifier
            .align(BiasAlignment(0f, 0f))
            .fillMaxHeight()
            .fillMaxWidth(0.9f),
            iconModifier = Modifier
                .align(Alignment.CenterEnd)
                .clickable {
                    Log.i(">>>>>>>>>>>>>>>>>", "its here")
                }
        )
        TextBox(
            "Create custom nickname",
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight()
                .align(BiasAlignment(0f, 0f))
        )
    }
}

@Composable
private fun NicknameTextField(modifier: Modifier = Modifier, nickname: String = "") {
    var mutableNickname by remember { mutableStateOf(nickname) }
    Surface(
        modifier
            .fillMaxWidth(0.9f)
            .fillMaxHeight(0.15f),
        // .align(+BiasAlignment(0f, -0.2f)),
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
                placeholder = { Text(stringResource(R.string.view_02_nickname_placeholder),
                    Modifier
                        .fillMaxWidth()
                        .align(Alignment.Center), textAlign = TextAlign.Center) },
                singleLine = true
            )
        }
    }
}

@Composable
private fun CreateButton(modifier: Modifier = Modifier) {
    Box(
        modifier
            .fillMaxWidth(0.9f)
            .fillMaxHeight(0.15f)
        //.align(BiasAlignment(0f, 0.2f))
    ) {
        Image(
            ImageVector.vectorResource(id = R.drawable.view_02_btn_create),
            null,
            Modifier
                .fillMaxSize()
                .wrapContentSize()
                .clickable {
                    println("clicked on create")
                }
        )
        Text(
            stringResource(id = R.string.view_02_btn_create), Modifier.align(Alignment.Center),
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontFamily = FontFamily(listOf(Font(R.font.montserrat_medium))),
            fontWeight = FontWeight.W900,
        )
    }
}


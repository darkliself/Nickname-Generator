package com.example.composetest2.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composetest2.R
import com.example.composetest2.Screen
import com.example.composetest2.ScreenData
import com.example.composetest2.components.Header
import com.example.composetest2.components.SmallButton
import com.example.composetest2.components.WideButton

/*
    View 02
*/

@ExperimentalComposeUiApi
@Composable
fun CreateNickNameScreen(navController: NavController) {
    val initText = stringResource(id = R.string.view_02_nickname_placeholder)
    var nickname by remember { mutableStateOf("") }
    var placeHolder by remember { mutableStateOf(initText) }
    val keyboardController = LocalSoftwareKeyboardController.current

    Box(
        Modifier.fillMaxSize()
    ) {
        SmallButton(
            modifier = Modifier
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
                .clip(RoundedCornerShape(60.dp))
                .border(BorderStroke(1.dp, Color.Black), RoundedCornerShape(60.dp))
                .background(Color(0xFFE7F2D7)),
        ) {
            NicknameTextField(
                Modifier.align(BiasAlignment(0f, -0.2f)),
                // here must be used nav params
                value = nickname,
                onValueChange = {
                    nickname = it
                },
                placeholder = placeHolder,
                keyboardActions = KeyboardActions(onDone = {
                    if (nickname != "") {
                        keyboardController?.hide()
                        val data = ScreenData(root = nickname, rootNode = Screen.CreateNickNameScreen.route)
                        navController.currentBackStackEntry?.savedStateHandle?.set("data", data)
                        navController.navigate(Screen.CustomizeNickNameScreen.route)
                    } else {
                        placeHolder = "needed value"
                    }
                }),
                keyboardOptions = KeyboardOptions()
            )
            WideButton(
                R.drawable.btn_wide_green,
                stringResource(id = R.string.view_02_btn_create),
                Modifier
                    .fillMaxHeight(0.1f)
                    .align(BiasAlignment(0f, 0.25f)),
                onClick = {
                    if (nickname != "") {
                        val data = ScreenData(
                            root = nickname,
                            rootNode = Screen.CreateNickNameScreen.route
                        )
                        navController.currentBackStackEntry?.savedStateHandle?.set("data", data)
                        navController.navigate(Screen.CustomizeNickNameScreen.route)
                    } else {
                        placeHolder = "needed value"
                    }
                }
            )
        }
    }
}

@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
private fun DefaultPreview3() {
    CreateNickNameScreen(NavController(LocalContext.current))
}

@ExperimentalComposeUiApi
@Composable
private fun NicknameTextField(
    modifier: Modifier = Modifier,
    value: String = "",
    onValueChange: (String) -> Unit,
    placeholder: String,
    keyboardActions: KeyboardActions,
    keyboardOptions: KeyboardOptions
) {
    Surface(
        modifier = modifier
            .fillMaxWidth(0.9f)
            .fillMaxHeight(0.15f),
        border = BorderStroke(1.dp, Color.Black),
        shape = RoundedCornerShape(30.dp),
    ) {
        Box(
            Modifier.fillMaxSize()
        ) {
            TextField(
                value = value,
                onValueChange = onValueChange,
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
                        text = placeholder,
                        // stringResource(R.string.view_02_nickname_placeholder),
                        Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center), textAlign = TextAlign.Center
                    )
                },
                singleLine = true,
                keyboardActions = keyboardActions,
                keyboardOptions = keyboardOptions,
            )
        }
    }
}



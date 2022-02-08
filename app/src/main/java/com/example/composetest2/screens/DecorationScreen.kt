package com.example.composetest2


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composetest2.components.*
import com.example.composetest2.logic.DecorationLeft
import com.example.composetest2.logic.DecorationRight
import com.example.composetest2.logic.DecorationSide

/*
    View 07
 */


@ExperimentalFoundationApi
@Composable
fun DecorationScreen(navController: NavController, data: ScreenData) {
    val data = data
    // just testing here
    var nicknameRoot by remember { mutableStateOf(data.root) }
    var prefix by remember { mutableStateOf(data.prefix) }
    var suffix by remember { mutableStateOf(data.suffix) }
    var decoration by remember { mutableStateOf("") }
    var textArea by remember { mutableStateOf("$prefix$nicknameRoot$suffix") }

    Background(image = R.drawable.view_06_07_bg)

    Box(
        Modifier.fillMaxSize(),
    ) {
        SmallButton(
            modifier = Modifier
                .align(BiasAlignment(0f, -1f))
                .fillMaxHeight(0.1f),
            iconModifier = Modifier
                .align(Alignment.CenterStart),
            image = R.drawable.arrow_left_icon,

            onClick = {
                data.root = nicknameRoot
                data.prefix = prefix
                data.suffix = suffix
                navController.currentBackStackEntry?.savedStateHandle?.set("data", data)
                navController.navigate(Screen.CustomizeNickNameScreen.route)
            }
        )
        Header(
            "Select ${data.side.toString().lowercase()} decoration",
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.1f)
                .align(BiasAlignment(0f, -1f))
        )
        TransparentTextField(
            text = "$prefix$nicknameRoot$suffix",
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.1f)
                .clip(RoundedCornerShape(30.dp))
                .border(1.dp, Color(0XFFE7F2D7), RoundedCornerShape(30.dp))
                .align(BiasAlignment(0f, -0.8f)),
            backgroundColor = Color.White,

//            onValueChange = { it ->
//                textArea = it
//            }
        )
        // Filter buttons
        Row(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.07f)
                .align(BiasAlignment(0f, -0.55f))
        ) {
            Spacer(modifier = Modifier.fillMaxWidth(0.05f))

            RoundedButton("ALL", onClick = { println("ALL") })

            Spacer(modifier = Modifier.fillMaxWidth(0.05f))

            RoundedButton("NEW", onClick = { println("NEW") })

            Spacer(modifier = Modifier.fillMaxWidth(0.05f))

            RoundedButton("POPULAR", onClick = { println("POPULAR") })
        }
        LazyVerticalGrid(
            cells = GridCells.Fixed(4),
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f)
                .align(BiasAlignment(0f, 1f))
        ) {
            val decoration =
                if (data.side == DecorationSide.LEFT) DecorationLeft else DecorationRight
            items(decoration.count()) { index ->
                var state by remember { mutableStateOf(false) }
                val focus by remember { mutableStateOf(FocusRequester()) }
                Card(
                    Modifier
                        .padding(bottom = 10.dp)
                        .height(35.dp)
                        .focusRequester(focus)
                        .onFocusChanged { state = it.isFocused }
                        .focusable()
                        .clickable {
                            textArea = if (data.side == DecorationSide.LEFT) {
                                prefix = decoration[index]
                                "${decoration[index]}$nicknameRoot$suffix"
                            } else {
                                suffix = decoration[index]
                                "$prefix$nicknameRoot${decoration[index]}"
                            }
                        }
                ) {
                    Text(decoration[index], textAlign = TextAlign.Center)
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
private fun Preview() {
    DecorationScreen(NavController(LocalContext.current), ScreenData("Some", "", alphabetIndex = 0))
}


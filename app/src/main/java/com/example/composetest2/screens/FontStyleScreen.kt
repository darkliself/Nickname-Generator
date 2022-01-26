package com.example.composetest2

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composetest2.components.*
import com.example.composetest2.logic.TextStyler

/*
    View 08
 */

@RequiresApi(Build.VERSION_CODES.N)
@ExperimentalAnimationApi
@Composable
fun FontStyleScreen(navController: NavController, data: ScreenData) {
    var data = data
    val textStyler = TextStyler()
    // val nickname by remember { mutableStateOf(data.nickname) }
    val nickname = data.nickname
    val alphabetIndex = data.alphabetIndex

    if (nickname != "") {
        println(nickname)
    } else {
        println("textStyler")
    }

    Background(image = R.drawable.view_03_08_bg)
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
                data.nickname = nickname
                data.alphabetIndex = alphabetIndex
                navController.currentBackStackEntry?.savedStateHandle?.set("data", data)
                navController.navigate(Screen.CustomizeNickNameScreen.route)
            }
        )
        Header(
            stringResource(id = R.string.view_08_btn_header),
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.1f)
                .align(BiasAlignment(0f, -1f))
        )
        // Filter buttons
        Row(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.07f)
                .align(BiasAlignment(0f, -0.8f))
        ) {
            Spacer(modifier = Modifier.fillMaxWidth(0.05f))

            RoundedButton("ALL", onClick = { println("ALL") })

            Spacer(modifier = Modifier.fillMaxWidth(0.05f))

            RoundedButton("NEW", onClick = { println("NEW") })

            Spacer(modifier = Modifier.fillMaxWidth(0.05f))

            RoundedButton("POPULAR", onClick = { println("POPULAR") })
        }
        LazyColumn(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
                .padding(start = 20.dp)
                .align(BiasAlignment(-0.8f, 0.7f)),
            //horizontalAlignment = BiasAlignment.Horizontal(0f)
        ) {
            var baseNickname = ""

            // in case if chars not in standard code
            textStyler.splitByCodePoint(nickname).forEach { elem ->
                baseNickname += if (textStyler.getCharIndex(elem, alphabetIndex) != -1) {
                    textStyler.getBaseChar(textStyler.getCharIndex(elem, alphabetIndex))
                } else {
                    elem
                }
            }

            items(textStyler.getAlphabetCount()) { index ->
                val nick = textStyler.rootToUnicode(baseNickname, index)
                LazyColumnItem(nick, onClick = {
                    data.nickname = nick
                    data.alphabetIndex = index
                    navController.currentBackStackEntry?.savedStateHandle?.set("data", data)
                    navController.navigate(Screen.CustomizeNickNameScreen.route)
                })
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.N)
@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
private fun Preview() {
    FontStyleScreen(NavController(LocalContext.current), ScreenData("name", "root", 0))
}
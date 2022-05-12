package com.example.composetest2


import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.*
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
import androidx.compose.ui.focus.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composetest2.components.*
import com.example.composetest2.util.DecorationLeft
import com.example.composetest2.util.DecorationRight
import com.example.composetest2.util.DecorationSide
import com.example.composetest2.util.TextStyler
import com.example.composetest2.model.screendata.ScreenData
import com.example.composetest2.navigation.Screen

/*
    View 07
 */


@ExperimentalFoundationApi
@Composable
fun DecorationScreen(navController: NavController, data: ScreenData) {
    val nicknameRoot by remember {
        mutableStateOf(
            TextStyler.rebuildToString(
                data.rootAsCodeList,
                data.alphabetIndex
            )
        )
    }
    var prefix by remember { mutableStateOf(data.prefix) }
    var suffix by remember { mutableStateOf(data.suffix) }
    var textArea by remember { mutableStateOf("$prefix$nicknameRoot$suffix") }
    val decoration = if (data.side == DecorationSide.LEFT) DecorationLeft else DecorationRight
    val isItemSelected by remember { mutableStateOf(mutableListOf<Color>()) }
    repeat(decoration.count()) {
        isItemSelected.add(Color.White)
    }

    BackHandler() {
        navController.currentBackStackEntry?.savedStateHandle?.set("data", data)
        navController.navigate(Screen.CustomizeNickNameScreen.route)
    }

    Background(image = R.drawable.view_06_07_bg)

    Box(
        Modifier.fillMaxSize(),
    ) {
        SmallButton(
            modifier = Modifier
                .align(Alignment.TopStart),
            image = R.drawable.arrow_left_icon,
            onClick = {
                navController.currentBackStackEntry?.savedStateHandle?.set("data", data)
                navController.navigate(Screen.CustomizeNickNameScreen.route)
            }
        )
        Header(
            text = "Select ${data.side.toString().lowercase()} decoration",
            modifier = Modifier.align(Alignment.TopCenter)
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
            readOnly = true
        )
        // Filter buttons
        Row(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.07f)
                .align(BiasAlignment(0f, -0.55f))
        ) {
            Spacer(modifier = Modifier.width(10.dp))
            RoundedButton("ALL", onClick = { println("ALL") })
            Spacer(modifier = Modifier.width(10.dp))
            RoundedButton("NEW", onClick = { println("NEW") })
            Spacer(modifier = Modifier.width(10.dp))
            RoundedButton("POPULAR", onClick = { println("POPULAR") })
        }
        LazyVerticalGrid(
            cells = GridCells.Fixed(4),
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f)
                .align(BiasAlignment(0f, 1f))
        ) {
            items(decoration.count()) { index ->
                DecorationScreenItem(
                    text = decoration[index],
                    onClick = {
                        textArea = if (data.side == DecorationSide.LEFT) {
                            prefix = decoration[index]
                            "${decoration[index]}$nicknameRoot$suffix"
                        } else {
                            suffix = decoration[index]
                            "$prefix$nicknameRoot${decoration[index]}"
                        }
                        // write data
                        data.root = nicknameRoot
                        data.prefix = prefix
                        data.suffix = suffix
                        // highlight item
                        val iterator = isItemSelected.listIterator()
                        while (iterator.hasNext()) {
                            if (iterator.next() == Color.Green) {
                                iterator.set(Color.White)
                            }
                        }
                        isItemSelected[index] = Color.Green
                    },
                    colored = isItemSelected[index]
                )
            }
        }
    }
}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
private fun Preview() {
    DecorationScreen(
        NavController(LocalContext.current),
        ScreenData("Some", rootNode = "", alphabetIndex = 0)
    )
}

@Composable
fun DecorationScreenItem(
    onClick: () -> Unit,
    text: String,
    colored: Color
) {
    Card(
        backgroundColor = colored,
        modifier = Modifier
            .padding(bottom = 10.dp)
            .height(35.dp)
            .clickable {
                onClick()
            },
    ) {
        Text(text, textAlign = TextAlign.Center)
    }
}

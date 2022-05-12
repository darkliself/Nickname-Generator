package com.example.composetest2

import android.annotation.SuppressLint
import android.os.Build
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composetest2.components.*
import com.example.composetest2.util.TextStyler
import com.example.composetest2.model.screendata.ScreenData
import com.example.composetest2.navigation.Screen

/*
    View 08
 */

@SuppressLint("UnrememberedMutableState")
@RequiresApi(Build.VERSION_CODES.N)
@ExperimentalAnimationApi
@Composable
fun FontStyleScreen(navController: NavController, data: ScreenData) {
    val alphabetIndex = data.alphabetIndex
    val nickname = TextStyler.rebuildToString(data.rootAsCodeList, alphabetIndex)
    val isItemSelected = mutableStateListOf<Boolean>()
    repeat(TextStyler.getAlphabetCount()) {
        isItemSelected.add(false)
    }
    BackHandler() {
        navController.currentBackStackEntry?.savedStateHandle?.set("data", data)
        navController.navigate(Screen.CustomizeNickNameScreen.route)
    }

    Background(image = R.drawable.view_03_08_bg)

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
            stringResource(id = R.string.view_08_btn_header),
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.1f)
                .align(BiasAlignment(0f, -1f))
        )
        //Add here
        TransparentTextField(
            text = "${data.prefix}${nickname}${data.suffix}",
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
                .align(BiasAlignment(0f, -0.6f))
        ) {
            Spacer(modifier = Modifier.width(10.dp))
            RoundedButton("ALL", onClick = { println("ALL") })
            Spacer(modifier = Modifier.width(10.dp))
            RoundedButton("NEW", onClick = { println("NEW") })
            Spacer(modifier = Modifier.width(10.dp))
            RoundedButton("POPULAR", onClick = { println("POPULAR") })
        }
        LazyColumn(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
                .padding(start = 20.dp)
                .align(BiasAlignment(-0.8f, 1.6f)),
            //horizontalAlignment = BiasAlignment.Horizontal(0f)
        ) {
            items(TextStyler.getAlphabetCount()) { index ->
                val nick = TextStyler.rebuildToString(data.rootAsCodeList, index)
                LazyColumnItem2(
                    text = nick,
                    onClick = {
                        val iterator = isItemSelected.listIterator()
                        while (iterator.hasNext()) {
                            if (iterator.next()) {
                                iterator.set(false)
                            }
                        }
                        isItemSelected[index] = true
                        data.alphabetIndex = index
                        navController.currentBackStackEntry?.savedStateHandle?.set("data", data)
                    },
                    onIconClick = {
                        navController.navigate(Screen.CustomizeNickNameScreen.route)
                    },
                    selected = isItemSelected[index]
                )
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.N)
@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
private fun Preview() {
    FontStyleScreen(
        NavController(LocalContext.current),
        ScreenData("name", rootNode = "root", alphabetIndex = 0)
    )
}
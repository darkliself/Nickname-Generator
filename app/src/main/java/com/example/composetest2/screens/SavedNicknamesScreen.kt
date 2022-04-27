package com.example.composetest2.screens

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composetest2.R
import com.example.composetest2.Screen
import com.example.composetest2.components.*
import com.example.composetest2.viewmodel.NicknameViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@OptIn(ExperimentalAnimationApi::class)
@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SavedNicknamesScreen(navController: NavController) {
    val repo = NicknameViewModel(LocalContext.current)

    val scope = rememberCoroutineScope()

    var result by remember { mutableStateOf(mutableMapOf<String, String>()) }
    scope.launch {
        if (repo.isNotEmpty()) {
            result = repo.readAll().toMutableMap()
        } else {

        }
    }

    Background(image = R.drawable.view_03_08_bg)


    Column {
        Box(
            Modifier
                .fillMaxWidth()
                .height(60.dp)
        ) {
            SmallButton(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.1f),
                //  .border(2.dp, Color.Black),
                iconModifier = Modifier.align(Alignment.Center),
                image = R.drawable.arrow_left_icon,
                onClick = {

                }
            )
            Header(
                "Saved",// stringResource(id = R.string.view_08_btn_header),
                modifier = Modifier
                    .fillMaxSize()
            )
        }
        Button(
            onClick = {

                scope.launch {
                    repeat(20) {
                        repo.saveNickname("fhgjdhgjdfhggfdjgfdsf$it")

                    }
                    result = repo.readAll().toMutableMap()
                }
            }
        ) {
            Text("add items")
        }
        Button(
            onClick = {
                scope.launch {
                    repo.clearRepo()
                    result = mutableMapOf()
                }
            }
        ) {
            Text("Dell all")
        }


        if (result.any()) {
            LazyColumn(
                Modifier.fillMaxSize(),
            ) {
                item(
                ) {
//                    Button() {
//
//                    }
                }
                result.forEach { (key, value) ->
                    item() {
                        LazyColumnItem(
                            modifier = Modifier.padding(start = 20.dp),
                            text = value,
                            onClick = {
                                // navController.currentBackStackEntry?.savedStateHandle?.set("data", data)
                                navController.navigate(Screen.CustomizeNickNameScreen.route)
                            },
                            removeOnClick = {
                                scope.launch {
                                    result.remove(key)
                                    repo.delete(key)
                                    if (!repo.isNotEmpty()) {
                                        navController.navigate(Screen.SavedNicknamesScreen.route)
                                    }
                                }
                            }
                        )
                    }
                }
            }

        } else {
            var mutable by remember { mutableStateOf(false)}
            scope.launch {
                delay(200)
                mutable = true
            }
           if (mutable) {
               Text("Your storage is empty")
           } else {
               CircularProgressIndicator(
                   modifier = Modifier.fillMaxSize()
               )
           }
        }
    }
}


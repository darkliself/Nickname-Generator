package com.example.textstyler.ui.screens

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.textstyler.R
import com.example.textstyler.navigation.Screen
import com.example.textstyler.util.TextStyler
import com.example.textstyler.model.nickname.NicknameData
import com.example.textstyler.model.screendata.ScreenData
import com.example.textstyler.ui.components.Background
import com.example.textstyler.ui.components.Header
import com.example.textstyler.ui.components.LazyColumnItem
import com.example.textstyler.ui.components.SmallButton
import com.example.textstyler.viewmodel.NicknameViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalAnimationApi::class)
@SuppressLint("CoroutineCreationDuringComposition", "UnrememberedMutableState")
@Composable
fun SavedNicknamesScreen(navController: NavController) {
    val repo = NicknameViewModel(LocalContext.current)
    val scope = rememberCoroutineScope()
    var result by remember { mutableStateOf(mutableMapOf<String, NicknameData>()) }
    scope.launch {
        if (repo.readFromProto().isNotEmpty()) result = repo.readFromProto().toMutableMap()
    }

    Background(image = R.drawable.view_03_08_bg)
    Box(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.1f),
    ) {
        SmallButton(
            modifier = Modifier.fillMaxHeight(),
            image = R.drawable.arrow_left_icon,
            onClick = {
                navController.popBackStack()
            }
        )
        Header(
            "History",// stringResource(id = R.string.view_08_btn_header),
            modifier = Modifier.align(Alignment.TopCenter).fillMaxHeight()
        )
    }
    Column(
        Modifier.fillMaxWidth()
    ) {
        Spacer(Modifier.fillMaxHeight(0.1f))

        if (result.any()) {
            LazyColumn(
                Modifier.fillMaxSize(),
            ) {
                // var index = 0
                result.forEach { (key, value) ->
                    item() {
                        LazyColumnItem(
                            modifier = Modifier.padding(start = 20.dp),
                            text = "${value.prefix}${
                                TextStyler.rebuildToString(
                                    value.rootAsCodeList,
                                    value.alphabetIndex
                                )
                            }${value.suffix}",
                            onIconClick = {
                                navController.currentBackStackEntry?.savedStateHandle?.set(
                                    "data",
                                    ScreenData(
                                        prefix = value.prefix,
                                        suffix = value.suffix,
                                        rootAsCodeList = value.rootAsCodeList,
                                        alphabetIndex = value.alphabetIndex,
                                        rootNode = Screen.SavedNicknamesScreen.route
                                    )
                                )
                                navController.navigate(Screen.CustomizeNickNameScreen.route)
                            },
                            onRemoveIconClick = {
                                scope.launch {
                                    result.remove(key)
                                    repo.removeFromProto(key)
                                }
                            },
                            selected = true
                        )
                    }
                }
            }
        } else {
            var mutable by remember { mutableStateOf(false) }
            scope.launch {
                delay(200)
                mutable = true
            }
            if (mutable) {
                Text(
                    "Your storage is empty",
                    Modifier.align(CenterHorizontally)
                )
            } else {
                Box(Modifier.fillMaxSize()) {
                    CircularProgressIndicator(
                        modifier = Modifier.fillMaxSize().align(Alignment.Center)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    SavedNicknamesScreen(navController = NavController(LocalContext.current))
}


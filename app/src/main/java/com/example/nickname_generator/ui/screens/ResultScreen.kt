package com.example.nickname_generator.ui.screens

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context.CLIPBOARD_SERVICE
import android.content.Intent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.nickname_generator.BuildConfig
import com.example.nickname_generator.R
import com.example.nickname_generator.model.nickname.NicknameData
import com.example.nickname_generator.model.screendata.ScreenData
import com.example.nickname_generator.navigation.Screen
import com.example.nickname_generator.ui.components.*
import com.example.nickname_generator.viewmodel.NicknameViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

/**
view 09
 */

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun ResultScreen(navController: NavController, data: ScreenData) {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val repository = NicknameViewModel(context)
    val snackbarHostState = remember { SnackbarHostState() }

    Box(
        Modifier.fillMaxSize(),
        Alignment.Center
    ) {
        SmallButton(
            modifier = Modifier
                .align(Alignment.TopStart),
            image = R.drawable.arrow_left_icon,
            onClick = {
                navController.currentBackStackEntry?.savedStateHandle?.set("data", data)
                navController
                    .navigate(Screen.CustomizeNickNameScreen.route)
            }
        )
        Header(
            stringResource(id = R.string.view_09_header),
            modifier = Modifier.align(Alignment.TopCenter)
        )
        // storage
        SmallButton(
            modifier = Modifier
                .align(Alignment.TopEnd),
            iconModifier = Modifier
                .align(Alignment.Center),
            onClick = {
                navController.navigate(Screen.SavedNicknamesScreen.route)
            }
        )
        // surface with all main elements
        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.85f)
                .align(BiasAlignment(0f, 0.6f))
                .clip(RoundedCornerShape(60.dp))
                .border(1.dp, Color.Black, RoundedCornerShape(60.dp))
                .background(Color(0xFFFFEFEB)),

            ) {
            Box(modifier = Modifier
                .wrapContentSize()
                .align(BiasAlignment(0f, -0.7f))) {
                ProfileUI(nickname = data.nickname)
            }

//            LottiAvatar(
//                modifier = Modifier
//                    .align(BiasAlignment(0f, -0.7f))
//                    .fillMaxWidth(0.5f)
//                    .fillMaxHeight(0.3f),
//                nickname = data.nickname,
//                icon = R.drawable.view_04_autogenerate_icon,
//                onClick = {
//                }
//            )
            Text(
                text = data.nickname,
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .align(BiasAlignment(0f, -0.1f))
                    .verticalScroll(rememberScrollState(data.nickname.length / 2)),
                maxLines = 1,
                textAlign = TextAlign.Center
            )
            // save button
            WideButton(
                R.drawable.btn_wide_pink,
                stringResource(R.string.view_09_btn_save),
                Modifier
                    .fillMaxHeight(0.15f)
                    .align(BiasAlignment(0f, 0.2f)),
                onClick = {
                    scope.launch {
                        if (data.nickname != "") {
                            repository.saveToProto(
                                NicknameData(
                                    prefix = data.prefix,
                                    suffix = data.suffix,
                                    rootAsCodeList = data.rootAsCodeList,
                                    alphabetIndex = data.alphabetIndex
                                )
                            )
                            scope.launch {
                                snackbarHostState.showSnackbar("")
                            }
                        }
                    }
                }
            )
            WideButton(
                R.drawable.btn_wide_green,
                stringResource(R.string.view_09_btn_try_again),
                Modifier
                    .fillMaxHeight(0.15f)
                    .align(BiasAlignment(0f, 0.5f)),
                onClick = { navController.navigate(Screen.MainScreen.route) }
            )
            Row(
                Modifier
                    .fillMaxHeight(0.1f)
                    .fillMaxWidth(0.9f)
                    .align(BiasAlignment(0f, 0.85f))
            ) {
                WideButton(
                    R.drawable.view_07_btn_copy,
                    stringResource(R.string.view_09_btn_copy),
                    Modifier
                        .fillMaxWidth(0.5f)
                        .fillMaxHeight(),
                    onClick = {
                        val clipboard =
                            context.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
                        val clip = ClipData.newPlainText(null, data.nickname)
                        clipboard.setPrimaryClip(clip)
                    }
                )
                WideButton(
                    R.drawable.view_07_btn_share,
                    stringResource(R.string.view_09_btn_share),
                    Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    onClick = {
                        val sendIntent: Intent = Intent().apply {
                            action = Intent.ACTION_SEND
                            putExtra(
                                Intent.EXTRA_TEXT,
                                "Hey! Check this cool nickname - ${data.nickname} \n" +
                                        "That I've generated in this Nickname Generator App - https://play.google.com/store/apps/details?id=${BuildConfig.APPLICATION_ID}"
                            )
                            type = "text/plain"
                        }
                        val shareIntent = Intent.createChooser(
                            sendIntent,
                            context.getString(R.string.view_09_btn_share)
                        )
                        context.startActivity(shareIntent)
                    }
                )
            }
            SnackbarHost(
                hostState = snackbarHostState,
                Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth(0.75f)
                    .fillMaxHeight(0.07f),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(15.dp))
                        .background(Color.DarkGray),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        stringResource(id = R.string.view_09_snack_bar_txt),
                        fontSize = 18.sp,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    ResultScreen(
        NavController(LocalContext.current),
        ScreenData("Nick", rootNode = "Root", alphabetIndex = 0)
    )
}

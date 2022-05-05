package com.example.composetest2

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context.CLIPBOARD_SERVICE
import android.content.Intent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composetest2.components.Header
import com.example.composetest2.components.SmallButton
import com.example.composetest2.components.WideButton
import com.example.composetest2.model.nickname.NicknameData
import com.example.composetest2.model.screendata.ScreenData
import com.example.composetest2.navigation.Screen
import com.example.composetest2.viewmodel.NicknameViewModel
import kotlinx.coroutines.launch


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun ResultScreen(navController: NavController, data: ScreenData) {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val repository = NicknameViewModel(context)

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
            stringResource(id = R.string.view_07_header),
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
                .background(Color(0xFFFFEFEB))
        ) {
            ImageBox(Modifier.align(BiasAlignment(0f, -0.7f)))

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
                stringResource(R.string.view_07_btn_save),
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
                        }
                    }
                }
            )

            WideButton(
                R.drawable.btn_wide_green,
                stringResource(R.string.view_07_btn_try_again),
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
                    stringResource(R.string.view_07_btn_copy),
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
                    stringResource(R.string.view_07_btn_share),
                    Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    onClick = {
                        val sendIntent: Intent = Intent().apply {
                            action = Intent.ACTION_SEND
                            putExtra(Intent.EXTRA_TEXT, data.nickname)
                            type = "text/plain"
                        }
                        val shareIntent = Intent.createChooser(
                            sendIntent,
                            context.getString(R.string.view_07_btn_share)
                        )
                        context.startActivity(shareIntent)
                    }
                )
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

@Composable
private fun ImageBox(modifier: Modifier = Modifier) {
    Box(
        modifier
            .fillMaxWidth(0.5f)
            .fillMaxHeight(0.3f)

    ) {
        Image(
            ImageVector.vectorResource(R.drawable.view_04_autogenerate_icon),
            contentDescription = null,
            Modifier.fillMaxSize()
        )
    }
}

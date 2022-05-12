package com.example.composetest2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composetest2.components.SmallButton
import com.example.composetest2.components.WideButton
import com.example.composetest2.components.Header
import com.example.composetest2.components.TransparentTextField
import com.example.composetest2.util.TextStyler
import com.example.composetest2.util.getRandomNick
import com.example.composetest2.model.screendata.ScreenData
import com.example.composetest2.navigation.Screen

/*
    View 05
*/


@Composable
fun AutogenerateNickname(navController: NavController) {
    var nickname by remember { mutableStateOf(getRandomNick()) }

    Box(
        Modifier.fillMaxSize(),
        Alignment.Center
    ) {
        // header components
        SmallButton(
            modifier = Modifier
                .align(Alignment.TopEnd),
            onClick = {
                navController.navigate(Screen.SavedNicknamesScreen.route)
            }
        )
        Header(
            stringResource(id = R.string.view_04_header),
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.1f)
                .align(Alignment.TopCenter)
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
            TransparentTextField(
                text = nickname,
                modifier = Modifier.align(BiasAlignment(0f, -0.1f))
            )
            WideButton(
                R.drawable.btn_wide_pink,
                stringResource(R.string.view_04_btn_try_again),
                Modifier
                    .fillMaxHeight(0.1f)
                    .align(BiasAlignment(0f, 0.2f)),
                onClick = {
                    nickname = getRandomNick()
                }
            )
            WideButton(
                R.drawable.btn_wide_green,
                stringResource(R.string.view_04_btn_customise),
                Modifier
                    .fillMaxHeight(0.1f)
                    .align(BiasAlignment(0f, 0.5f)),
                onClick = {
                    navController.currentBackStackEntry?.savedStateHandle?.set(
                        "data", ScreenData(
                            rootAsCodeList = TextStyler.splitToArrayByIndexes(nickname, 0),
                            rootNode = Screen.AutogenerateNicknameScreen.route,
                        )
                    )
                    navController.navigate(Screen.CustomizeNickNameScreen.route)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun defPreview() {
    AutogenerateNickname(NavController(LocalContext.current))
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



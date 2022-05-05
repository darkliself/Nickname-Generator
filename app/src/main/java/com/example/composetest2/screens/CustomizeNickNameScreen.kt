package com.example.composetest2.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
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
import com.example.composetest2.R
import com.example.composetest2.navigation.Screen
import com.example.composetest2.components.Header
import com.example.composetest2.components.SmallButton
import com.example.composetest2.components.WideButton
import com.example.composetest2.loadInterstitial
import com.example.composetest2.util.DecorationSide
import com.example.composetest2.util.TextStyler
import com.example.composetest2.model.screendata.ScreenData
import com.example.composetest2.showInterstitial


/*
    View 05
*/

@Composable
fun CustomizeNickNameScreen(navController: NavController, screenData: ScreenData) {
    navController.enableOnBackPressed(true)
    val context = LocalContext.current
    val alphabetIndex = screenData.alphabetIndex
    val nickname = "${screenData.prefix}${
        TextStyler.rebuildToString(
            screenData.rootAsCodeList,
            alphabetIndex
        )
    }${screenData.suffix}"

    Box(
        Modifier.fillMaxSize()
    ) {
        SmallButton(
            modifier = Modifier
                .align(Alignment.TopStart),
            image = R.drawable.arrow_left_icon,
            onClick = { navController.navigate(screenData.rootNode) }
        )
        Header(
            stringResource(id = R.string.view_05_header),
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.1f)
                .align(Alignment.TopCenter)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.7f)
                .align(BiasAlignment(0f, -0.15f))
                .clip(RoundedCornerShape(60.dp))
                .border(1.dp, Color.Black, shape = RoundedCornerShape(60.dp))
                .background(Color(0xFFE7F2D7))
        ) {
            IconAvatar(Modifier.align(BiasAlignment(-0.7f, -0.8f)))
            Text(
                text = nickname,
                Modifier
                    .fillMaxWidth(0.6f)
                    .align(BiasAlignment(1f, -0.75f))
                    .padding(end = 10.dp)
                    .horizontalScroll(rememberScrollState(nickname.length / 2)),
                // fontSize = 18.sp,
                maxLines = 1
            )
            Text(
                text = "Length: ${nickname.length}",
                Modifier
                    .fillMaxWidth(0.6f)
                    .align(BiasAlignment(1f, -0.6f)),
                color = Color(0xff9EC06A)
            )
            // left decoration
            WideButton(
                image = R.drawable.view_05_btn_left_decoration,
                text = stringResource(id = R.string.view_05_btn_left_decoration),
                Modifier
                    .fillMaxHeight(0.21f)
                    .align(BiasAlignment(0f, -0.27f)),
                onClick = {
                    screenData.side = DecorationSide.LEFT
                    navController.currentBackStackEntry?.savedStateHandle?.set("data", screenData)
                    navController.navigate(Screen.DecorationScreen.route)
                }
            )
            // font style decoration
            WideButton(
                image = R.drawable.view_05_btn_font_style,
                text = stringResource(id = R.string.view_05_btn_font_style),
                Modifier
                    .fillMaxHeight(0.21f)
                    .align(BiasAlignment(0f, 0.25f)),
                onClick = {
                    screenData.nickname = nickname
                    screenData.alphabetIndex = alphabetIndex
                    navController.currentBackStackEntry?.savedStateHandle?.set("data", screenData)
                    navController.navigate(Screen.FontStyleScreen.route)
                }
            )
            // right decoration
            WideButton(
                image = R.drawable.view_05_btn_right_decoration,
                text = stringResource(id = R.string.view_05_btn_right_decoration),
                Modifier
                    .fillMaxHeight(0.21f)
                    .align(BiasAlignment(0f, 0.77f)),
                onClick = {
                    screenData.side = DecorationSide.RIGHT
                    navController.currentBackStackEntry?.savedStateHandle?.set("data", screenData)
                    navController.navigate(Screen.DecorationScreen.route)
                }
            )
        }
        WideButton(
            image = R.drawable.btn_wide_pink,
            text = stringResource(id = R.string.view_05_btn_ready),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.15f)
                .align(BiasAlignment(0f, 0.95f)),
            imageModifier = Modifier.fillMaxWidth(),
            onClick = {
                screenData.nickname = nickname
                screenData.alphabetIndex = alphabetIndex
                navController.currentBackStackEntry?.savedStateHandle?.set("data", screenData)
                // loading ads
                loadInterstitial(context)
                showInterstitial(context)
                navController.navigate(Screen.ResultScreen.route)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    CustomizeNickNameScreen(NavController(LocalContext.current), ScreenData("some", rootNode = ""))
}

@Composable
private fun IconAvatar(modifier: Modifier) {
    Image(
        ImageVector.vectorResource(id = R.drawable.view_05_customize_icon),
        null,
        modifier
            .fillMaxWidth(0.25f)
            .fillMaxHeight(0.2f)
    )
}


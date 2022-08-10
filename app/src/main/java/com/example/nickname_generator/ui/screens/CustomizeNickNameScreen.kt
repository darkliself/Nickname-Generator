package com.example.nickname_generator.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.nickname_generator.R
import com.example.nickname_generator.navigation.Screen
import com.example.nickname_generator.ui.components.Header
import com.example.nickname_generator.ui.components.LottiAvatar
import com.example.nickname_generator.ui.components.SmallButton
import com.example.nickname_generator.loadInterstitial
import com.example.nickname_generator.model.DecorationSide
import com.example.nickname_generator.util.TextStyler
import com.example.nickname_generator.model.screendata.ScreenData
import com.example.nickname_generator.showInterstitial
import com.example.nickname_generator.ui.components.WideButton

/**
View 05
 */

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun CustomizeNickNameScreen(navController: NavController, data: ScreenData) {
    navController.enableOnBackPressed(true)
    val context = LocalContext.current
    val alphabetIndex = data.alphabetIndex
    val nickname = "${data.prefix}${
        TextStyler.rebuildToString(
            data.rootAsCodeList,
            alphabetIndex
        )
    }${data.suffix}"


    if (navController.previousBackStackEntry?.destination?.route == Screen.DecorationScreen.route
        || navController.previousBackStackEntry?.destination?.route == Screen.FontStyleScreen.route
    ) {
        navController.backQueue.removeIf {
            it.destination.route == Screen.DecorationScreen.route
                    || it.destination.route == Screen.FontStyleScreen.route
        }
        navController.backQueue.distinct()
    }

//
//    BackHandler() {
//        navController.popBackStack()
//    }

    Box(
        Modifier.fillMaxSize()
    ) {
        SmallButton(
            modifier = Modifier
                .align(Alignment.TopStart),
            image = R.drawable.arrow_left_icon,
            onClick = {
//                if (navController.previousBackStackEntry?.destination?.route == Screen.DecorationScreen.route
//                    || navController.previousBackStackEntry?.destination?.route == Screen.FontStyleScreen.route
//                ) {
//                    Log.d("IF EQUALS", "TRUE")
//                    navController.previousBackStackEntry?.destination?.id?.let {
//                        navController.graph.nodes.remove(it)
//                    }
//                }
                // navController.navigate(screenData.rootNode)
                navController.popBackStack()
            }
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

            LottiAvatar(
                modifier = Modifier.align(BiasAlignment(-0.95f, -0.95f)),
                nickname = nickname,
                icon = R.drawable.view_05_customize_icon,
                onClick = {}
            )
            val prefix = if (data.prefix != "")  (data.prefix + " ") else ""
            val suffix = if (data.suffix != "")  (" " + data.suffix)  else ""
            Text(
                text = "$prefix${
                    TextStyler.rebuildToString(
                        data.rootAsCodeList,
                        data.alphabetIndex
                    )
                }$suffix",
                modifier = Modifier
                    .fillMaxWidth(0.55f)
                    .align(BiasAlignment(1.1f, -0.75f))
                    .padding(end = 10.dp)
                    .horizontalScroll(rememberScrollState(nickname.length / 2)),
                maxLines = 1
            )
            Text(
                text = "${stringResource(R.string.view_05_length)}: ${nickname.length}",
                Modifier
                    .fillMaxWidth(0.55f)
                    .align(BiasAlignment(1.1f, -0.6f)),
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
                    data.side = DecorationSide.LEFT
                    navController.currentBackStackEntry?.savedStateHandle?.set("data", data)
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
                    data.nickname = nickname
                    data.alphabetIndex = alphabetIndex
                    navController.currentBackStackEntry?.savedStateHandle?.set("data", data)
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
                    data.side = DecorationSide.RIGHT
                    navController.currentBackStackEntry?.savedStateHandle?.set("data", data)
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
                data.root = TextStyler.rebuildToString(
                    data.rootAsCodeList,
                    alphabetIndex
                )
                data.nickname = nickname
                data.alphabetIndex = alphabetIndex
                navController.currentBackStackEntry?.savedStateHandle?.set("data", data)
                // loading ads
                loadInterstitial(context)
                showInterstitial(context)
                navController.navigate(Screen.ResultScreen.route)
            }
        )
    }
}

@RequiresApi(Build.VERSION_CODES.N)
@Preview(showBackground = true)
@Composable
private fun Preview() {
    CustomizeNickNameScreen(NavController(LocalContext.current), ScreenData("some", rootNode = ""))
}


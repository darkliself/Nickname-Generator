package com.example.composetest2.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetest2.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.composetest2.ScreenData
import com.example.composetest2.Screen
import com.example.composetest2.components.Background
import com.example.composetest2.components.Header
import com.example.composetest2.components.IconButton
import com.example.composetest2.components.SmallButton

/*
    View 01
*/

@Composable
fun MainScreen(navController: NavController) {

    Background(image = R.drawable.view_01_bg)

    Box(
        Modifier.fillMaxSize(),
    ) {
        SmallButton(
            modifier = Modifier
                .align(BiasAlignment(0f, -1f))
                .fillMaxHeight(0.1f),
            iconModifier = Modifier
                .align(Alignment.CenterEnd)
        )
        Header(
            stringResource(id = R.string.view_01_header),
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.1f)
                .align(BiasAlignment(0f, -0.65f))
        )
        IconButton(
            stringResource(R.string.view_01_btn_create),
            R.drawable.view_01_btn_create,
            Modifier
                .fillMaxHeight(0.25f)
                .fillMaxWidth(0.8f)
                .align(BiasAlignment(0f, -0.25f)),
            Modifier.align(BiasAlignment(0.1f, -0.05f)),
            onClick = { navController.navigate(Screen.CreateNickNameScreen.route) }
        )
        IconButton(
            stringResource(R.string.view_01_btn_category),
            R.drawable.view_01_btn_choose_cat,
            Modifier
                .fillMaxHeight(0.25f)
                .fillMaxWidth(0.8f)
                .align(BiasAlignment(0f, 0.3f)),
            Modifier.align(BiasAlignment(0f, -0.05f)),
            onClick = {
                navController.currentBackStackEntry?.savedStateHandle?.set("data", ScreenData("main", "left"))
                navController.navigate(Screen.CategoriesScreen.route)
            }
        )
        IconButton(
            text = stringResource(R.string.view_01_btn_autogenerate),
            image = R.drawable.view_01_btn_autogenerate,
            modifier = Modifier
                .fillMaxHeight(0.25f)
                .fillMaxWidth(0.8f)
                .align(BiasAlignment(0f, 0.85f)),
            textModifier = Modifier.align(BiasAlignment(0f, -0.05f)),
            onClick = { navController.navigate(Screen.AutogenerateNicknameScreen.route) }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    MainScreen(NavController(LocalContext.current))
}



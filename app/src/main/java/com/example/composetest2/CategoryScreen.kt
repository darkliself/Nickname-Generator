package com.example.composetest2

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.composetest2.components.Background
import com.example.composetest2.components.Header
import com.example.composetest2.components.SmallButton
import com.example.composetest2.components.SquareButton

/*
    View 03
*/


@Composable
fun CategoryView(navController: NavController) {
    Background(R.drawable.view_03_08_bg)

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
            stringResource(R.string.view_03_header),
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.1f)
                .align(BiasAlignment(0f, -1f))
        )
        SquareButton(
            stringResource(R.string.view_03_btn_legendary),
            Modifier.align(BiasAlignment(-0.9f, -0.7f)),
            R.drawable.view_03_btn_legendary,
            onClick = { navController.navigate(Screen.CategoriesNickNameListScreen.route) }

        )
        SquareButton(
            stringResource(R.string.view_03_btn_girls),
            Modifier.align(BiasAlignment(0.9f, -0.7f)),
            R.drawable.view_03_btn_girls,
            onClick = { navController.navigate(Screen.CategoriesNickNameListScreen.route) }
        )
        SquareButton(
            stringResource(R.string.view_03_btn_squard),
            Modifier.align(BiasAlignment(-0.9f, -0.3f)),
            R.drawable.view_03_btn_squard,
            onClick = { navController.navigate(Screen.CategoriesNickNameListScreen.route) }
        )
        SquareButton(
            stringResource(R.string.view_03_btn_boys),
            Modifier.align(BiasAlignment(0.9f, -0.3f)),
            R.drawable.view_03_btn_boys,
            onClick = { navController.navigate(Screen.CategoriesNickNameListScreen.route) }
        )
        SquareButton(
            stringResource(R.string.view_03_btn_charm),
            Modifier.align(BiasAlignment(-0.9f, 0.1f)),
            R.drawable.view_03_btn_charm,
            onClick = { navController.navigate(Screen.CategoriesNickNameListScreen.route) }
        )
        SquareButton(
            stringResource(R.string.view_03_btn_emoji),
            Modifier.align(BiasAlignment(0.9f, 0.1f)),
            R.drawable.view_03_btn_emoji,
            onClick = { navController.navigate(Screen.CategoriesNickNameListScreen.route) }
        )
        SquareButton(
            stringResource(R.string.view_03_btn_indian),
            Modifier.align(BiasAlignment(-0.9f, 0.5f)),
            R.drawable.view_03_btn_indian,
            onClick = { navController.navigate(Screen.CategoriesNickNameListScreen.route) }
        )
        SquareButton(
            stringResource(R.string.view_03_btn_space),
            Modifier.align(BiasAlignment(0.9f, 0.5f)),
            R.drawable.view_03_btn_space,
            onClick = { navController.navigate(Screen.CategoriesNickNameListScreen.route) }
        )
        SquareButton(
            stringResource(R.string.view_03_btn_historical),
            Modifier.align(BiasAlignment(-0.9f, 0.9f)),
            R.drawable.view_03_btn_historical,
            onClick = { navController.navigate(Screen.CategoriesNickNameListScreen.route) }
        )
        SquareButton(
            stringResource(R.string.view_03_btn_other),
            Modifier.align(BiasAlignment(0.9f, 0.9f)),
            R.drawable.view_03_btn_other,
            onClick = { navController.navigate(Screen.CategoriesNickNameListScreen.route) }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    CategoryView(NavController(LocalContext.current))
}





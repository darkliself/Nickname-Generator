package com.example.nickname_generator.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.nickname_generator.R
import com.example.nickname_generator.ui.components.Background
import com.example.nickname_generator.ui.components.Header
import com.example.nickname_generator.ui.components.SmallButton
import com.example.nickname_generator.ui.components.SquareButton
import com.example.nickname_generator.model.screendata.ScreenData
import com.example.nickname_generator.navigation.Screen

/**
    View 03
*/

@Composable
fun CategoryScreen(navController: NavController, data: ScreenData?) {
    Background(R.drawable.view_03_08_bg)

    Box(Modifier.fillMaxSize()) {
        SmallButton(
            modifier = Modifier
                .align(Alignment.TopEnd),
            onClick = { navController.navigate(Screen.SavedNicknamesScreen.route) }
        )
        Header(
            stringResource(R.string.view_03_header),
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.1f)
                .align(Alignment.TopCenter)
        )
        CategoriesListButtons(navController = navController)
    }
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview2() {
//    CategoryScreen(NavController(LocalContext.current), ScreenData("213", "left", rootNode = ""))
//}

@Composable
private fun CategoriesListButtons(navController: NavController) {
    val listOfCategories = listOf(
        stringResource(R.string.view_03_btn_legendary),
        stringResource(R.string.view_03_btn_girls),
        stringResource(R.string.view_03_btn_squard),
        stringResource(R.string.view_03_btn_boys),
        stringResource(R.string.view_03_btn_charm),
        stringResource(R.string.view_03_btn_emoji),
        stringResource(R.string.view_03_btn_indian),
        stringResource(R.string.view_03_btn_space),
        stringResource(R.string.view_03_btn_historical),
        stringResource(R.string.view_03_btn_other)
    )
    val listOfImages = listOf(
        R.drawable.view_03_btn_legendary,
        R.drawable.view_03_btn_girls,
        R.drawable.view_03_btn_squard,
        R.drawable.view_03_btn_boys,
        R.drawable.view_03_btn_charm,
        R.drawable.view_03_btn_emoji,
        R.drawable.view_03_btn_indian,
        R.drawable.view_03_btn_space,
        R.drawable.view_03_btn_historical,
        R.drawable.view_03_btn_other
    )
    var initHeight = -1.1f
    var side = -0.9f
    Box(Modifier.fillMaxSize()) {
        repeat(listOfCategories.count()) { index ->
            if (index % 2 == 0) initHeight += 0.4f
            SquareButton(
                listOfCategories[index],
                Modifier.align(BiasAlignment(side, initHeight)),
                listOfImages[index],
                onClick = {
                    navController.navigate("${Screen.CategoryNickNameListScreen.route}?category=${listOfCategories[index]}")
                }
            )
            side *= -1f
        }
    }
}



package com.example.nickname_generator.ui.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.nickname_generator.R
import com.example.nickname_generator.model.nicknamesList
import com.example.nickname_generator.model.screendata.ScreenData
import com.example.nickname_generator.navigation.Screen
import com.example.nickname_generator.ui.components.*
import com.example.nickname_generator.util.TextStyler
import com.example.nickname_generator.util.sortByCategory

/**
    View 06
*/

@ExperimentalAnimationApi
@Composable
fun CategoryNickNameListScreen(navController: NavController, category: String?) {
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
    val category = category ?: ""
    Background(R.drawable.view_06_07_bg)

    Box(
        Modifier.fillMaxSize(),
    ) {
        SmallButton(
            modifier = Modifier
                .align(Alignment.TopStart),
            image = R.drawable.arrow_left_icon,
            onClick = { navController.popBackStack() }
        )
        Header(
            "Category name \"$category\"",
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.1f)
                .align(Alignment.TopCenter)
        )
        // Filter buttons
//        Row(
//            Modifier
//                .fillMaxWidth()
//                .fillMaxHeight(0.07f)
//                .align(BiasAlignment(0f, -0.8f))
//        ) {
//             Spacer(modifier = Modifier.width(10.dp))
//             RoundedButton("ALL", onClick = { println("ALL") })
//             Spacer(modifier = Modifier.width(10.dp))
//             RoundedButton("NEW", onClick = { println("NEW") })
//             Spacer(modifier = Modifier.width(10.dp))
//             RoundedButton("POPULAR", onClick = { println("POPULAR") })
//        }
        LazyColumn(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.9f)
                .padding(start = 20.dp)
                .align(BiasAlignment(-0.8f, 0.9f)),
            //horizontalAlignment = BiasAlignment.Horizontal(0f)
        ) {
            val sortedNicknameList = sortByCategory(nicknamesList, listOfCategories.indexOf(category), listOfCategories.count())
            items(sortedNicknameList.count()) { index ->
                // LazyColumnItem(text = "Item: $index")
                LazyColumnItem(text = sortedNicknameList[index],
                    onClick = {
                        navController.currentBackStackEntry?.savedStateHandle?.set(
                            "data",
                            ScreenData(
                                prefix = "",
                                suffix = "",
                                rootAsCodeList = TextStyler.splitToArrayByIndexes(sortedNicknameList[index], 0),
                                alphabetIndex = 0,
                                rootNode = Screen.CategoryNickNameListScreen.route
                            )
                        )
                        navController.navigate(Screen.CustomizeNickNameScreen.route)
                    },
                )
            }
        }
    }
}

//@ExperimentalAnimationApi
//@Preview (showBackground = true)
//@Composable
//private fun Preview() {
//    CategoryNickNameListScreen("category", NavController(LocalContext.current))
//}



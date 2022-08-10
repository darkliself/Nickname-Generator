package com.example.nickname_generator.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.nickname_generator.model.screendata.ScreenData
import com.example.nickname_generator.ui.screens.*
import com.example.nickname_generator.ui.screens.MainScreen


@ExperimentalComposeUiApi
@RequiresApi(Build.VERSION_CODES.N)
@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(route = Screen.CreateNickNameScreen.route) {
            CreateNickNameScreen(navController = navController)
        }
        composable(route = Screen.CategoriesScreen.route) {
            val data = navController
                .previousBackStackEntry?.savedStateHandle?.get<ScreenData>("data")
            CategoryScreen(navController = navController, data = data)
        }
        composable(route = Screen.AutogenerateNicknameScreen.route) {
            AutogenerateNickname(navController = navController)
        }
        composable(
            route = Screen.CustomizeNickNameScreen.route
        ) {
            val data = navController
                .previousBackStackEntry?.savedStateHandle?.get<ScreenData>("data")
            if (data != null) {
                CustomizeNickNameScreen(
                    navController = navController,
                    data = data
                )
            }
        }
        composable(
            route = Screen.CategoryNickNameListScreen.route + "?category={category}",
            arguments = listOf(
                navArgument("category") {
                    type = NavType.StringType
                    defaultValue = "Emoji"
                }
            )
        ) { entry ->
            CategoryNickNameListScreen(
                category = entry.arguments?.getString("category"),
                navController = navController
            )
        }
        composable(
            route = Screen.DecorationScreen.route,
            arguments = listOf()
        ) {
            val data =
                navController.previousBackStackEntry?.savedStateHandle?.get<ScreenData>("data")
            if (data != null) {
                DecorationScreen(
                    navController = navController,
                    data = data
                )
            }
        }
        composable(
            route = Screen.FontStyleScreen.route
        ) {
            val data =
                navController.previousBackStackEntry?.savedStateHandle?.get<ScreenData>("data")
            if (data != null) {
                FontStyleScreen(
                    navController = navController,
                    data = data,
                )
            }
        }
        composable(
            route = Screen.ResultScreen.route + "?nickname={nickname}/alphabetIndex={alphabetIndex}",
            arguments = listOf(
                navArgument("nickname") {
                    type = NavType.StringType
                    defaultValue = "Killer"
                },
                navArgument("alphabetIndex") {
                    type = NavType.IntType
                    defaultValue = 0
                }
            )) {
            val data =
                navController.previousBackStackEntry?.savedStateHandle?.get<ScreenData>("data")
            if (data != null) {
                ResultScreen(
                    navController = navController,
                    data = data
                )
            }
        }
        composable(
            route = Screen.SavedNicknamesScreen.route
        ) {
            SavedNicknamesScreen(navController = navController)
        }
    }
}






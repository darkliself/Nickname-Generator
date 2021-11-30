package com.example.composetest2

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composetest2.ui.theme.MainScreen


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
            CategoryScreen(navController = navController)
        }
        composable(route = Screen.AutogenerateNicknameScreen.route) {
            AutogenerateNickname(navController = navController)
        }
        composable(
            route = Screen.CustomizeNickNameScreen.route + "?nickname={nickname}",
            arguments = listOf(
                navArgument("nickname") {
                    type = NavType.StringType
                    defaultValue = "DefaultVal"
                }
            )
        ) { entry ->
            CustomizeNickNameScreen(
                nickname = entry.arguments?.getString("nickname"),
                navController = navController
            )
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
            route = Screen.DecorationScreen.route + "?nickname={nickname}/side={side}",
            arguments = listOf(
                navArgument("nickname") {
                    type = NavType.StringType
                    defaultValue = "Killer"
                },
                navArgument("side") {
                    type = NavType.StringType
                    defaultValue = "left"
                }
            )) { entry ->
            DecorationScreen(
                nickname = entry.arguments?.getString("nickname"),
                side = entry.arguments?.getString("side"),
                navController = navController
            )
        }
        composable(
            route = Screen.FontStyleScreen.route + "?nickname={nickname}",
            arguments = listOf(
                navArgument("nickname") {
                    type = NavType.StringType
                    defaultValue = "Killer"
                })
        ) { entry ->
            entry.arguments?.getString("nickname")
                ?.let { FontStyleScreen(nickname = it, navController = navController) }
        }
        composable(
            route = Screen.ResultScreen.route + "?nickname={nickname}",
            arguments = listOf(
                navArgument("nickname") {
                    type = NavType.StringType
                    defaultValue = "Killer"
                }
            )) { entry ->
            ResultScreen(
                nickname = entry.arguments?.getString("nickname"),
                navController = navController
            )
        }
        composable(
            route = Screen.TestScreen.route
        ) {
            TestScreen()
        }
//        composable(
//            route = Screen.SecondScreen.route + "?name={name}",
//            arguments = listOf(
//                navArgument("name") {
//                    type = NavType.StringType
//                    defaultValue = "DefaultVal"
//                    nullable = true
//                }
//            )
//        ) { entry ->
//            SecondScreen(name = entry.arguments?.getString("name"))
//        }
    }
}






package com.example.composetest2

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composetest2.ui.theme.MainScreen


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
        composable(route = Screen.CategoryScreen.route) {
            CategoryView(navController = navController)
        }
        composable(route = Screen.AutogenerateNicknameScreen.route) {
            AutogenerateNickname(navController = navController)
        }
        composable(route = Screen.CustomizeNickNameScreen.route) {
            CustomizeNickNameScreen(navController = navController)
        }
        composable(route = Screen.CategoriesNickNameListScreen.route) {
            CategoryNickNameListScreen(navController = navController)
        }
        composable(route = Screen.DecorationScreen.route) {
            DecorationScreen(navController = navController)
        }
        composable(route = Screen.ResultScreen.route) {
            ResultScreen(navController = navController)
        }
        composable(route = Screen.FontStyleScreen.route) {
            FontStyleScreen(navController = navController)
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






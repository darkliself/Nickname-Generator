package com.example.composetest2

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composetest2.ui.theme.MainScreen
import kotlinx.parcelize.Parcelize


@RequiresApi(Build.VERSION_CODES.N)
@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun Navigation() {
    val navController = rememberNavController()
    Scaffold() {

    }

    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(
            route = Screen.CreateNickNameScreen.route,
            ) {
            CreateNickNameScreen(navController = navController)
        }
        composable(route = Screen.CategoriesScreen.route + "?parcelizeData={parcelizeData}",
            arguments = listOf(
                navArgument("parcelizeData") {
                    type = NavType.ParcelableType(
                        type = ParcelizeData::class.java
                    )
                }
            )
            ) { entry ->
            CategoryScreen(navController = navController, entry.arguments?.getParcelable("parcelizeData"))
        }
        composable(route = Screen.AutogenerateNicknameScreen.route) {
            AutogenerateNickname(navController = navController)
        }
        composable(
            route = Screen.CustomizeNickNameScreen.route + "?nickname={nickname}/alphabetIndex={alphabetIndex}",
            arguments = listOf(
                navArgument("nickname") {
                    type = NavType.StringType
                    defaultValue = "DefaultVal"
                },
                navArgument("alphabetIndex") {
                    type = NavType.IntType
                    defaultValue = 0
                }
            )
        ) { entry ->
            CustomizeNickNameScreen(
                nickname = entry.arguments?.getString("nickname"),
                alphabetIndex = entry.arguments?.getInt("alphabetIndex"),
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
            route = Screen.DecorationScreen.route + "?nickname={nickname}/side={side}/alphabetIndex={alphabetIndex}",
            arguments = listOf(
                navArgument("nickname") {
                    type = NavType.StringType
                    defaultValue = "Killer"
                },
                navArgument("side") {
                    type = NavType.StringType
                    defaultValue = "left"
                },
                navArgument("alphabetIndex") {
                    type = NavType.IntType
                    defaultValue = 0
                }
            )) { entry ->

            DecorationScreen(
                nickname = entry.arguments?.getString("nickname"),
                side = entry.arguments?.getString("side"),
                alphabetIndex = entry.arguments?.getInt("alphabetIndex"),
                navController = navController
            )

        }
        composable(
            route = Screen.FontStyleScreen.route + "?nickname={nickname}/alphabetIndex={alphabetIndex}",
            arguments = listOf(
                navArgument("nickname") {
                    type = NavType.StringType
                    defaultValue = "Killer"
                },
                navArgument("alphabetIndex") {
                    type = NavType.IntType
                    defaultValue = 0
                })
        ) { entry ->
            FontStyleScreen(
                nickname = entry.arguments?.getString("nickname"),
                alphabetIndex = entry.arguments?.getInt("alphabetIndex"),
                navController = navController
            )
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
            )) { entry ->
            ResultScreen(
                nickname = entry.arguments?.getString("nickname"),
                alphabetIndex = entry.arguments?.getInt("alphabetIndex"),
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






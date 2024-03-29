package com.example.nickname_generator.navigation;

sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object CreateNickNameScreen : Screen("create_nick_name")
    object AutogenerateNicknameScreen : Screen("autogenerate_nickname")
    object CategoriesScreen : Screen("categories_screen")
    object CustomizeNickNameScreen : Screen("customize_nickname")
    object CategoryNickNameListScreen : Screen("category_nickname_list_screen")
    object DecorationScreen : Screen("decoration_screen")
    object ResultScreen : Screen("result_screen")
    object FontStyleScreen : Screen("font_style_screen")
    object SavedNicknamesScreen : Screen("saved_screen")
}
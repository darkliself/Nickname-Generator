package com.example.composetest2;



sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object CreateNickNameScreen : Screen("create_nick_name")
    object CategoryScreen : Screen("category_screen")
    object AutogenerateNicknameScreen : Screen("autogenerate_nickname")
    object CustomizeNickNameScreen : Screen("customize_nickname")
    object CategoriesNickNameListScreen : Screen("category_nickname_list_screen")
    object DecorationScreen : Screen("decoration_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            if (args.any()) {
                args.forEach {
                    append(it)
                }
            }
        }
    }
}
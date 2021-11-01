package com.example.composetest2;



sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object CreateNickNameScreen : Screen("create_nick_name_screen")
    object CategoryScreen : Screen("category_screen")
    object AutogenerateNickname : Screen("autogenerate_nickname")

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
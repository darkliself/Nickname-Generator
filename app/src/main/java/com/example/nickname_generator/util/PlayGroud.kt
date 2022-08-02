package com.example.nickname_generator.util

import com.example.nickname_generator.model.nicknamesList
import java.util.*


fun main(args: Array<String>) {
    sortByCategory(nicknamesList, 2, 12)
    println(nicknamesList.indexOf("test"))
}

fun sortByCategory(list: List<String>, categoryIndex: Int, categoriesCount: Int): List<String> {
    return list.drop(categoryIndex).filterIndexed { index, _ -> index %  categoriesCount == 0 }
}
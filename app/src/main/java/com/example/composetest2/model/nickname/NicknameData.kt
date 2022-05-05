package com.example.composetest2.model.nickname

import kotlinx.serialization.Serializable


@Serializable
data class NicknameData(
    var prefix: String = "",
    var suffix: String = "",
    var rootAsCodeList: List<String> = listOf(),
    var alphabetIndex: Int = 0,
)
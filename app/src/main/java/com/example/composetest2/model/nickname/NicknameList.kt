package com.example.composetest2.model.nickname

import kotlinx.serialization.Serializable


@Serializable
data class NicknameList(
    val list: Map<String, NicknameData> = mapOf()
)
package com.example.composetest2.model.nickname

import android.os.Parcelable
import com.example.composetest2.logic.DecorationSide
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable


@Serializable
data class NicknameData(
    var prefix: String = "",
    var suffix: String = "",
    var rootAsCodeList: List<String> = listOf(),
    var alphabetIndex: Int = 0,
)
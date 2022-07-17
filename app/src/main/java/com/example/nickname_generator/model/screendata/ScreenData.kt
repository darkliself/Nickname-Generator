package com.example.nickname_generator.model.screendata

import android.os.Parcelable
import com.example.nickname_generator.model.DecorationSide
import kotlinx.parcelize.Parcelize


@Parcelize
data class ScreenData(
    var nickname: String = "",
    val rootNode: String,
    var root: String = "",
    var prefix: String = "",
    var suffix: String = "",
    var alphabetIndex: Int = 0,
    var rootAsCodeList: List<String> = listOf(),
    var side: DecorationSide = DecorationSide.LEFT,
) : Parcelable





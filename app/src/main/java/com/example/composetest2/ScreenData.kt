package com.example.composetest2

import android.os.Parcelable
import com.example.composetest2.logic.DecorationSide
import kotlinx.parcelize.Parcelize


@Parcelize
data class ScreenData(
    val rootNode: String,
    var root: String = "",
    var prefix: String = "",
    var suffix: String = "",
    var alphabetIndex: Int = 0,
    var side: DecorationSide = DecorationSide.LEFT,
    var nickname: String = "$prefix$root$suffix",
) : Parcelable





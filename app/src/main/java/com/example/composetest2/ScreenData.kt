package com.example.composetest2

import android.os.Parcelable
import com.example.composetest2.logic.DecorationSide
import kotlinx.parcelize.Parcelize


@Parcelize
data class ScreenData(
    var nickname: String = "Default",
    val rootNode: String,
    var alphabetIndex: Int = 0,
    var side: DecorationSide = DecorationSide.LEFT
) : Parcelable





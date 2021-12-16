package com.example.composetest2

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class ScreenData(
    val rootNode: String,
    val alphabetIndex: Int,
    val side: String
) : Parcelable

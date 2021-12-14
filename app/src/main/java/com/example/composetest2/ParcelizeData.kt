package com.example.composetest2

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
class ParcelizeData(
    val rootNode: String,
    val alphabetIndex: Int,
    val side: String
) : Parcelable

package com.example.composetest2

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object Dimensions {
    @Composable
    fun getHeight(): Int {
        return (LocalContext.current.resources.displayMetrics.heightPixels / LocalContext.current.resources.displayMetrics.density).toInt()
    }
    @Composable
    fun getWidth(): Int {
        return (LocalContext.current.resources.displayMetrics.widthPixels / LocalContext.current.resources.displayMetrics.density).toInt()
    }
}
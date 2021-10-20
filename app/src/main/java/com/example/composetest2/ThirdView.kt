package com.example.composetest2



import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.unit.dp



@Composable
fun ThirdView(context: Context) {
    Column(
       modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.wrapContentHeight(CenterVertically).background(Color.Black).width(100.dp)
        ) {

        }

    }
}


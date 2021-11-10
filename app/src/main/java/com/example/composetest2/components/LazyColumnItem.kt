package com.example.composetest2.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetest2.R

@Composable
fun LazyColumnItem(text: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(top = 10.dp, bottom = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            modifier = Modifier,
        )
        Image(
            ImageVector.vectorResource(id = R.drawable.icon_pencil),
            contentDescription = null,
            modifier = Modifier.padding(end = 20.dp),

            )
    }
    Divider(
        color = Color(0XFFE7F2D7),
        thickness = 1.dp,
    )
}
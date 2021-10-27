package com.example.composetest2

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetest2.ui.theme.MenuButton
import com.example.composetest2.ui.theme.TextBox

@Composable
fun CreateNickNameView() {
    Box(
        Modifier.fillMaxSize()
    ) {
        Header()
        Box(modifier = Modifier
            .fillMaxWidth(0.9f)
            .fillMaxHeight(0.85f)
            .align(BiasAlignment(0f, 0.6f))) {
//            Image(
//                ImageVector.vectorResource(id = R.drawable.view_02_card_bg),
//                null,
//                Modifier.fillMaxSize(),
//                contentScale = ContentScale.FillBounds
//                //.align(BiasAlignment(-0.5f, 0f))
//            )
            Surface(
                Modifier.fillMaxSize(),
                color = Color(0xFFE7F2D7),
                shape = RoundedCornerShape(60.dp),
                border = BorderStroke(1.dp, color = Color.Black)
            ) {

            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    CreateNickNameView()
}

@Composable
private fun Header() {
    Box(
        Modifier
            .fillMaxHeight(0.1f)
            .fillMaxWidth()
    ) {
        MenuButton(modifier = Modifier
            .align(BiasAlignment(0f, 0f))
            .fillMaxHeight()
            .fillMaxWidth(0.9f),
            iconModifier = Modifier
                .align(Alignment.CenterEnd)
                .clickable {
                    Log.i(">>>>>>>>>>>>>>>>>", "its here")
                }
        )
        TextBox(
            "Create custom nickname",
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight()
                .align(BiasAlignment(0f, 0f))
        )
    }
}

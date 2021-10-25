package com.example.composetest2

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetest2.ui.theme.Header
import com.example.composetest2.ui.theme.TextBox

@Composable
fun CategoryView() {
    Image(
        ImageVector.vectorResource(id = R.drawable.view_02_bg),
        null,
        Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
    Box(
        Modifier.fillMaxSize(),
    ) {
        Header(modifier = Modifier
            .align(BiasAlignment(0f, -1f))
            .fillMaxHeight(0.1f),
            iconModifier = Modifier
                .align(Alignment.CenterEnd)
                .clickable {
                    Log.i(">>>>>>>>>>>>>>>>>", "its here")
                }
        )
        TextBox(
            "Category",
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.1f)
                .align(BiasAlignment(0f, -1f))
        )
        SecondViewButton(
            "Legendary",
            Modifier.align(BiasAlignment(-0.9f, -0.7f)),
            R.drawable.view_02_btn_legendary
        )
        SecondViewButton(
            "Girls",
            Modifier.align(BiasAlignment(0.9f, -0.7f)),
            R.drawable.view_02_btn_girls
        )
        SecondViewButton(
            "Squard",
            Modifier.align(BiasAlignment(-0.9f, -0.3f)),
            R.drawable.view_02_btn_squard
        )
        SecondViewButton(
            "Boys",
            Modifier.align(BiasAlignment(0.9f, -0.3f)),
            R.drawable.view_02_btn_boys
        )
        SecondViewButton(
            "Charm",
            Modifier.align(BiasAlignment(-0.9f, 0.1f)),
            R.drawable.view_02_btn_charm
        )
        SecondViewButton(
            "Emoji",
            Modifier.align(BiasAlignment(0.9f, 0.1f)),
            R.drawable.view_02_btn_emoji
        )
        SecondViewButton(
            "Indian",
            Modifier.align(BiasAlignment(-0.9f, 0.5f)),
            R.drawable.view_02_btn_indian
        )
        SecondViewButton(
            "Space",
            Modifier.align(BiasAlignment(0.9f, 0.5f)),
            R.drawable.view_02_btn_space
        )
        SecondViewButton(
            "Historical",
            Modifier.align(BiasAlignment(-0.9f, 0.9f)),
            R.drawable.view_02_btn_historical
        )
        SecondViewButton(
            "Other",
            Modifier.align(BiasAlignment(0.9f, 0.9f)),
            R.drawable.view_02_btn_other
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    CategoryView()
}

@Composable
fun SecondViewButton(
    text: String,
    modifier: Modifier,
    @DrawableRes image: Int
) {
    Box(
        modifier
            .fillMaxWidth(0.48f)
            .fillMaxHeight(0.15f),
        Alignment.Center
    ) {
        Image(
            ImageVector.vectorResource(id = image),
            contentDescription = null
        )
        Text(text, Modifier.align(BiasAlignment(0f, 0.25f)))
    }
}

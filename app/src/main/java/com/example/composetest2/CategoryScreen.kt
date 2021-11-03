package com.example.composetest2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetest2.components.Header
import com.example.composetest2.components.SmallButton
import com.example.composetest2.components.SquereButton

@Composable
fun CategoryView() {
    Image(
        ImageVector.vectorResource(id = R.drawable.view_03_bg),
        null,
        Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
    Box(
        Modifier.fillMaxSize(),
    ) {
        SmallButton(modifier = Modifier
            .align(BiasAlignment(0f, -1f))
            .fillMaxHeight(0.1f),
            iconModifier = Modifier
                .align(Alignment.CenterEnd)
        )
        Header(
            stringResource(R.string.view_03_header),
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.1f)
                .align(BiasAlignment(0f, -1f))
        )
        SquereButton(
            stringResource(R.string.view_03_btn_legendary),
            Modifier.align(BiasAlignment(-0.9f, -0.7f)),
            R.drawable.view_03_btn_legendary
        )
        SquereButton(
            stringResource(R.string.view_03_btn_girls),
            Modifier.align(BiasAlignment(0.9f, -0.7f)),
            R.drawable.view_03_btn_girls
        )
        SquereButton(
            stringResource(R.string.view_03_btn_squard),
            Modifier.align(BiasAlignment(-0.9f, -0.3f)),
            R.drawable.view_03_btn_squard
        )
        SquereButton(
            stringResource(R.string.view_03_btn_boys),
            Modifier.align(BiasAlignment(0.9f, -0.3f)),
            R.drawable.view_03_btn_boys
        )
        SquereButton(
            stringResource(R.string.view_03_btn_charm),
            Modifier.align(BiasAlignment(-0.9f, 0.1f)),
            R.drawable.view_03_btn_charm
        )
        SquereButton(
            stringResource(R.string.view_03_btn_emoji),
            Modifier.align(BiasAlignment(0.9f, 0.1f)),
            R.drawable.view_03_btn_emoji
        )
        SquereButton(
            stringResource(R.string.view_03_btn_indian),
            Modifier.align(BiasAlignment(-0.9f, 0.5f)),
            R.drawable.view_03_btn_indian
        )
        SquereButton(
            stringResource(R.string.view_03_btn_space),
            Modifier.align(BiasAlignment(0.9f, 0.5f)),
            R.drawable.view_03_btn_space
        )
        SquereButton(
            stringResource(R.string.view_03_btn_historical),
            Modifier.align(BiasAlignment(-0.9f, 0.9f)),
            R.drawable.view_03_btn_historical
        )
        SquereButton(
            stringResource(R.string.view_03_btn_other),
            Modifier.align(BiasAlignment(0.9f, 0.9f)),
            R.drawable.view_03_btn_other
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    CategoryView()
}





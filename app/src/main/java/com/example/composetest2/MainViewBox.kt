package com.example.composetest2.ui.theme

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetest2.R
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.zIndex
import com.example.composetest2.components.ButtonWithImage
import com.example.composetest2.components.IconForButton
import com.example.composetest2.testClickToast

@Composable
fun MainView(context: Context) {
    Image(
        ImageVector.vectorResource(id = R.drawable.bg_main_view),
        contentDescription = null,
        Modifier
            .fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
    Box(
        Modifier.fillMaxSize(),
    ) {
        Header(
            modifier = Modifier
                .align(BiasAlignment(0f, -1f))
                .zIndex(1f)
        )
        TextBox(
            "Create\nyour perfect nickname", modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.1f)
                .align(BiasAlignment(0f, -0.55f))
        )

        MainViewButton(
            "Create custom nickname",
            context,
            Modifier.align(BiasAlignment(0f, -0.25f))
        )

        MainViewButton(
            "Choose from category",
            context,
            Modifier.align(BiasAlignment(0f, 0.3f))
        )
        MainViewButton(
            "Autogenerate nickname",
            context,
            Modifier.align(BiasAlignment(0f, 0.85f))
        )
    }

}

@Composable
fun Header(modifier: Modifier) {
    Box(
        modifier
            .fillMaxHeight(0.2f)
            .fillMaxWidth(0.8f)
        ) {
        Image(
            ImageVector.vectorResource(id = R.drawable.menu),
            contentDescription = null,
            Modifier
                .size(35.dp, 35.dp)
                .align(BiasAlignment(1f, -0.75f))
        )
    }
}

@Composable
fun TextBox(text: String, modifier: Modifier) {
    Box(
        modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontFamily = FontFamily(listOf(Font(R.font.montserrat_medium))),
            fontWeight = FontWeight.W900,
        )
    }
}

@Composable
fun MainViewButton(text: String, context: Context, modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxHeight(0.25f)
            .fillMaxWidth(0.8f)
    ) {
        ButtonWithImage(
            text,
            R.drawable.btn_large_green,
            listOf<Int>(R.drawable.icon_light_pink, R.drawable.icon_pen),
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
                .align(Alignment.Center),
            textModifier = Modifier.align(BiasAlignment(-0.15f, -0.05f)),
            onClick = { testClickToast(context) }
        ) {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.Cyan)
                .zIndex(20f)) {
                Image(ImageVector.vectorResource(id = R.drawable.menu), contentDescription = null)
            }
        }
//        IconForButton(
//            iconId = listOf(R.drawable.icon_light_green_bg, R.drawable.icon_light_green_bg),
//            modifier = Modifier
//                .fillMaxSize(0.25f)
//                .align(BiasAlignment(-1f, -0.05f))
//        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainView(LocalContext.current)
}



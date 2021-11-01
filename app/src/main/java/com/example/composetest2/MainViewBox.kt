package com.example.composetest2.ui.theme

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.example.composetest2.Navigation
import com.example.composetest2.Screen
import com.example.composetest2.components.ButtonWithImage

@Composable



fun MainScreen(navController: NavController) {
    Image(
        ImageVector.vectorResource(id = R.drawable.view_01_bg),
        contentDescription = null,
        Modifier
            .fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
    Box(
        Modifier.fillMaxSize(),
    ) {
        MenuButton(
            modifier = Modifier
                .align(BiasAlignment(0f, -1f))
                .zIndex(1f),
            iconModifier = Modifier.align(BiasAlignment(1f, -0.75f))
        )

        TextBox(
            stringResource(R.string.view_01_create_header),
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.1f)
                .align(BiasAlignment(0f, -0.55f))
        )

        MainViewButton(
            stringResource(R.string.view_01_btn_create),
            Modifier.align(BiasAlignment(0f, -0.25f)),
            R.drawable.view_01_btn_create,
            onClick = {
                navController.navigate(Screen.CreateNickNameScreen.route)
            }
        )

        MainViewButton(
            stringResource(R.string.view_01_btn_category),
            Modifier.align(BiasAlignment(0f, 0.3f)),
            R.drawable.view_01_btn_choose_cat,
            onClick = {
                navController.navigate(Screen.CategoryScreen.route)
            }
        )

        MainViewButton(
            stringResource(R.string.view_01_btn_autogenerate),
            Modifier.align(BiasAlignment(0f, 0.85f)),
            R.drawable.view_01_btn_autogenerate,
            {}
        )
    }
}

@Composable
fun MenuButton(
    modifier: Modifier,
    iconModifier: Modifier = Modifier.size(35.dp, 35.dp)
) {
    Box(
        modifier
            .fillMaxHeight(0.2f)
            .fillMaxWidth(0.8f)
    ) {
        Image(
            ImageVector.vectorResource(id = R.drawable.btn_menu),
            contentDescription = null,
            modifier = iconModifier
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
fun MainViewButton(
    text: String,
    modifier: Modifier,
    @DrawableRes image: Int,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxHeight(0.25f)
            .fillMaxWidth(0.8f)
    ) {
        ButtonWithImage(
            text = text,
            image = image,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
                .align(Alignment.Center),
            textModifier = Modifier.align(BiasAlignment(0f, -0.05f)),
            onClick = onClick
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen(NavController(LocalContext.current))
}



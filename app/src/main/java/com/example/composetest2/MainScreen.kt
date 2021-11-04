package com.example.composetest2.ui.theme

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
import androidx.compose.ui.unit.sp
import com.example.composetest2.R
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.composetest2.Screen
import com.example.composetest2.components.Header
import com.example.composetest2.components.IconButton
import com.example.composetest2.components.SmallButton

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
        SmallButton(modifier = Modifier
            .align(BiasAlignment(0f, -1f))
            .fillMaxHeight(0.1f),
            iconModifier = Modifier
                .align(Alignment.CenterEnd)
        )
        Header(
            stringResource(R.string.view_01_header),
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.1f)
                .align(BiasAlignment(0f, -0.65f))
        )

        IconButton(
            stringResource(R.string.view_01_btn_create),
            R.drawable.view_01_btn_create,
            Modifier
                .fillMaxHeight(0.25f)
                .fillMaxWidth(0.8f)
                .align(BiasAlignment(0f, -0.25f)),
            Modifier.align(BiasAlignment(0.1f, -0.05f)),
            onClick = {
                navController.navigate(Screen.CustomizeNickNameScreen.route)
            }
        )

        IconButton(
            stringResource(R.string.view_01_btn_category),
            R.drawable.view_01_btn_choose_cat,
            Modifier
                .fillMaxHeight(0.25f)
                .fillMaxWidth(0.8f).align(BiasAlignment(0f, 0.3f)),
            Modifier.align(BiasAlignment(0f, -0.05f)),
            onClick = {
                navController.navigate(Screen.CategoryScreen.route)
            }
        )

        IconButton(
            stringResource(R.string.view_01_btn_autogenerate),
            R.drawable.view_01_btn_autogenerate,
            Modifier
                .fillMaxHeight(0.25f)
                .fillMaxWidth(0.8f).align(BiasAlignment(0f, 0.85f)),
            Modifier.align(BiasAlignment(0f, -0.05f)),
            onClick = {
                navController.navigate(Screen.AutogenerateNicknameScreen.route)
            }
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

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    MainScreen(NavController(LocalContext.current))
}



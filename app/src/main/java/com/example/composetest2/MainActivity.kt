package com.example.composetest2

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
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
import com.example.composetest2.components.ButtonWithImage
import com.example.composetest2.components.IconForButton
import com.example.composetest2.ui.theme.MainView


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainView(this)
        }
    }
}

@Composable
fun Header(context: Context) {
    Image(
        ImageVector.vectorResource(id = R.drawable.bg_main_view),
        contentDescription = null,
        Modifier
            .fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
    Column(
        Modifier
            .fillMaxSize(),
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(top = 40.dp, end = 20.dp),

            horizontalArrangement = Arrangement.End
        ) {
            Image(
                ImageVector.vectorResource(id = R.drawable.menu),
                contentDescription = null,
                Modifier
                    .size(35.dp, 35.dp)
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Box(
            Modifier
                .fillMaxWidth()
                .size(320.dp, 120.dp),
            contentAlignment = Center
        ) {
            Text(
                text = "Create\nyour perfect nickname",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontFamily = FontFamily(listOf(Font(R.font.montserrat_medium))),
                fontWeight = FontWeight.W900
            )
        }

        Spacer(modifier = Modifier.size(30.dp))

        // element
        Box(
            modifier = Modifier
                .size(300.dp, 120.dp)
                .align(CenterHorizontally)
        ) {
            ButtonWithImage(
                "Create custom nickname",
                R.drawable.btn_large_pink,
                Modifier
                    .align(Center)
                    .size(320.dp, 120.dp),
                onClick = { testClickToast(context) }
            )
            IconForButton(
                listOf(
                    R.drawable.icon_light_pink,
                    R.drawable.icon_pen
                ),
                Modifier
                    .align(BiasAlignment(-0.75f, -0.10f))
                    .size(50.dp, 50.dp)
            )
        }

        Spacer(modifier = Modifier.size(30.dp))

        // element
        Box(
            modifier = Modifier
                .size(300.dp, 120.dp)
                .align(CenterHorizontally)
        ) {
            ButtonWithImage(
                "Choose from category",
                R.drawable.btn_large_green,
                Modifier
                    .align(Center)
                    .size(320.dp, 120.dp),
                onClick = { testClickToast(context) }
            )
            IconForButton(
                listOf(
                    R.drawable.icon_light_green_bg,
                    R.drawable.icon_categories
                ),
                Modifier
                    .align(BiasAlignment(-0.75f, -0.10f))
                    .size(50.dp, 50.dp)
            )
        }

        Spacer(modifier = Modifier.size(30.dp))

        // element
        Box(
            modifier = Modifier
                .size(300.dp, 120.dp)
                .align(CenterHorizontally)
        ) {
            ButtonWithImage(
                "Autogenerate nickname",
                R.drawable.btn_large_pink,
                Modifier
                    .align(Center)
                    .size(320.dp, 120.dp),
                onClick = { testClickToast(context) }
            )
            IconForButton(
                listOf(
                    R.drawable.icon_light_pink,
                    R.drawable.icon_autogenerate
                ),
                Modifier
                    .align(BiasAlignment(-0.75f, -0.10f))
                    .size(50.dp, 50.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Header(LocalContext.current)
}

fun testClickToast(context: Context) {
    Toast.makeText(context, "its clicked", Toast.LENGTH_SHORT).show()
}
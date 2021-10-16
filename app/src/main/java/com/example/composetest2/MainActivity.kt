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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetest2.components.ButtonWithImages
import com.example.composetest2.components.IconForButton
import com.example.composetest2.ui.theme.NickCreator1
import com.example.composetest2.ui.theme.border


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Header("Create your perfect nickname", this)
        }
    }
}

@Composable
fun Header(str: String, context: Context) {
    Column(
        Modifier
            .fillMaxSize(),

        ) {
        Row(
            Modifier
                .fillMaxWidth()
                .height(80.dp)
                .border(border = BorderStroke(1.dp, Color.Black))
                .padding(top = 20.dp, end = 20.dp),

            horizontalArrangement = Arrangement.End
        ) {
            Box(
                Modifier
                    .size(20.dp, 20.dp)
                    .background(Color.Black)
                    .padding(top = 20.dp)
            ) {
            }
        }
        Spacer(modifier = Modifier.size(10.dp))
        Box(
            Modifier
                .fillMaxWidth()
                .height(100.dp)
                .border(border = BorderStroke(1.dp, Color.Black)),
            contentAlignment = Alignment.Center

        ) {
            Text(text = "Create\nyour perfect nickname", textAlign = TextAlign.Center)
        }
        Spacer(modifier = Modifier.size(10.dp))

        ///////////////////////
        Box(
            modifier = Modifier
                .size(280.dp, 100.dp)
                .align(CenterHorizontally)
        ) {
            ButtonWithImages(
                "text",
                listOf(R.drawable.rec_101, R.drawable.rec_101_1),
                Modifier
                    .align(Center)
                    .size(280.dp, 100.dp),
                onClick = { testClickToast(context) }
            )
            IconForButton(
                listOf(
                    R.drawable.ic_view_01_yellow_button_icon,
                    R.drawable.ic_view_01_yellow_button_icon_pen
                ),
                Modifier
                    .align(BiasAlignment(-0.75f, -0.05f))
                    .size(50.dp, 50.dp)
            )

        }

        ///////////////////////////////

        Spacer(modifier = Modifier.size(10.dp))

        Box(
            modifier = Modifier
                .size(280.dp, 100.dp)
                .align(CenterHorizontally)
        ) {
            ButtonWithImages(
                "text",
                listOf(
                    R.drawable.rec_101, R.drawable.rec_101_1
                ),
                Modifier
                    .align(Center)
                    .size(280.dp, 100.dp),
                onClick = { testClickToast(context) }
            )
            IconForButton(
                listOf(
                    R.drawable.ic_view_01_yellow_button_icon,
                    R.drawable.ic_view_01_yellow_button_icon_pen
                ),
                Modifier
                    .align(BiasAlignment(-0.75f, -0.05f))
                    .size(50.dp, 50.dp)
            )
        }
        Spacer(modifier = Modifier.size(10.dp))

        // element
        Box(
            modifier = Modifier
                .size(280.dp, 100.dp)
                .align(CenterHorizontally)
        ) {
            ButtonWithImages(
                "text",
                listOf(
                    R.drawable.rec_101, R.drawable.rec_101_1
                ),
                Modifier
                    .align(Center)
                    .size(280.dp, 100.dp),
                onClick = { testClickToast(context) }
            )
            IconForButton(
                listOf(
                    R.drawable.ic_view_01_yellow_button_icon,
                    R.drawable.ic_view_01_yellow_button_icon_pen
                ),
                Modifier
                    .align(BiasAlignment(-0.75f, -0.05f))
                    .size(50.dp, 50.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NickCreator1 { }
}

fun testClickToast(context: Context) {
    Toast.makeText(context, "its clicked", Toast.LENGTH_SHORT).show()
}
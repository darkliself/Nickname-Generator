package com.example.composetest2

import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.composetest2.ui.theme.NickCreator1


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
            Modifier
                .width(280.dp)
                .height(100.dp)
                .border(border = BorderStroke(1.dp, Color.Black))
                .align(CenterHorizontally),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "some text here",
                Modifier
                    .zIndex(3F),
                color = Color.Black
            )
            // icon box
            Box(
                Modifier
                    //.background(Color.Black)
                    .size(50.dp, 50.dp)
                    .zIndex(10f)
                    .align(BiasAlignment(-0.75f, -0.05f)),
                Alignment.Center

            ) {
                Image(
                    ImageVector.vectorResource(id = R.drawable.ic_view_01_yellow_button_icon),
                    "icon",
                    Modifier
                        .fillMaxSize(1f)
                        .zIndex(1f)
                )
                Image(
                    ImageVector.vectorResource(id = R.drawable.ic_view_01_yellow_button_icon_pen),
                    "icon",
                    Modifier
                        .fillMaxSize(0.5f)
                        .zIndex(2f)
                )
            }

            Image(
                ImageVector.vectorResource(id = R.drawable.rec_101),
                "some description",
                Modifier
                    .size(280.dp, 180.dp)
                    .zIndex(2f)
                    .padding(bottom = 5.dp, end = 5.dp)
                    .clickable {
                        testClickToast(context)
                    }
            )
            Image(
                ImageVector.vectorResource(id = R.drawable.rec_101_1), "bk_101",
                Modifier
                    .size(300.dp, 180.dp)
                    .zIndex(1f)
                    .padding(top = 5.dp, start = 5.dp)
            )
        }


        ///////////////////////////////


        Spacer(modifier = Modifier.size(10.dp))
        Box(
            Modifier
                .fillMaxWidth()
                .height(100.dp)
                .border(border = BorderStroke(1.dp, Color.Black)),
            contentAlignment = Alignment.Center
        ) {

            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    "some text here",
                    Modifier
                        .zIndex(3F)
                        .padding(bottom = 5.dp, end = 5.dp),
                    color = Color.Black
                )
                Image(
                    ImageVector.vectorResource(id = R.drawable.rec_101),
                    "some description",
                    Modifier
                        .size(300.dp, 180.dp)
                        .zIndex(2f)
                        .padding(bottom = 5.dp, end = 5.dp)
                        .clickable {
                            testClickToast(context)
                        }
                )
                Image(
                    ImageVector.vectorResource(id = R.drawable.rec_101_1), "bk_101",
                    Modifier
                        .size(300.dp, 180.dp)
                        .zIndex(1f)
                        .padding(top = 5.dp, start = 5.dp)
                )
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

            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    "some text here",
                    Modifier
                        .zIndex(3F)
                        .padding(bottom = 5.dp, end = 5.dp),
                    color = Color.Black
                )
                Image(
                    ImageVector.vectorResource(id = R.drawable.rec_101),
                    "some description",
                    Modifier
                        .size(300.dp, 180.dp)
                        .zIndex(2f)
                        .padding(bottom = 5.dp, end = 5.dp)
                        .clickable {
                            testClickToast(context)
                        }
                )
                Image(
                    ImageVector.vectorResource(id = R.drawable.rec_101_1), "bk_101",
                    Modifier
                        .size(300.dp, 180.dp)
                        .zIndex(1f)
                        .padding(top = 5.dp, start = 5.dp)
                )
            }
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
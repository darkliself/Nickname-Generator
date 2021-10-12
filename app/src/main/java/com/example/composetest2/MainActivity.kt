package com.example.composetest2

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.VectorPainter
import androidx.compose.ui.res.painterResource
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
            Header("Create your perfect nickname")

        }
    }
}

@Composable
fun Header(str: String) {


    fun fromPxToDp(px: Float): Float {
        val density = Resources.getSystem().displayMetrics.density
        return px / density;
    }

    Column(
        Modifier
            .fillMaxSize()
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
        Box(
            Modifier
                .fillMaxWidth()
                .height(100.dp)
                .border(border = BorderStroke(1.dp, Color.Black)),
            contentAlignment = Alignment.Center

        ) {

            Text(text = "Create\nyour perfect nickname", textAlign = TextAlign.Center)

        }
        Box(
            Modifier
                .fillMaxWidth()
                .height(100.dp)
                .border(border = BorderStroke(1.dp, Color.Black)),
            contentAlignment = Alignment.Center
        ) {

            Button(onClick = { /*TODO*/ }) {
                Image(
                    painter = painterResource(R.drawable.icon),
                    contentDescription = "ok icon",
                    Modifier.size(20.dp, 20.dp)
                )
                Text("some simple text")
            }
        }
        Box(
            Modifier
                .fillMaxWidth()
                .height(100.dp)
                .border(border = BorderStroke(1.dp, Color.Black)),
            contentAlignment = Alignment.Center
        ) {

            Button(onClick = { /*TODO*/ }) {
                Image(
                    painter = painterResource(R.drawable.icon),
                    contentDescription = "ok icon",
                    Modifier.size(20.dp, 20.dp)
                )
                Text("some simple text")
            }
        }

        Box(
            Modifier
                .fillMaxWidth()
                .height(100.dp)
                .border(border = BorderStroke(1.dp, Color.Black)),
            contentAlignment = Alignment.Center
        ) {

            Button(onClick = { /*TODO*/ }) {
                Image(
                    painter = painterResource(R.drawable.icon),
                    contentDescription = "ok icon",
                    Modifier.size(20.dp, 20.dp)
                )
                Text("some simple text")
            }

        }
        Box(
            Modifier
                .fillMaxWidth()
                .height(100.dp)
                .border(border = BorderStroke(1.dp, Color.Black)),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = { /*TODO*/ },
                Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            ) {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("jhdjhsf", Modifier.zIndex(2F))
                    Image(
                        ImageVector.vectorResource(id = R.drawable.ic_rec_101),
                        "some description",
                        Modifier
                            .size(180.dp, 75.dp)
                            .zIndex(1f)
                    )
                    Image(
                        ImageVector.vectorResource(id = R.drawable.ic_rec_101_1), "bk_101",
                        Modifier
                            .size(200.dp, 80.dp)
                            .zIndex(0f)

                    )
                }

            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NickCreator1 { }
}
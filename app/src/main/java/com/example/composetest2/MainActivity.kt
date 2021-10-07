package com.example.composetest2

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    Column(
        Modifier
            .fillMaxSize()
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.2f)
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
        Row(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.2f)
                .border(border = BorderStroke(1.dp, Color.Black)),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Create\nyour perfect nickname", textAlign = TextAlign.Center)
        }
        Row(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.2f)
                .border(border = BorderStroke(1.dp, Color.Black)), Arrangement.Center
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
        Row(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.2f)
                .border(border = BorderStroke(1.dp, Color.Black)), Arrangement.Center
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
        Row(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.2f)
                .border(border = BorderStroke(1.dp, Color.Black)),

            Arrangement.Center,

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
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NickCreator1 { }
}
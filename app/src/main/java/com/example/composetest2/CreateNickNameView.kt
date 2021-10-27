package com.example.composetest2

import android.util.Log
import androidx.compose.foundation.BorderStroke

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetest2.ui.theme.MenuButton
import com.example.composetest2.ui.theme.TextBox

@Composable
fun CreateNickNameView() {
    var t by remember { mutableStateOf("some some") }
    Box(
        Modifier.fillMaxSize()
    ) {
        Header()
        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.85f)
                .align(BiasAlignment(0f, 0.6f))
            //.clip(RoundedCornerShape(50.dp))
            //.background(Color(0xffE9F3D6))
            //.border(BorderStroke(1.dp, color = Color.Black))
        ) {
            Surface(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize(),
                border = BorderStroke(2.dp, Color.Black),
                //contentColor = Color.Blue,
                elevation = 8.dp,
                shape = RoundedCornerShape(60.dp),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Red)
                ) {
                    Surface(
                        Modifier
                            .fillMaxWidth(0.9f)
                            .fillMaxHeight(0.2f)
                            .align(Alignment.Center),
                                border = BorderStroke(2.dp, Color.Black),
                        shape = RoundedCornerShape(60.dp)
                    ) {
                        TextField(
                            value = t,
                            onValueChange = {
                                t = it
                            },
                            Modifier
                                .align(Alignment.Center)
                                .background(Color.Blue)
                                .border(1.dp, Color.Black),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                // backgroundColor = Color.Red
                            )
                        )
                    }

                }

//                OutlinedTextField(
//                    value = t,
//                    onValueChange = {
//                        t = it
//                    },
//                    Modifier
//                        .align(Alignment.Center)
//                        .background(Color.Red),
//                    colors = TextFieldDefaults.outlinedTextFieldColors(
//                        // backgroundColor = Color.Red
//                    )
//                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    CreateNickNameView()
}

@Composable
private fun Header() {
    Box(
        Modifier
            .fillMaxHeight(0.1f)
            .fillMaxWidth()
    ) {
        MenuButton(modifier = Modifier
            .align(BiasAlignment(0f, 0f))
            .fillMaxHeight()
            .fillMaxWidth(0.9f),
            iconModifier = Modifier
                .align(Alignment.CenterEnd)
                .clickable {
                    Log.i(">>>>>>>>>>>>>>>>>", "its here")
                }
        )
        TextBox(
            "Create custom nickname",
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight()
                .align(BiasAlignment(0f, 0f))
        )
    }
}

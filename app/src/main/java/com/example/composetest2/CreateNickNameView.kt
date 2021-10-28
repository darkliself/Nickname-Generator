package com.example.composetest2


import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
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
                        .background(Color(0xFFE7F2D7))
                ) {
                    Surface(
                        Modifier
                            .fillMaxWidth(0.9f)
                            .fillMaxHeight(0.15f)
                            .align(BiasAlignment(0f, -0.5f)),
                        border = BorderStroke(2.dp, Color.Black),
                        shape = RoundedCornerShape(30.dp),

                        ) {
                        Box(
                            Modifier.fillMaxSize()
                        ) {
                            BasicTextField(
                                value = t,
                                onValueChange = {
                                    t = it
                                },
                                Modifier
                                    .align(Alignment.Center)
                                    .border(0.dp, Color.White),
                                textStyle = TextStyle(
                                    textAlign = TextAlign.Center
                                )
                            )
                        }
                    }

                    Box(
                        Modifier
                            .fillMaxWidth(0.9f)
                            .fillMaxHeight(0.2f)
                            .align(BiasAlignment(0f, 0f))
                    ) {
                        Image(
                            ImageVector.vectorResource(id = R.drawable.view_02_btn_create),
                            null,
                            Modifier.fillMaxSize()
                        )
                    }
                }


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

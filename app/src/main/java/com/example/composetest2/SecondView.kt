package com.example.composetest2

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import com.example.composetest2.components.ButtonWithImage

@Composable
fun SecondView(contex: Context) {
    val t = LocalContext.current.resources.displayMetrics.heightPixels.dp /
            LocalContext.current.resources.displayMetrics.density
    var size by remember { mutableStateOf("") }
    val t2 = Dimensions
    Image(
        ImageVector.vectorResource(id = R.drawable.bg_category_view),
        contentDescription = null,
        Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
    Column(
        Modifier
            .fillMaxSize().onGloballyPositioned { coordinates ->
                size = coordinates.size.toSize().toString()
            }

        ) {
        Row(
            Modifier
                .fillMaxWidth()
                .height(100.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(t.toString(), Modifier.align(CenterVertically))
        }
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            ButtonWithImage(
                "some text",
                R.drawable.btn_green,
                Modifier.size(170.dp, 100.dp),
                textModifier = Modifier
                    .padding(0.dp)
                    .rotate(-3f)

            ) {

            }
            Spacer(modifier = Modifier.size(10.dp))
            ButtonWithImage(
                "some text",
                R.drawable.btn_pink,
                Modifier.size(170.dp, 100.dp),
                textModifier = Modifier
                    .padding(0.dp)
                    .rotate(3f)
            ) {

            }
        }
    }
}
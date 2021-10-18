package com.example.composetest2

import android.content.Context
import android.graphics.drawable.VectorDrawable
import androidx.annotation.Dimension
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
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.composetest2.components.ButtonWithImage

@Composable
fun SecondView(contex: Context) {

    var size by remember {
        mutableStateOf("")
    }
    Image(
        ImageVector.vectorResource(id = R.drawable.bg_category_view),
        contentDescription = null,
        Modifier
            .fillMaxSize()
            .onGloballyPositioned { coordinates ->
                // This will be the size of the Column.
                size = coordinates.size.toString()
                // The position of the Column relative to the application window.
                coordinates.positionInWindow()
                // The position of the Column relative to the Compose root.
                coordinates.positionInRoot()
                // These will be the alignment lines provided to the layout (empty here for Column).
                coordinates.providedAlignmentLines
                // This will a LayoutCoordinates instance corresponding to the parent of Column.
                coordinates.parentLayoutCoordinates
            },
        contentScale = ContentScale.FillBounds
    )
    Column(
        Modifier
            .fillMaxSize(),

        ) {
        Row(
            Modifier
                .fillMaxWidth()
                .height(100.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(size, Modifier.align(CenterVertically))
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
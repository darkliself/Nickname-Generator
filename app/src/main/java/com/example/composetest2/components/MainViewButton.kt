package com.example.composetest2.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.composetest2.testClickToast

//@Composable
//fun MainViewButton(
//    text: String,
//    @DrawableRes iconId: List<Int>,
//    iconModifier: Modifier
//) {
//    Box(
//        Modifier
//            .fillMaxWidth()
//            .height(100.dp)
//            .border(border = BorderStroke(1.dp, Color.Black)),
//        contentAlignment = Alignment.Center
//    ) {
//
//        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//            Text(
//                text = text,
//                Modifier
//                    .zIndex(3F)
//                    .padding(bottom = 5.dp, end = 5.dp),
//                color = Color.Black
//            )
//            // icon box
//            Icon(iconId, iconModifier)
//            Image(
//                ImageVector.vectorResource(id = R.drawable.rec_101),
//                "some description",
//                Modifier
//                    .size(300.dp, 180.dp)
//                    .zIndex(2f)
//                    .padding(bottom = 5.dp, end = 5.dp)
//                    .clickable {
//
//                    }
//            )
//            Image(
//                ImageVector.vectorResource(id = R.drawable.rec_101_1), "bk_101",
//                Modifier
//                    .size(300.dp, 180.dp)
//                    .zIndex(1f)
//                    .padding(top = 5.dp, start = 5.dp)
//            )
//        }
//    }
//}

@Composable
@Note("You need to 2 elements in list for icon, first is background and second is center of the icon, its temporary until designer make normal icons")
fun Icon(
    @DrawableRes iconId: List<Int>,
    modifier: Modifier,

    ) {
    Box(
        modifier = modifier,
        Alignment.Center

    ) {
        Image(
            ImageVector.vectorResource(id = iconId[0]),
            "icon ${iconId.toString()}",
            Modifier
                .fillMaxSize()
                .zIndex(1f)
        )
        Image(
            ImageVector.vectorResource(id = iconId[1]),
            "background",
            Modifier
                .fillMaxSize(0.5f)
                .zIndex(2f)
        )
    }
}

fun buttonImage() {

}

annotation class Note(val explain: String)
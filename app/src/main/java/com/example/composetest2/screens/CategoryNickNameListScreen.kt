package com.example.composetest2

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composetest2.components.*
import com.example.composetest2.navigation.Screen

/*
    View 06
*/

@ExperimentalAnimationApi
@Composable
fun CategoryNickNameListScreen(navController: NavController, category: String?) {
    val category = category ?: ""
    Background(R.drawable.view_06_07_bg)

    Box(
        Modifier.fillMaxSize(),
    ) {
        SmallButton(
            modifier = Modifier
                .align(Alignment.TopStart),
            image = R.drawable.arrow_left_icon,
            onClick = { navController.navigate(Screen.CategoriesScreen.route) }
        )
        Header(
            "Category name \"$category\"",
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.1f)
                .align(Alignment.TopCenter)
        )
        // Filter buttons
        Row(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.07f)
                .align(BiasAlignment(0f, -0.8f))
        ) {
            Spacer(modifier = Modifier.width(10.dp))

            RoundedButton("ALL", onClick = { println("ALL") })

            Spacer(modifier = Modifier.width(10.dp))

            RoundedButton("NEW", onClick = { println("NEW") })

            Spacer(modifier = Modifier.width(10.dp))

            RoundedButton("POPULAR", onClick = { println("POPULAR") })
        }
        LazyColumn(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
                .padding(start = 20.dp)
                .align(BiasAlignment(-0.8f, 0.7f)),
            //horizontalAlignment = BiasAlignment.Horizontal(0f)
        ) {
            items(20) { index ->
                LazyColumnItem(text = "Item: $index")
            }
        }
    }
}

//@ExperimentalAnimationApi
//@Preview (showBackground = true)
//@Composable
//private fun Preview() {
//    CategoryNickNameListScreen("category", NavController(LocalContext.current))
//}



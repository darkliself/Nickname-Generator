package com.example.textstyler


import android.util.Log
import android.view.GestureDetector
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.changedToDown
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.textstyler.components.*
import com.example.textstyler.model.screendata.ScreenData
import com.example.textstyler.navigation.Screen
import com.example.textstyler.util.*

/*
    View 07
 */


@ExperimentalFoundationApi
@Composable
fun DecorationScreen(navController: NavController, data: ScreenData) {
    val nicknameRoot by remember {
        mutableStateOf(
            TextStyler.rebuildToString(
                data.rootAsCodeList,
                data.alphabetIndex
            )
        )
    }
    var prefix by remember { mutableStateOf(data.prefix) }
    var suffix by remember { mutableStateOf(data.suffix) }
    var nicknameDemo by remember { mutableStateOf("$prefix$nicknameRoot$suffix") }
    val decoration = if (data.side == DecorationSide.LEFT)
        DecorationSorting.sort(DecorationLeft)
    else DecorationSorting.sort(DecorationRight)
    var decorationIndex by remember { mutableStateOf(0) }
    var selectedItems by remember { mutableStateOf(decoration[decorationIndex]) }
    var columnCount by remember { mutableStateOf(1) }
    val isItemSelected by remember { mutableStateOf(mutableListOf<Color>()) }
    var buttonsState by remember { mutableStateOf(mutableListOf(true, false, false)) }
    repeat(selectedItems.count()) {
        isItemSelected.add(Color.White)
    }

    // change buttons colors
    buttonsState = changeButtonColorsState(columnCount, buttonsState)

    BackHandler() {
        navController.currentBackStackEntry?.savedStateHandle?.set("data", data)
        navController.navigate(Screen.CustomizeNickNameScreen.route)
    }

    Background(image = R.drawable.view_06_07_bg)

    Box(
        Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                // detecting swipe
                var startOffsetX = 0F
                var endOffsetX = 0F
                detectHorizontalDragGestures(
                    onDragStart = {
                        startOffsetX = it.x
                    },
                    onDragEnd = {
                        if (startOffsetX > endOffsetX) {
                            if (decorationIndex < 2) {
                                val iterator = isItemSelected.listIterator()
                                while (iterator.hasNext()) {
                                    if (iterator.next() == Color.Green) {
                                        iterator.set(Color.White)
                                    }
                                }
                                //selectedItems = decoration[++decorationIndex]
                                decorationIndex++
                                columnCount++
                                selectedItems = decoration[decorationIndex]
                            }
                        }
                        if (startOffsetX < endOffsetX) {
                            if (decorationIndex > 0) {
                                val iterator = isItemSelected.listIterator()
                                while (iterator.hasNext()) {
                                    if (iterator.next() == Color.Green) {
                                        iterator.set(Color.White)
                                    }
                                }
                                //selectedItems = decoration[--decorationIndex]
                                decorationIndex--
                                columnCount--
                                selectedItems = decoration[decorationIndex]
                            }
                        }
                    }
                ) { change, _ ->
                    // change.consumeAllChanges()
                    endOffsetX = change.position.x
                }
            },
    ) {
        SmallButton(
            modifier = Modifier
                .align(Alignment.TopStart),
            image = R.drawable.arrow_left_icon,
            onClick = {
                navController.currentBackStackEntry?.savedStateHandle?.set("data", data)
                navController.navigate(Screen.CustomizeNickNameScreen.route)
            }
        )
        Header(
            text = "Select ${data.side.toString().lowercase()} decoration",
            modifier = Modifier.align(Alignment.TopCenter)
        )
        TransparentTextField(
            text = "$prefix$nicknameRoot$suffix",
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.1f)
                .clip(RoundedCornerShape(30.dp))
                .border(1.dp, Color(0XFFE7F2D7), RoundedCornerShape(30.dp))
                .align(BiasAlignment(0f, -0.8f)),
            backgroundColor = Color.White,
            readOnly = true
        )
        // Filter buttons
        Row(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.07f)
                .align(BiasAlignment(0f, -0.55f))
        ) {
            Spacer(modifier = Modifier.width(10.dp))
            RoundedButton("ALL", onClick = { println("ALL") })
            Spacer(modifier = Modifier.width(10.dp))
            RoundedButton("NEW", onClick = { println("NEW") })
            Spacer(modifier = Modifier.width(10.dp))
            RoundedButton("POPULAR", onClick = { println("POPULAR") })
        }
        LazyVerticalGrid(
            cells = GridCells.Fixed(columnCount),
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f)
                .align(BiasAlignment(0f, 1f))
        ) {
            items(selectedItems.count()) { index ->
                DecorationScreenItem(
                    text = selectedItems[index],
                    onClick = {
                        if (data.side == DecorationSide.LEFT) {
                            prefix = selectedItems[index]
                            nicknameDemo = "${selectedItems[index]}$nicknameRoot$suffix"
                        } else {
                            suffix = selectedItems[index]
                            nicknameDemo = "$prefix$nicknameRoot${selectedItems[index]}"
                        }
                        // write data
                        data.root = nicknameRoot
                        data.prefix = prefix
                        data.suffix = suffix
                        // highlight item
                        val iterator = isItemSelected.listIterator()
                        while (iterator.hasNext()) {
                            if (iterator.next() == Color.Green) {
                                iterator.set(Color.White)
                            }
                        }
                        isItemSelected[index] = Color.Green
                    },
                    colored = isItemSelected[index]
                )
            }
        }
        Row(
            Modifier
                .fillMaxWidth(0.7f)
                .padding(bottom = 20.dp)
                .align(
                    Alignment.BottomCenter
                ),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            CircularNavButton(
                onClick = {
                    if (decorationIndex != 0) {
                        removeFocusFromItems(isItemSelected)
                        decorationIndex = 0
                        // selectedItems = decoration[decorationIndex]
                        columnCount = 1
                        selectedItems = decoration[decorationIndex]
                    }
                },
                buttonsState[0]
            )
            CircularNavButton(
                onClick = {
                    if (decorationIndex != 1) {
                        removeFocusFromItems(isItemSelected)
                        decorationIndex = 1
                        // selectedItems = decoration[decorationIndex]
                        columnCount = 2
                        selectedItems = decoration[decorationIndex]
                    }
                },
                buttonsState[1]
            )
            CircularNavButton(
                onClick = {
                    if (decorationIndex != 2) {
                        removeFocusFromItems(isItemSelected)
                        decorationIndex = 2
                        // selectedItems = decoration[decorationIndex]
                        columnCount = 3
                        selectedItems = decoration[decorationIndex]
                    }

                },
                buttonsState[2]
            )
        }
    }
}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
private fun Preview() {
    DecorationScreen(
        NavController(LocalContext.current),
        ScreenData("Some", rootNode = "", alphabetIndex = 0)
    )
}

@Composable
fun DecorationScreenItem(
    onClick: () -> Unit,
    text: String,
    colored: Color
) {
    Card(
        backgroundColor = colored,
        modifier = Modifier
            .padding(bottom = 10.dp)
            .height(35.dp)
            .clickable {
                onClick()
            },
    ) {
        Text(text, textAlign = TextAlign.Center)
    }
}


@Composable
fun CircularNavButton(
    onClick: () -> Unit,
    selected: Boolean
) {
    var color by remember { mutableStateOf(Color.Green) }
    color = if (!selected) {
        Color(0XFFDEAEA0)
    } else {
        Color(0XFFABC639)
    }
    Box(
        Modifier
            .size(30.dp)
            .clip(RoundedCornerShape(30.dp))
            .background(Color.Black.copy(0.2f))
            .border(
                5.dp,
                color,
                RoundedCornerShape(30.dp)
            )
            .clickable {
                onClick()
            }
    )
}

private fun changeButtonColorsState(item: Int, test: MutableList<Boolean>): MutableList<Boolean> {
    val iterator = test.listIterator()
    while (iterator.hasNext()) {
        if (iterator.next()) {
            iterator.set(false)
        }
    }
    test[item - 1] = true
    return test
}

private fun removeFocusFromItems(itemsList: MutableList<Color>) {
    val iterator = itemsList.listIterator()
    while (iterator.hasNext()) {
        if (iterator.next() == Color.Green) {
            iterator.set(Color.White)
        }
    }
}
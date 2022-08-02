package com.example.nickname_generator.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.nickname_generator.util.generateAvatarURL

@Composable
fun LottiAvatar(modifier: Modifier, nickname: String, @DrawableRes icon: Int, onClick: () -> Unit) {
    val composition by rememberLottieComposition(
        //LottieCompositionSpec.Url(generateAvatarURL(nickname))
        LottieCompositionSpec.Url("https://api.minimalavatars.com/lottie/alex")
    )
    Box(
        modifier = modifier
            .fillMaxWidth(0.43f)
            .fillMaxHeight(0.27f)
            .clickable {
                onClick()
            },
    ) {
        Image(
            ImageVector.vectorResource(id = icon),
            null,
            Modifier.fillMaxSize()
        )
        LottieAnimation(
            composition = composition,
            modifier = Modifier
                .fillMaxSize(0.75f)
                .align(BiasAlignment(-0.2f, 0f)),
            iterations = 3
        )
    }
}

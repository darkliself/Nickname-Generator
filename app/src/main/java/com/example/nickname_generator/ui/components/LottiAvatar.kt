package com.example.nickname_generator.ui.components

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.util.AttributeSet
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.AbstractComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.airbnb.lottie.LottieImageAsset
import com.airbnb.lottie.LottieProperty
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionResult
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.nickname_generator.BuildConfig
import com.example.nickname_generator.R
import com.example.nickname_generator.util.generateAvatarURL
import com.vips.jetcapture.utils.ImageUtils
import com.vips.jetcapture.utils.ShareUtils
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


private var jetCaptureView: MutableState<ProfileCardView>? = null

@Composable
fun LottiAvatar(
    modifier: Modifier,
    nickname: String,
    @DrawableRes icon: Int,
    onClick: () -> Unit,
) {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.Url(generateAvatarURL(nickname))
        //LottieCompositionSpec.Url("https://api.minimalavatars.com/lottie/${nickname}")
    )

    Box(
        modifier = modifier
            .fillMaxWidth(0.43f)
            .fillMaxHeight(0.27f)
            .clickable {
                onClick()
                jetCaptureView?.value?.capture(jetCaptureView?.value as ProfileCardView, nickname)
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

@Composable
fun ProfileUI(nickname: String) {
    val context = LocalContext.current
    jetCaptureView = remember {
        mutableStateOf(
            ProfileCardView(context)
        )
    }
    AndroidView(modifier = Modifier.wrapContentSize(),
        factory = {
            ProfileCardView(it).apply {
                this.nickname = nickname
                post {
                    jetCaptureView?.value = this
                }
            }
        }
    )
}


class ProfileCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : AbstractComposeView(context, attrs, defStyleAttr) {
    var nickname by mutableStateOf("")

    @Composable
    override fun Content() {
//        val secondaryText by currentValue.collectAsState()
        LottiAvatar(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.3f),
            nickname = nickname,
            icon = R.drawable.view_04_autogenerate_icon,
            onClick = {
            }
        )
    }

    fun capture(view: ProfileCardView, text: String) {
        val bitmap = ImageUtils.generateShareImage(view)
        ShareUtils.shareImageToOthers(context,
            "Hey! Check this cool nickname - $text\nThat I've generated in this Nickname Generator App - https://play.google.com/store/apps/details?id=${BuildConfig.APPLICATION_ID}",
            bitmap)
    }

}

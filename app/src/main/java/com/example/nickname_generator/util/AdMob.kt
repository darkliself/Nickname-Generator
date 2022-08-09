package com.example.nickname_generator

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.util.Log
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

var mInterstitialAd: InterstitialAd? = null

fun loadInterstitial(context: Context) {
    val mobAdId = if (BuildConfig.DEBUG) "ca-app-pub-3940256099942544/1033173712" else context.getString(R.string.interstitial)
    InterstitialAd.load(
        context,
        mobAdId,
        AdRequest.Builder().build(),
        object : InterstitialAdLoadCallback() {
            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                mInterstitialAd = interstitialAd
                Log.d("Admob", "onAdLoaded: Ad was loaded.")
            }
            override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                mInterstitialAd = null
                Log.d("Admob", "onAdFailedToLoad: ${loadAdError.message}")
            }
        }
    )
}

fun addInterstitialCallbacks(context: Context) {
    mInterstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
        override fun onAdDismissedFullScreenContent() {
            Log.d("Admob", "onAdDismissedFullScreenContent: Ad was dismissed")
        }
        override fun onAdFailedToShowFullScreenContent(p0: AdError) {
            Log.d("Admob", "onAdFailedToShowFullScreenContent: Ad failed to show")
        }
        override fun onAdShowedFullScreenContent() {
            mInterstitialAd = null
            loadInterstitial(context)
            Log.d("Admob", "onAdShowedFullScreenContent: Ad showed fullscreen content.")
        }
    }
}

fun showInterstitial(context: Context) {
    val activity = context.findActivity()
    if (mInterstitialAd != null) {
        mInterstitialAd?.show(activity!!)
    } else {
        Log.d("Admob", "showInterstitial: The interstitial ad wasn't ready yet.")
    }
}

fun Context.findActivity(): Activity? = when(this) {
    is Activity -> this
    is ContextWrapper -> baseContext.findActivity()
    else -> null
}
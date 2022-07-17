package com.example.nickname_generator.util

import kotlin.math.abs

fun generateAvatarURL(nickname: String): String {
    var nicknameCode = nickname.hashCode().toString()
    var itaration = 0
    while (nicknameCode.length < 16) {
        nicknameCode = ((abs(nicknameCode.toLong()) * 12).toString())
        itaration++
        if (itaration > 20) {
            break
        }
    }
    while (nicknameCode.length > 16) {
        nicknameCode = ((abs(nicknameCode.toLong()) / 10).toString())
    }
    val codeArray = nicknameCode.chunked(2)
    val base = getItemCode(codeArray[0].toInt(), AvatarsData.base)
    val eyes = getItemCode(codeArray[1].toInt(), AvatarsData.eyes)
    val hair = getItemCode(codeArray[2].toInt(), AvatarsData.hair)
    val mouth = getItemCode(codeArray[3].toInt(), AvatarsData.mouth)
    val baseColor = AvatarsData.colorsList[getItemCode(codeArray[4].toInt(), 37)]
    val baseColorId = getItemCode(codeArray[4].toInt(), 37)
    val hairColor = AvatarsData.colorsList[getItemCode(codeArray[5].toInt(), 37, baseColorId)]
    val eyesColor = AvatarsData.colorsList[getItemCode(codeArray[6].toInt(), 37, baseColorId)]
    val mouthColor = AvatarsData.colorsList[getItemCode(codeArray[7].toInt(), 37, baseColorId)]
    return "https://api.minimalavatars.com/lottie?" +
            "base=$base" +
            "&eyes=$eyes" +
            "&hair=$hair" +
            "&mouth=$mouth" +
            "&baseColor=$baseColor" +
            "&hairColor=$hairColor" +
            "&eyesColor=$eyesColor" +
            "&mouthColor=$mouthColor"
}

private fun getItemCode(num: Int, itemsInList: Int, baseColorId: Int = -1): Int {
    // base color Id must be unique
    val step = 100 / itemsInList
    var range = 0
    var result = 0
    while (num >= range) {
        range += step
        result++
        if (result == itemsInList) {
            break
        }
    }
    if (baseColorId == result) {
        return if (baseColorId == itemsInList) {
            baseColorId - 1
        } else {
            baseColorId + 1
        }
    }
    return result
}

private object AvatarsData {
    const val base = 5
    const val hair = 11
    const val eyes = 9
    const val mouth = 11
    val colorsList = listOf(
        "%23FF966A",
        "%23FF5668",
        "%23FFEA71",
        "%2307C7AE",
        "%23FC264C",
        "%232B1039",
        "%23426EB7",
        "%23EFC636",
        "%23F4D19E",
        "%23352C21",
        "%23C68F46",
        "%23A66EE6",
        "%234F2789",
        "%2356FCB1",
        "%238CF4EC",
        "%2300BBF2",
        "%23007A5E",
        "%23a4de02",
        "%231e5631",
        "%234c9a2a",
        "%235A4CA4",
        "%23161C46",
        "%23BAC1E3",
        "%237D205E",
        "%23D1205E",
        "%237DF45E",
        "%23B36DD4",
        "%2361269B",
        "%23542e71",
        "%23fb3640",
        "%23fdca40",
        "%23ffc93c",
        "%2331326f",
        "%234aa54e",
        "%2376FFBA",
        "%231D4F7C",
        "%2329D3A2",
        "%23f573ff",
    )
}
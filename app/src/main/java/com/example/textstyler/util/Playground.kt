package com.example.textstyler.util

import kotlin.math.abs


fun main(args: Array<String>) {
    generateURLMinimalAvatar("hello motherfucker")
    generateURLMinimalAvatar("hello motherfucker1")
    generateURLMinimalAvatar("h")
    generateURLMinimalAvatar("h")
    val testList = listOf<List<String>>(

    )

    for (i in 1..1000) {
        generateURLMinimalAvatar("hello motherfucker$i")
    }
}

fun generateURLMinimalAvatar(nickname: String): String {
    var nicknameCode = nickname.hashCode().toString()
    // https://api.minimalavatars.com/lottie?base=0&eyes=1&hair=0&mouth=9&baseColor=%237d205e&hairColor=%23f573ff&eyesColor=%23f573ff&mouthColor=%23f573ff
    // 8 params
    var itaration = 0
    while (nicknameCode.length < 16) {
        nicknameCode = ((abs(nicknameCode.toLong()) * 12).toString())
        // println(t)
        itaration++
        if (itaration > 20) {
            break
        }
    }
    while (nicknameCode.length > 16) {
        nicknameCode = ((abs(nicknameCode.toLong()) / 10).toString())
    }
    val codeArray = nicknameCode.chunked(2)
    // println(codeArray)
    val base = getItemCode(codeArray[0].toInt(), AvatarsData.base)
    val eyes = getItemCode(codeArray[1].toInt(), AvatarsData.eyes)
    val hair = getItemCode(codeArray[2].toInt(), AvatarsData.hair)
    val mouth = getItemCode(codeArray[3].toInt(), AvatarsData.mouth)
    val baseColor = AvatarsData.colorsList[getItemCode(codeArray[4].toInt(), 40)] // example : %23007A5E
    val hairColor = AvatarsData.colorsList[getItemCode(codeArray[4].toInt(), 40)]
    val eyesColor = AvatarsData.colorsList[getItemCode(codeArray[4].toInt(), 40)]
    val mouthColor = AvatarsData.colorsList[getItemCode(codeArray[4].toInt(), 40)]
    println(nicknameCode)
    return "https://api.minimalavatars.com/lottie?base=$base&eyes=$eyes&hair=$hair&mouth=$mouth&baseColor=$baseColor&hairColor=$hairColor&eyesColor=$eyesColor&mouthColor=$mouthColor"
}

private fun getItemCode(num: Int, itemsInList: Int): Int {
    val step = 100 / itemsInList
    var range = 0
    var result = 0
    while (num >= range ) {
        range += step
        result++
        if (result == itemsInList) {
            break
        }
    }
    // println(" generated number is $num and result is $result and step is $step items in list $itemsInList")
    return result
}

private object AvatarsData {
    val base = 5
    val hair = 11
    val eyes = 9
    val mouth = 11
    val colorsList = listOf(
        "%23FF966A",
        "%23FF5668",
        "%23FFEA71",
        "%2307C7AE",
        "%23FC264C",
        "%23F7FFF7",
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
        "%237d205e",
        "%23f573ff",
        "%23f573ff",
    )
}
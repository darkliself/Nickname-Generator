package com.example.composetest2.logic

import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.N)
fun main(args: Array<String>) {
    val t = TextStyler("s")
//    val z = t.rootToUnicode("AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz1234567890", 1)
//    t.rootToUnicode("Random Nickname", 1)


//    println(t.getCharIndex("s", 0))

    fun splitByCodePoint(str: String): Array<String> {
        val codepoints = str.codePoints().toArray()
        return Array(codepoints.size) { index ->
            String(codepoints, index, 1)
        }
    }
//    println(t.splitByCodePoint("Random Nickname"))

    val z1 = t.splitToArrayByIndexes("ARandom Hello!", 0)
    println(z1)
    println(t.rebuildToString(z1, 0))
    println(t.rebuildToString(z1, 1))
}

/*
    Main class where all logic
    For now its all for tests
 */

class TextStyler(var text: String = "") {
    private var result = ""
    private var prefix = ""
    private var suffix = ""
    private var root = ""
    private var baseAlphabet = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz1234567890"
    private val unicodeAlphabetList = AlphabetList

    fun getAlphabetCount(): Int {
        return AlphabetList.count()
    }

    fun rootToUnicode(inputText: String, unicodeAlphabetIndex: Int): String {
        var text = ""
        inputText.forEach {
            if (baseAlphabet.contains(it)) {
                text += unicodeAlphabetList[unicodeAlphabetIndex][baseAlphabet.indexOf(it)]
            } else {
                text += it
            }
        }
        root = text
        return switchToUnicode()
    }

    /**
    // codepoint mb don't work with lower android API versions/ must be rebuild using suffix and prefix
     */
//    @RequiresApi(Build.VERSION_CODES.N)
//    fun splitByCodePoint(str: String): Array<String> {
//        val codepoints = str.codePoints().toArray()
//        return Array(codepoints.size) { index ->
//            String(codepoints, index, 1)
//        }
//    }

    fun splitToArrayByIndexes(input: String, alphabetIndex: Int): List<String> {
        val result = mutableListOf<String>()
        input.forEach {
            val str = it.toString()
            if (unicodeAlphabetList[alphabetIndex].indexOf(str) > -1) {
                // println(unicodeAlphabetList[alphabetIndex].indexOf(str))
                result.add("pre${unicodeAlphabetList[alphabetIndex].indexOf(str)}")
            } else {
                // println(str)
                result.add(str)
            }
        }
        return result
    }

    fun rebuildToString(codeList: List<String>, alphabetIndex: Int): String {
        var result = ""
        codeList.forEach {
            if (it.startsWith("pre")) {
                result += unicodeAlphabetList[alphabetIndex][it.replace("pre", "").toInt()]
                // println(unicodeAlphabetList[alphabetIndex][it.replace("pre", "").toInt()])
            } else {
                result += it
                // println(it)
            }
        }
        return result.toString()
    }

    fun switchToUnicode(): String {
        return "$prefix$root$suffix"
    }
}


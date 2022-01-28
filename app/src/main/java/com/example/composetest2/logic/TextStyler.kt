package com.example.composetest2.logic

import android.os.Build
import androidx.annotation.RequiresApi
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets

@RequiresApi(Build.VERSION_CODES.N)
fun main(args: Array<String>) {
    val t = TextStyler("s")
    val z = t.rootToUnicode("AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz1234567890", 1)
    t.rootToUnicode("Random Nickname", 1)

    println(t.getCharIndex("s", 0))

    fun splitByCodePoint(str: String): Array<String> {
        val codepoints = str.codePoints().toArray()
        return Array(codepoints.size) { index ->
            String(codepoints, index, 1)
        }
    }
    println(t.splitByCodePoint("Random Nickname"))
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
    // codepiont mb dont work with lower android API versions/ must be rebuild using suffix and prefix
     */
    @RequiresApi(Build.VERSION_CODES.N)
    fun splitByCodePoint(str: String): Array<String> {
        val codepoints = str.codePoints().toArray()
        return Array(codepoints.size) { index ->
            String(codepoints, index, 1)
        }
    }

    fun getBaseChar(index: Int): String {
        return baseAlphabet[index].toString()
    }

    fun getCharIndex(char: String, alphabetIndex: Int): Int {
        return unicodeAlphabetList[alphabetIndex].indexOf(char)
    }

    fun switchToUnicode(): String {
        return "$prefix$root$suffix"
    }
}


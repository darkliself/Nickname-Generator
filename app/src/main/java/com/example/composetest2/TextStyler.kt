package com.example.composetest2

import android.icu.text.UnicodeFilter
import android.media.MediaCodec
import android.os.Build
import androidx.annotation.RequiresApi
import java.util.regex.Pattern

@RequiresApi(Build.VERSION_CODES.N)
fun main(args: Array<String>) {
    val t = TextStyler("s")
    t.switchToUnicode("AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz1234567890", 0)
    t.switchToUnicode("AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYy", 1)
    t.switchToUnicode("jghfdjghdf", 1)
}



class TextStyler(var text: String = "") {
    private val baseAlphabet = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz1234567890"
    private val unicodeAlphabetList = AlphabetList

    fun getAlphabetCount(): Int {
        return AlphabetList.count()
    }
    fun switchToUnicode(inputText: String, unicodeAlphabetIndex: Int): String {
        var output = ""
        inputText.forEach {
            output += unicodeAlphabetList[unicodeAlphabetIndex][baseAlphabet.indexOf(it)]
        }
        println(output)
        return output
    }
}


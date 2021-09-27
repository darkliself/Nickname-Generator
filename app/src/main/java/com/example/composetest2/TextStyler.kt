package com.example.composetest2

fun main(args: Array<String>) {
    val t = TextStyler("s")
    t.rootToUnicode("AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz1234567890", 0)
    t.rootToUnicode("AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYy", 1)
    t.rootToUnicode("jghfdjghdf", 1)
}

/*
    Main class where all logic
 */

class TextStyler(var text: String = "") {
    private var result = ""
    private var prefix = ""
    private var suffix = ""
    private var root = ""

    private val baseAlphabet = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz1234567890"
    private val unicodeAlphabetList = AlphabetList

    fun getAlphabetCount(): Int {
        return AlphabetList.count()
    }

    fun rootToUnicode(inputText: String, unicodeAlphabetIndex: Int): String {
        inputText.forEach {
            if (baseAlphabet.contains(it)) {
                root += unicodeAlphabetList[unicodeAlphabetIndex][baseAlphabet.indexOf(it)]
            } else {
                root += it
            }
        }
        return switchToUnicode()
    }
    fun addPrefix(): String {
        prefix += "<"
        return switchToUnicode()
    }
    fun addSuffix(): String {
        suffix += ">"
        return switchToUnicode()
    }
    fun switchToUnicode(): String {
        return "$prefix$root$suffix"
    }
}


package com.example.textstyler.util

import com.example.textstyler.model.AlphabetList

object TextStyler {
    private val unicodeAlphabetList = AlphabetList

    fun getAlphabetCount(): Int {
        return AlphabetList.count()
    }

    fun splitToArrayByIndexes(input: String, alphabetIndex: Int): List<String> {
        val result = mutableListOf<String>()
        input.forEach {
            val str = it.toString()
            if (unicodeAlphabetList[alphabetIndex].indexOf(str) > -1) {
                result.add("pre${unicodeAlphabetList[alphabetIndex].indexOf(str)}")
            } else {
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
            } else {
                result += it
            }
        }
        return result
    }
}


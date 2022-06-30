package com.example.textstyler.util

object DecorationSorting {
    fun sort(str: List<String>): MutableList<MutableList<String>> {
        val result = mutableListOf(
            mutableListOf<String>(),
            mutableListOf<String>(),
            mutableListOf<String>(),
        )
        val z = str.sortedBy { it -> it.length }
        var deltaLength = 0
//        val numberOfElements = str.count()
        var min = 0;
        var mid = 0;
        var max = 0
        z.forEach {
            if (it.length > 11) {
                result[0].add(it)
                max++
                println(it)
            } else if (it.length > 7) {
                result[1].add(it)
                mid++
            } else {
                result[2].add(it)
                min++
            }
            deltaLength += it.length
        }
        return result
    }
}
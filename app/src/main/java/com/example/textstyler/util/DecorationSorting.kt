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
        z.forEach {
            if (it.length > 11) {
                result[0].add(it)
                // println(it)
            } else if (it.length > 7) {
                result[1].add(it)
            } else {
                result[2].add(it)
            }
            deltaLength += it.length
        }
        return result
    }
}
package com.example.nickname_generator.util

object DecorationSorting {
    fun sort(str: List<String>): MutableList<MutableList<String>> {
        val result = mutableListOf(
            mutableListOf<String>(),
            mutableListOf(),
            mutableListOf(),
        )
        val z = str.sortedBy { it.length }
        var deltaLength = 0
        z.forEach {
            if (it.length > 11) {
                result[0].add(it)
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
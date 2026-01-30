package common

fun List<List<Int>>.makeSorted(): List<List<Int>> {
    val slices = this
        .groupBy { list -> list.size }
        .toSortedMap()

    return slices.entries.map { (_, lists) ->
        sortSimilarSizeLists(lists)
    }.flatten()
}

fun sortSimilarSizeLists(lists: List<List<Int>>): List<List<Int>> {
    return lists.sortedWith { a, b ->
        for (i in a.indices) {
            val cmp = a[i].compareTo(b[i])
            if (cmp != 0) return@sortedWith cmp
        }

        0
    }
}

fun List<Int>.splitToPairs(): List<List<Int>> {
    val result = mutableListOf<List<Int>>()

    for (i in 0 until this.size step 2) {
        result.add(listOf(get(i), get(i + 1)))
    }

    return result
}

fun List<List<Int>>.toArrays(): Array<IntArray> {
    return this
        .map { it.toIntArray() }
        .toTypedArray()
}

fun List<List<Int>>.toListOfPairs(): List<Pair<Int, Int>> {
    return this.map { Pair(it[0], it[1]) }
}

fun List<Pair<Int, Int>>.toArrayOfIntArrays(): Array<IntArray> {
    return this.map { intArrayOf(it.first, it.second) }
        .toTypedArray()
}
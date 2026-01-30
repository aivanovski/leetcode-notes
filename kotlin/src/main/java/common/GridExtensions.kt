package common

fun String.toGrid(): Grid<Char> {
    val chars = this
        .replace("|", "")
        .split("\n")
        .filter { line -> line.isNotBlank() }
        .map { line ->
            line.trim().toCharArray().toList()
        }

    return Grid(chars)
}

fun Grid<Char>.toCharArrays(): Array<CharArray> {
    return this.data
        .map { line -> line.toCharArray() }
        .toTypedArray()
}

fun Grid<Char>.toIntArrays(): Array<IntArray> {
    return this.data
        .map { line ->
            line
                .map { ch -> ch.toString().toInt() }
                .toIntArray()
        }
        .toTypedArray()
}
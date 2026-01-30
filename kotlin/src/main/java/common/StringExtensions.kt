package common

fun String.asGrid(): Array<CharArray> {
    return this
        .toGrid()
        .toCharArrays()
}

fun String.filterNumbers(): List<Int> {
    return this
        .map { ch ->
            if (ch.isDigit() || ch == '-') {
                ch
            } else {
                ' '
            }
        }
        .joinToString(separator = "")
        .split(" ")
        .filter { it.isNotBlank() }
        .map { value -> value.toInt() }
}

fun String.toGraphNodes(): Node? {
    val edges = this
        .replace("],[", ";")
        .split(";")
        .map { connections ->
            connections.filterNumbers()
        }

    return edges.toNodeGraph()
}

fun String.toTwoDimensionalList(): List<List<Int>> {
//    [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    return this
        .replace("[[", "[")
        .replace("]]", "]")
        .split("],")
        .map { line ->
            line.replace("[", "")
                .replace("]", "")
                .split(",")
                .filter { it.trim().isNotEmpty() }
                .map { it.trim().toInt() }
        }
}

fun String.toListOfPairs(): List<Pair<Int, Int>> {
    if (isEmpty()) return emptyList()
//    [3,3],[5,-1],[-2,4]
    return this
        .split("],")
        .mapNotNull { line ->
            val values = line.replace("[", "")
                .replace("]", "")
                .split(",")
                .filter { it.trim().isNotEmpty() }
                .map { it.trim().toInt() }
            if (values.isNotEmpty()) {
                Pair(values[0], values[1])
            } else {
                null
            }
        }
}
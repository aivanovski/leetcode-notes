package common

class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList<Node?>()

    override fun toString(): String {
        return "Node($`val`, neighbours=${neighbors.map { it?.`val` }})"
    }
}
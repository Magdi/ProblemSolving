package leetcode.google

import java.util.*

class Problem329 {
    private val di = listOf(0, 0, -1, 1)
    private val dj = listOf(1, -1, 0, 0)

    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        if (matrix.isEmpty() || matrix[0].isEmpty()) return 0
        val n = matrix.size
        val m = matrix[0].size
        val queue = PriorityQueue<Node>()
        matrix.forEachIndexed { i, row ->
            row.forEachIndexed { j, cell ->
                queue.add(Node(cell, i, j))
            }
        }
        var max = 1
        val ans = Array(n) { IntArray(m) { 1 } }
        while (queue.isNotEmpty()) {
            val node = queue.poll()
            (0..3).forEach { d ->
                val ni = node.x + di[d]
                val nj = node.y + dj[d]
                if (ni in 0 until n && nj in 0 until m && matrix[ni][nj] > matrix[node.x][node.y]) {
                    ans[node.x][node.y] = Math.max(ans[node.x][node.y], ans[ni][nj] + 1)
                    max = Math.max(max, ans[node.x][node.y])
                }
            }
        }
        return max
    }

    private data class Node(val value: Int, val x: Int, val y: Int) : Comparable<Node> {
        override fun compareTo(other: Node): Int {
            return other.value.compareTo(value)
        }
    }
}

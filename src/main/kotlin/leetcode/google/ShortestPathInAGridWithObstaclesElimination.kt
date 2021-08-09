package leetcode.google

import java.util.*

class ShortestPathInAGridWithObstaclesElimination {
    private val di = listOf(1, -1, 0, 0)
    private val dj = listOf(0, 0, 1, -1)

    fun shortestPath(grid: Array<IntArray>, k: Int): Int {
        val n = grid.size
        val m = grid[0].size
        val startState = State(0, 0, k)
        val queue: Queue<State> = LinkedList()
        queue.offer(startState)
        val visited = hashMapOf<State, Int>()
        visited[startState] = 0
        var level = 0
        while (queue.isNotEmpty()) {
            val q = queue.size
            for (p in 0 until q) {
                val cur = queue.poll()
                if (cur.x == n - 1 && cur.y == m - 1) {
                    return level
                }
                for (d in 0..3) {
                    val nx = cur.x + di[d]
                    val ny = cur.y + dj[d]
                    if (nx in 0 until n && ny in 0 until m) {
                        val nState = State(nx, ny, cur.remainingElimination - grid[nx][ny])
                        if (nState.remainingElimination >= 0 && !visited.contains(nState)) {
                            queue.offer(nState)
                            visited[nState] = level
                        }
                    }
                }
            }
            level++
        }
        return -1
    }

    data class State(val x: Int, val y: Int, val remainingElimination: Int)
}
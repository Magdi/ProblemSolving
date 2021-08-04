package leetcode

import java.util.*

/**
 * https://leetcode.com/problems/sliding-puzzle/
 *
 *
 *BFS O(N) N = number of valid states to the puzzle
 */
class SlidingPuzzle {
    fun slidingPuzzle(board: Array<IntArray>): Int {
        val initBoard = Board(listOf(1, 2, 3, 4, 5, 0))
        val q: Queue<Board> = LinkedList()
        q.offer(initBoard)
        var level = 0
        val visited = hashMapOf<Board, Int>()
        while (q.size > 0) {
            val n = q.size
            for (i in 0 until n) {
                val cur = q.poll()
                visited[cur] = level
                cur.getMoves().forEach { newBoard ->
                    if (!visited.contains(newBoard)) {
                        q.offer(newBoard)
                    }
                }
            }
            level++
        }
        return visited[board.toBoard()] ?: -1
    }

    fun Array<IntArray>.toBoard(): Board {
        val list = mutableListOf<Int>()
        this.forEach {
            it.forEach { num ->
                list.add(num)
            }
        }
        return Board(list)
    }

    data class Board(private val grid: List<Int>) {

        private val adjMap = mapOf(
            0 to listOf(1, 3),
            1 to listOf(0, 2, 4),
            2 to listOf(1, 5),
            3 to listOf(0, 4),
            4 to listOf(3, 5, 1),
            5 to listOf(2, 4)
        )

        fun getMoves(): List<Board> {
            val zeroInd = grid.indexOf(0)
            val result = mutableListOf<Board>()
            adjMap[zeroInd]!!.map { adj ->
                val newGrid = grid.toMutableList()
                newGrid[zeroInd] = grid[adj]
                newGrid[adj] = 0
                result.add(Board(newGrid))
            }
            return result
        }
    }
}
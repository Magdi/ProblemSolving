package leetcode.mock

import org.junit.Assert.*
import org.junit.Test

class MockInterview13Test {
    @Test
    fun `test case 1`() {
        assertEquals(3, MockInterview13.minimumDistance("CAKE"))
        assertEquals(6, MockInterview13.minimumDistance("HAPPY"))
    }
}

object MockInterview13 {
    fun trimMean(arr: IntArray): Double {
        arr.sort()
        val remove = arr.size / 20
        var sum = 0.0
        for (i in remove until arr.size - remove) {
            sum += arr[i].toDouble()
        }
        return sum / (arr.size - (2 * remove))
    }


    fun restoreMatrix(rowSum: IntArray, colSum: IntArray): Array<IntArray> {
        val n = rowSum.size
        val m = colSum.size
        val res = Array(n) { IntArray(m) }
        for (i in 0 until n) {
            for (j in 0 until m) {
                val min = Math.min(rowSum[i], colSum[j])
                res[i][j] = min
                rowSum[i] -= min
                colSum[j] -= min
            }
        }
        return res
    }

    fun minimumDistance(word: String): Int {
        val positions = word.map { it.toPoint() }
        return getMin(0, Point.FREE_POINT, Point.FREE_POINT, positions, HashMap())
    }

    private fun getMin(ind: Int, p1: Point, p2: Point, points: List<Point>, cache: HashMap<State, Int>): Int {
        if (ind == points.size) return 0
        val state = State(ind, p1.id, p2.id)
        if (cache.containsKey(state)) return cache[state]!!
        val target = points[ind]
        val min = Math.min(
            p1.move(target) + getMin(ind + 1, target, p2, points, cache),
            p2.move(target) + getMin(ind + 1, p1, target, points, cache)
        )
        cache[state] = min
        return min
    }

    private data class State(val ind: Int, val id1: Int, val id2: Int)

    private data class Point(val id: Int, val r: Int, val c: Int) {
        fun move(p: Point): Int {
            if (p == FREE_POINT || this == FREE_POINT) {
                return 0
            }
            return Math.abs(r - p.r) + Math.abs(c - p.c)
        }

        companion object {
            val FREE_POINT = Point(-1, 20, 20)
        }
    }

    private fun Char.toPoint(): Point {
        val id = this - 'A'
        val row = id / 6
        val col = id % 6
        return Point(id, row, col)
    }

}
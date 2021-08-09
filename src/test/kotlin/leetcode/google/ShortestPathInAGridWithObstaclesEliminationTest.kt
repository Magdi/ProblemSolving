package leetcode.google

import org.junit.Test

import org.junit.Assert.*

class ShortestPathInAGridWithObstaclesEliminationTest {

    @Test
    fun `test case 1`() {
        val result = ShortestPathInAGridWithObstaclesElimination().shortestPath(
            arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(1, 1, 0),
                intArrayOf(0, 0, 0),
                intArrayOf(0, 1, 1),
                intArrayOf(0, 0, 0),
            ),
            1
        )
        assertEquals(6, result)
    }

    @Test
    fun `test case 2`() {
        val result = ShortestPathInAGridWithObstaclesElimination().shortestPath(
            arrayOf(
                intArrayOf(0, 1, 1),
                intArrayOf(1, 1, 1),
                intArrayOf(1, 0, 0),
            ),
            1
        )
        assertEquals(-1, result)
    }
}
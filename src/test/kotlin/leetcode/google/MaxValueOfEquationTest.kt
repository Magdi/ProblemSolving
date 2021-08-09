package leetcode.google

import org.junit.Test

import org.junit.Assert.*

class MaxValueOfEquationTest {

    @Test
    fun `test case 1`() {
        assertEquals(
            4,
            MaxValueOfEquation().findMaxValueOfEquation(
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(2, 0),
                    intArrayOf(5, 10),
                    intArrayOf(6, -10),
                ), 1
            )
        )
    }

    @Test
    fun `test case 2`() {
        assertEquals(
            3,
            MaxValueOfEquation().findMaxValueOfEquation(
                arrayOf(
                    intArrayOf(0, 0),
                    intArrayOf(3, 0),
                    intArrayOf(9, 2),
                ), 3
            )
        )
    }
}
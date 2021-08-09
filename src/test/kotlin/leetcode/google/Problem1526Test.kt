package leetcode.google

import org.junit.Test

import org.junit.Assert.*

class Problem1526Test {

    @Test
    fun `test case 1`() {
        val result = Problem1526().minNumberOperations(
            intArrayOf(1, 2, 3, 2, 1)
        )
        assertEquals(3, result)
    }


    @Test
    fun `test case 2`() {
        val result = Problem1526().minNumberOperations(
            intArrayOf(3, 1, 1, 2)
        )
        assertEquals(4, result)
    }

    @Test
    fun `test case 3`() {
        val result = Problem1526().minNumberOperations(
            intArrayOf(3, 1, 5, 4, 2)
        )
        assertEquals(7, result)
    }

    @Test
    fun `test case 4`() {
        val result = Problem1526().minNumberOperations(
            intArrayOf(1, 1, 1, 1)
        )
        assertEquals(1, result)
    }

    @Test
    fun `test case 5`() {
        val result = Problem1526().minNumberOperations(
            intArrayOf(10)
        )
        assertEquals(10, result)
    }

    @Test
    fun `test case 6`() {
        val result = Problem1526().minNumberOperations(
            intArrayOf(10, 0)
        )
        assertEquals(10, result)
    }

    @Test
    fun `test case 7`() {
        val result = Problem1526().minNumberOperations(
            intArrayOf(0, 10)
        )
        assertEquals(10, result)
    }


    @Test
    fun `test case 8`() {
        val result = Problem1526().minNumberOperations(
            intArrayOf(1, 2, 3, 4, 5, 6, 1)
        )
        assertEquals(6, result)
    }

    @Test
    fun `test case 9`() {
        val result = Problem1526().minNumberOperations(
            intArrayOf(1, 2, 3, 4, 5, 6, 1, 5)
        )
        assertEquals(10, result)
    }


}
package leetcode.facebook

import org.junit.Test

import org.junit.Assert.*

class Problem560Test {

    @Test
    fun `test case 1`() {
        assertEquals(2, Problem560().subarraySum(intArrayOf(1,1,1), 2))
    }

    @Test
    fun `test case 2`() {
        assertEquals(2, Problem560().subarraySum(intArrayOf(-1,0,1), 0))
    }

    @Test
    fun `test case 3`() {
        assertEquals(2, Problem560().subarraySum(intArrayOf(1,2,3), 3))
    }
}
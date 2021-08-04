package leetcode

import leetcode.uber.RestoreTheArrayFromAdjacentPairs
import org.junit.Test

import org.junit.Assert.*

class RestoreTheArrayFromAdjacentPairsTest {

    @Test
    fun `test case 1`() {
        val res = RestoreTheArrayFromAdjacentPairs().restoreArray(
            arrayOf(
                intArrayOf(2,1),
                intArrayOf(3,4),
                intArrayOf(3,2)
            )
        )
        assertArrayEquals(intArrayOf(4,3,2,1), res)
    }
}
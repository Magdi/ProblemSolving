package leetcode.google

import org.junit.Test

import org.junit.Assert.*

class NumberofGoodWaystoSplitStringTest {

    @Test
    fun `test case 1`() {
        assertEquals(2, NumberofGoodWaystoSplitString().numSplits("aacaba"))
    }

    @Test
    fun `test case 2`() {
        assertEquals(1, NumberofGoodWaystoSplitString().numSplits("abcd"))
    }

    @Test
    fun `test case 3`() {
        assertEquals(4, NumberofGoodWaystoSplitString().numSplits("aaaaa"))
    }
    @Test
    fun `test case 4`() {
        assertEquals(2, NumberofGoodWaystoSplitString().numSplits("acbadbaada"))
    }

    @Test
    fun `test case 5`() {
        assertEquals(0, NumberofGoodWaystoSplitString().numSplits("a"))
    }

    @Test
    fun `test case 6`() {
        assertEquals(1, NumberofGoodWaystoSplitString().numSplits("ab"))
    }
}
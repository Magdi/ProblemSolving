package leetcode.google

import org.junit.Test

import org.junit.Assert.*

class LongestStringChainTest {

    @Test
    fun `test case 1`() {
        assertEquals(
            4,
            LongestStringChain.longestStrChain(arrayOf("a", "b", "ba", "bca", "bda", "bdca"))
        )
    }

    @Test
    fun `test case 2`() {
        assertEquals(
            5,
            LongestStringChain.longestStrChain(arrayOf("xbc","pcxbcf","xb","cxbc","pcxbc"))
        )
    }

    @Test
    fun `test case 3`() {
        assertEquals(
            1,
            LongestStringChain.longestStrChain(arrayOf("abcd","dbqca"))
        )
    }
}
package leetcode.google

import org.junit.Test

import org.junit.Assert.*

class Problem792Test {

    @Test
    fun `test case 1`() {
        assertEquals(
            3,
            Problem792().numMatchingSubseq("abcde", arrayOf("a", "bb", "acd", "ace"))
        )
    }

    @Test
    fun `test case 2`() {
        assertEquals(
            2,
            Problem792().numMatchingSubseq("dsahjpjauf", arrayOf("ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"))
        )
    }

    @Test
    fun `test case 3`() {
        assertEquals(
            2,
            Problem792().numMatchingSubseq("btovxbkumc", arrayOf("btovxbku", "zueoxxxjme", "to", "yjkclbkbtl"))
        )
    }

    @Test
    fun `test case 4`() {
        assertEquals(
            0,
            Problem792().numMatchingSubseq("abvb", arrayOf("avbb", "zueoxxxjme", "to", "yjkclbkbtl"))
        )
    }
}

class Problem792_S2Test {

    @Test
    fun `test case 1`() {
        assertEquals(
            3,
            Problem792_S2().numMatchingSubseq("abcde", arrayOf("a", "bb", "acd", "ace"))
        )
    }

    @Test
    fun `test case 2`() {
        assertEquals(
            2,
            Problem792_S2().numMatchingSubseq("dsahjpjauf", arrayOf("ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"))
        )
    }

    @Test
    fun `test case 3`() {
        assertEquals(
            2,
            Problem792_S2().numMatchingSubseq("btovxbkumc", arrayOf("btovxbku", "zueoxxxjme", "to", "yjkclbkbtl"))
        )
    }

    @Test
    fun `test case 4`() {
        assertEquals(
            0,
            Problem792_S2().numMatchingSubseq("abvb", arrayOf("avbb", "zueoxxxjme", "to", "yjkclbkbtl"))
        )
    }
}
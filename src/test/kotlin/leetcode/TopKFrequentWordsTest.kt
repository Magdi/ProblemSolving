package leetcode

import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class TopKFrequentWordsTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun test() {
        val words = arrayOf("the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is")
        val k = 4

        val expectResult = listOf("the", "is", "sunny", "day")
        assertEquals(expectResult, TopFrequentWords().topKFrequent(words, k))
    }

    @Test
    fun `test case 2`() {
        val words = arrayOf("i", "love", "leetcode", "i", "love", "coding")
        val k = 2

        val expectResult = listOf("i", "love")
        assertEquals(expectResult, TopFrequentWords().topKFrequent(words, k))
    }
}
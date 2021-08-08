package leetcode.google

import java.util.*
import kotlin.collections.HashMap


/**
 * O ( N * W ) N number of words, W is length of word
 */
object LongestStringChain {

    fun longestStrChain(words: Array<String>): Int {
        words.sortBy { it.length }
        val dp = HashMap<String, Int>()
        var max = 1
        words.forEach { word ->
            var cur = 1
            for (j in word.indices) {
                val temp = StringBuilder(word)
                temp.deleteCharAt(j)
                cur = Math.max(cur, 1 + dp.getOrDefault(temp.toString(), 0))
            }
            dp[word] = cur
            max = Math.max(cur, max)
        }
        return max
    }
}
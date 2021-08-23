package leetcode.mock

import org.junit.Assert
import org.junit.Test


class MockIInterview8Test {
    @Test
    fun `test case 1`() {
        Assert.assertTrue(MockIInterview8().queryString("0110", 3))
        Assert.assertTrue(MockIInterview8().queryString("0110", 3))
        Assert.assertTrue(MockIInterview8().queryString("1111000101", 5))
        Assert.assertFalse(MockIInterview8().queryString("10010111100001110010", 10))
    }
    @Test
    fun `test case 2`() {
        Assert.assertEquals(12, MockIInterview8().largestValsFromLabels(
            intArrayOf(5,4,3,2,1),
            intArrayOf(1,3,3,3,2),
            3,
            2
        ))
    }
}

class MockIInterview8 {
    fun findOcurrences(text: String, first: String, second: String): Array<String> {
        val words = text.split(" ")
        val ans = ArrayList<String>()
        for (i in 0 until words.size - 2) {
            if (words[i] == first && words[i + 1] == second) {
                ans.add(words[i + 2])
            }
        }
        return ans.toTypedArray()
    }

    fun queryString(s: String, n: Int): Boolean {
        val cur = HashSet<Int>()
        for (size in 1..Math.min(s.length, 32)) {
            var window = StringBuilder(s.substring(0, size))
            toInt(window.toString()).run {
                if (this in 1..n) cur.add(this)
            }
            for (i in size until s.length) {
                window.append(s[i])
                window = StringBuilder(window.substring(1))
                toInt(window.toString()).run {
                    if (this in 1..n) cur.add(this)
                }
            }
        }
        println(cur)
        return cur.size >= n
    }

    private fun toInt(binary: String): Int {
        var ans = 0
        binary.reversed().forEachIndexed { index, c ->
            if (c == '1') {
                ans = ans or (1 shl index)
            }
        }
        return ans
    }


    fun largestValsFromLabels(values: IntArray, labels: IntArray, numWanted: Int, useLimit: Int): Int {
        val group = HashMap<Int, ArrayList<Int>>()
        values.forEachIndexed { index, _ ->
            val list = group.getOrDefault(labels[index], ArrayList())
            list.add(values[index])
            group[labels[index]] = list
        }
        val options = group.map { (_, list) ->
            list.sortDescending()
            list
        }
        return dp(0, options, numWanted, useLimit, HashMap())
    }

    private fun dp(index: Int, options: List<List<Int>>, numWanted: Int, useLimit: Int, cache: HashMap<Pair<Int,Int>, Int>): Int {
        if (numWanted == 0 || index == options.size) return 0
        val p = Pair(index, numWanted)
        if (cache.containsKey(p)) return cache[p]!!
        var ans = dp(index+1, options, numWanted, useLimit, cache)
        val list = options[index]
        var cur = 0
        for (i in 0 until listOf(list.size, useLimit, numWanted).min()!!) {
            cur += list[i]
            ans = Math.max(ans, cur + dp(index+1, options, numWanted-(i+1), useLimit, cache))
        }
        cache[p] = ans
        return ans
    }

}
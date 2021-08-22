package leetcode.mock

import org.junit.Assert
import org.junit.Test

class MockInterview5 {

    @Test
    fun `test case 1`() {
//        Assert.assertEquals(1, Solution().expressiveWords("heeellooo", arrayOf("hello", "hi", "helo")))
        Assert.assertEquals(0, Solution().expressiveWords("lee", arrayOf("le")))
    }
}

class Solution {
    fun judgeCircle(moves: String): Boolean {
        var x = 0
        var y = 0
        moves.forEach { m ->
            when (m) {
                'U' -> y - 1
                'D' -> y + 1
                'L' -> x - 1
                'R' -> y + 1
            }
        }
        return x == 0 && y == 0
    }

    fun expressiveWords(s: String, words: Array<String>): Int {
        var ans = 0
        val main = decode(s)
        words.forEach {
            val query = decode(it)
            if (main.size == query.size) {
                var found = true
                for (i in main.indices) {
                    if (main[i].first != query[i].first) {
                        found = false
                    }
                    if (main[i].second < 3 && main[i].second != query[i].second) {
                        found = false
                    }
                    if (query[i].second > main[i].second) {
                        found = false
                    }
                }
                if (found) ans++
            }
        }
        return ans
    }

    private fun decode(s: String): List<Pair<Char, Int>> {
        val result = ArrayList<Pair<Char, Int>>()
        var cnt = 1
        for (i in 0..s.lastIndex - 1) {
            if (s[i] != s[i + 1]) {
                result.add(Pair(s[i], cnt))
                cnt = 1
            } else {
                cnt++
            }
        }
        result.add(Pair(s.last(), cnt))
        return result
    }


    fun removeStones(stones: Array<IntArray>): Int {
        val stones = stones.map { (x, y) -> Point(x, y) }
        val f = WeightedUF(stones.size)
        for (i in 0..stones.lastIndex) {
            for (j in i + 1..stones.lastIndex) {
                if (stones[i].x == stones[j].x || stones[i].y == stones[j].y) {
                    f.union(i, j)
                }
            }
        }
        return stones.size - f.components
    }

    class WeightedUF(val n: Int) {
        val parent: Array<Int>
        val weight: Array<Int>
        var components: Int

        init {
            parent = Array(n) { i -> i }
            weight = Array(n) { i -> 1 }
            components = n
        }

        fun find(p: Int): Int {
            var pMutable = p

            while (parent[pMutable] != pMutable) {
                pMutable = parent[pMutable]
            }

            return pMutable
        }

        fun union(p: Int, q: Int) {
            val pRoot = find(p)
            val qRoot = find(q)

            if (pRoot != qRoot) {
                if (weight[pRoot] < weight[qRoot]) {
                    parent[qRoot] = pRoot
                    weight[pRoot] += weight[qRoot]
                } else {
                    parent[pRoot] = qRoot
                    weight[qRoot] += weight[pRoot]
                }

                components--
            }
        }
    }

    data class Point(val x: Int, val y: Int)
}

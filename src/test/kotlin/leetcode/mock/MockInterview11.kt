package leetcode.mock

import org.junit.Assert.*
import org.junit.Test
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class MockInterview11Test {
    @Test
    fun `test case 1`() {
        assertTrue(MockInterview11.isMajorityElement(intArrayOf(2, 4, 5, 5, 5, 5, 5, 5, 6, 6), 5))
    }
}

object MockInterview11 {
    fun isMajorityElement(nums: IntArray, target: Int): Boolean {
        var cnt = 1
        var max = 1
        var number = nums[0]
        for (i in 1..nums.lastIndex) {
            if (nums[i] != nums[i - 1]) {
                cnt = 0
            }
            cnt++
            if (max < cnt) {
                max = cnt
                number = nums[i]
            }
        }
        return number == target && max > nums.size / 2
    }

    fun minAddToMakeValid(s: String): Int {
        var cnt = 0
        var balance = 0
        s.forEach {
            when (it) {
                '(' -> balance++
                ')' -> {
                    if (balance > 0) {
                        balance--
                    } else {
                        cnt++
                    }
                }
            }
        }
        return cnt + balance
    }

    fun numSimilarGroups(strs: Array<String>): Int {
        val graph = Graph()
        for (i in 0 until strs.lastIndex) {
            for (j in i + 1..strs.lastIndex) {
                if (isSimilar(strs[i], strs[j])) {
                    graph.addEdge(i, j)
                }
            }
        }
        val visited = HashSet<Int>()
        var cnt = 0
        for (i in 0..strs.lastIndex) {
            if (!visited.contains(i)) {
                cnt++
                dfs(i, graph, visited)
            }
        }
        return cnt
    }

    private fun dfs(i: Int, graph: Graph, visited: HashSet<Int>) {
        if (visited.contains(i)) {
            return
        }
        visited.add(i)
        graph.getAdj(i).forEach { dfs(it, graph, visited) }
    }

    private class Graph {
        private val map = HashMap<Int, HashSet<Int>>()

        fun getAdj(n: Int): Collection<Int> {
            return map.getOrDefault(n, HashSet())
        }

        fun addEdge(a: Int, b: Int) {
            addAdjNode(a, b)
            addAdjNode(b, a)
        }

        private fun addAdjNode(a: Int, b: Int) {
            val aAdj = map.getOrDefault(a, HashSet())
            aAdj.add(b)
            map[a] = aAdj
        }
    }

    private fun isSimilar(x: String, y: String): Boolean {
        var cnt = 0
        for (i in x.indices) {
            if (x[i] != y[i]) cnt++
        }
        return cnt == 2 || cnt == 0
    }
}
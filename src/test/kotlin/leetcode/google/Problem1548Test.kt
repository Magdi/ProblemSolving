package leetcode.google

import org.junit.Test

import org.junit.Assert.*

class Problem1548Test {

    @Test
    fun `test case 1`() {
        val roads = arrayOf(
            intArrayOf(0, 2),
            intArrayOf(0, 3),
            intArrayOf(1, 2),
            intArrayOf(1, 3),
            intArrayOf(1, 4),
            intArrayOf(2, 4),
        )
        val names = arrayOf("ATL", "PEK", "LAX", "DXB", "HND")
        val targetPath = arrayOf("ATL", "DXB", "HND", "LAX")
        val ans = Problem1548().mostSimilar(
            n = 5,
            roads = roads,
            names = names,
            targetPath = targetPath
        )

        assertEquals(1, minDistance(targetPath, ans.map { names[it] }))

    }

    @Test
    fun `test case 2`() {
        val roads = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
            intArrayOf(4, 5),
        )
        val names = arrayOf("ATL","PEK","LAX","ATL","DXB","HND")
        val targetPath = arrayOf("ATL", "DXB", "HND", "DXB", "ATL", "LAX", "PEK")
        val ans = Problem1548().mostSimilar(
            n = 6,
            roads = roads,
            names = names,
            targetPath = targetPath
        )
        println(targetPath.toList())
        println(ans.map { names[it] })
        assertEquals(0, minDistance(targetPath, ans.map { names[it] }))
    }

    private fun minDistance(list1: Array<String>, list2: List<String>): Int {
        var cnt = 0
        for (i in list1.indices) {
            if (list1[i] != list2[i]) cnt++
        }
        return cnt
    }
}
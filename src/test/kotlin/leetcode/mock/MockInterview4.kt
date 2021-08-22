package leetcode.mock

import com.sun.source.tree.Tree
import org.junit.Assert.*
import org.junit.Test
import java.time.Year


class Tester {
    @Test
    fun `test case 1`() {
        assertEquals(listOf(listOf(0, 2)), MockInterview4().largeGroupPositions("aaa"))
        assertEquals(listOf(listOf(1, 3)), MockInterview4().largeGroupPositions("baaac"))
    }

    @Test
    fun `test case 2`() {
        assertEquals(1, MockInterview4().allPossibleFBT(3).size)
        assertEquals(5, MockInterview4().allPossibleFBT(7).size)
    }

    @Test
    fun `test case 3`() {
        assertEquals(
            24, MockInterview4().cherryPickup(
                arrayOf(
                    intArrayOf(3, 1, 1),
                    intArrayOf(2, 5, 1),
                    intArrayOf(1, 5, 5),
                    intArrayOf(2, 1, 1),
                )
            )
        )
        assertEquals(5, MockInterview4().allPossibleFBT(7).size)
    }
}

class MockInterview4 {
    fun largeGroupPositions(s: String): List<List<Int>> {
        var prev = 0
        val ans = ArrayList<List<Int>>()
        for (i in 0..s.length - 2) {
            if (s[i] != s[i + 1]) {
                if (i - prev >= 2) {
                    ans.add(listOf(prev, i))
                }
                prev = i + 1
            }
        }
        if (s.lastIndex - prev >= 2) {
            ans.add(listOf(prev, s.lastIndex))
        }
        return ans
    }

    fun allPossibleFBT(n: Int): List<TreeNode?> {
        if (n == 0 || n == 2) return emptyList()
        if (n == 1) return listOf(TreeNode(0))
        val ans = ArrayList<TreeNode>()
        for (i in 0 until n - 1) {
            val leftTrees = allPossibleFBT(i)
            val rightTrees = allPossibleFBT(n - i - 1)
            leftTrees.forEach { left ->
                rightTrees.forEach { right ->
                    val parent = TreeNode(0)
                    parent.left = left
                    parent.right = right
                    ans.add(parent)
                }
            }
        }
        return ans
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }


    private var n: Int = 0
    private var m: Int = 0
    private var g: Array<IntArray> = emptyArray()
    fun cherryPickup(grid: Array<IntArray>): Int {
        n = grid.size
        m = grid[0].size
        g = grid
        return max(0, m - 1, 0, HashMap())
    }

    private val adj = arrayOf(-1, 0, +1)

    data class State(val a: Int, val b: Int, val c: Int)

    fun max(x1: Int, x2: Int, y: Int, cache: HashMap<State, Int>): Int {
        if (y == n) {
            return 0
        }
        val state = State(x1,x2, y)
        if (cache.containsKey(state)) return cache[state]!!
        val ans = if (x1 == x2) {
            g[y][x1]
        } else {
            g[y][x1] + g[y][x2]
        }
        var max = 0
        adj.forEach { x1D ->
            adj.forEach { x2D ->
                val nx1 = x1 + x1D
                val nx2 = x2 + x2D
                if (nx1 in 0 until m && nx2 in 0 until m) {
                    max = Math.max(max, max(nx1, nx2, y + 1, cache))
                }
            }
        }
        cache[state] = ans + max
        return ans + max
    }

}
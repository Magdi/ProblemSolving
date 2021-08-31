package leetcode.mock

import org.junit.Assert.*
import org.junit.Test
import java.lang.StringBuilder

class MockInterview16Test {
    @Test
    fun `test case 1`() {

    }
}

object MockInterview16 {
    fun groupStrings(strings: Array<String>): List<List<String>> {
        return strings.groupBy { normalize(it) }.values.toList()
    }

    private fun normalize(s: String): String {
        val normalized = StringBuilder()
        if (s.isEmpty()) return s
        val diff = 'z' - s[0]
        s.forEach { c ->
            val newC = 'a' + (((c - 'a') + diff) % 26)
            normalized.append(newC)
        }
        return normalized.toString()
    }

    private val di = listOf(1, -1, 0, 0)
    private val dj = listOf(0, 0, 1, -1)

    fun numIslands(grid: Array<CharArray>): Int {
        val n = grid.size
        val m = grid.size
        val visited = HashSet<Point>()

        var cnt = 0
        for (i in 0 until n) {
            for (j in 0 until m) {
                val p = Point(i, j)
                if (grid[i][j] == '1' && !visited.contains(p)) {
                    cnt++
                    dfs(p, grid, visited)
                }
            }
        }
        return cnt
    }

    private fun dfs(p: Point, grid: Array<CharArray>, visited: HashSet<Point>) {
        if (grid[p.i][p.j] == '0') return
        visited.add(p)
        for (d in di.indices) {
            val newPoint = Point(p.i + di[d], p.j + dj[d])
            if (newPoint.isValid(grid.size, grid.first().size) && !visited.contains(newPoint)) {
                dfs(newPoint, grid, visited)
            }
        }
    }

    private data class Point(val i: Int, val j: Int) {
        fun isValid(n: Int, m: Int): Boolean {
            return i in 0 until n && j in 0 until m
        }
    }

    /// problem 4

    // o ( k * lon ( n*m ) )
    fun numIslands2(m: Int, n: Int, positions: Array<IntArray>): List<Int> {
        val unionFind = UnionFind()
        val grid = MutableList(m) { MutableList(n) { 0 } }
        val result = mutableListOf<Int>()
        positions.forEach { (row, col) ->
            if (grid[row][col] != 1) {
                val ind = getIndex(row, col, n)
                grid[row][col] = 1
                unionFind.addTree(ind)
                for (d in 0 until 4) {
                    val nRow = row + di[d]
                    val nCol = col + dj[d]
                    if (nRow >= 0 && nCol >= 0 && nRow < m && nCol < n && grid[nRow][nCol] == 1) {
                        unionFind.union(ind, getIndex(nRow, nCol, n))
                    }
                }
            }
            result.add(unionFind.forests)
        }
        return result
    }

    private fun getIndex(row: Int, col: Int, m: Int): Int {
        return row * m + col
    }

    private class UnionFind {
        val rank = hashMapOf<Int, Int>()
        val parent = hashMapOf<Int, Int>()
        var forests = 0

        fun addTree(node: Int) {
            rank[node] = 1
            parent[node] = node
            forests++
        }

        fun find(node: Int): Int {
            if (node == parent[node]) return node
            return find(parent[node]!!).also { parent[node] = it }
        }

        fun link(node1: Int, node2: Int) {
            var x = node1
            var y = node2
            if (rank[x]!! > rank[y]!!) x = y.also { y = x } // swap
            parent[x] = y
            if (rank[x] == rank[y]) rank[y] = rank.getOrDefault(y, 1) + 1
        }

        fun union(node1: Int, node2: Int) {
            val p1 = find(node1)
            val p2 = find(node2)
            if (p1 != p2) {
                link(p1, p2)
                forests--
            }

        }
    }
}
package leetcode.google

import org.junit.Test

import org.junit.Assert.*


/*
https://leetcode.com/problems/count-square-submatrices-with-all-ones/
 */
class Problem1277 {
    fun countSquares(matrix: Array<IntArray>): Int {
        val n = matrix.size
        val m = matrix.first().size
        val cnt = Array(n + 1) { IntArray(m + 1) { 0 } }
        var ans = 0
        for (i in 1..n) {
            for (j in 1..m) {
                cnt[i][j] = matrix[i - 1][j - 1] + cnt[i - 1][j] + cnt[i][j - 1] - cnt[i - 1][j - 1]
                if (matrix[i - 1][j - 1] == 1) {
                    ans++
                    for (k in 1 until Math.min(i, j)) {
                        if (cnt[i][j] - cnt[i - k - 1][j] - cnt[i][j - k - 1] + cnt[i - k - 1][j - k - 1] == (k + 1) * (k + 1)) {
                            ans++
                        }
                    }
                }
            }
        }
        return ans
    }
}

class Problem1277Test {

    @Test
    fun `test case 1`() {
        assertEquals(
            15, Problem1277().countSquares(
                arrayOf(
                    intArrayOf(0, 1, 1, 1),
                    intArrayOf(1, 1, 1, 1),
                    intArrayOf(0, 1, 1, 1)
                )
            )
        )
    }
}
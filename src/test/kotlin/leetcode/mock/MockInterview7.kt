package leetcode.mock

import org.junit.Assert
import org.junit.Test

class MockInterview7Test {
    @Test
    fun `test case 1`() {
        Assert.assertEquals(
            4, MockInterview7().maximalSquare(
                arrayOf(
                    "10100".toCharArray(),
                    "10111".toCharArray(),
                    "11111".toCharArray(),
                    "10010".toCharArray(),
                )
            )
        )

        Assert.assertEquals(
            1, MockInterview7().maximalSquare(
                arrayOf(
                    "01".toCharArray(),
                    "10".toCharArray(),
                )
            )
        )
    }
}


class MockInterview7 {
    fun isSubsequence(s: String, t: String): Boolean {
        var index = 0
        s.forEach { c ->
            val newIndex = t.indexOf(c, index)
            if (newIndex == -1) return false
            index = newIndex + 1
        }
        return true
    }


    fun maximalSquare(matrix: Array<CharArray>): Int {
        val n = matrix.size
        val m = matrix[0].size
        val sum = Array(n + 1) { IntArray(m + 1) { 0 } }
        for (i in 1..n) {
            for (j in 1..m) {
                val value = if (matrix[i - 1][j - 1] == '1') 1 else 0
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + value
            }
        }
        var start = 0
        var end = m
        while (start < end) {
            val mid = ((start + end) / 2) + 1
            if (findOnes(mid, sum)) {
                start = mid
            } else {
                end = mid - 1
            }
        }
        return start * start
    }

    private fun findOnes(size: Int, sum: Array<IntArray>): Boolean {
        for (i in size until sum.size) {
            for (j in size until sum[0].size) {
                if (sum[i][j] + sum[i - size][j - size] - sum[i - size][j] - sum[i][j - size] == size * size) {
                    return true
                }
            }
        }
        return false
    }

    fun canConvert(str1: String, str2: String): Boolean {
        if (str1 == str2) return true
        if (str1.length != str2.length) return false
        if (str2.toCharArray().toSet().size == 26) return false
        val map = HashMap<Char, Char>()
        str1.forEachIndexed { index, c ->
            if (!map.containsKey(c)) {
                map[c] = str2[index]
            } else if (map[c] != str2[index]) {
                return false
            }
        }
        return true
    }
}
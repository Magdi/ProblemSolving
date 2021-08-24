package leetcode.mock

import org.junit.Assert
import org.junit.Test
import java.util.*


class MockInterview9Test {

    @Test
    fun `test case 1`() {
        Assert.assertEquals("this   is   a   sentence", MockInterview9.reorderSpaces("  this   is  a sentence "))
    }

    @Test
    fun `test case 3`() {
        Assert.assertEquals(3, MockInterview9.confusingNumberII(10))
        Assert.assertEquals(6, MockInterview9.confusingNumberII(20))
        Assert.assertEquals(19, MockInterview9.confusingNumberII(100))
        Assert.assertEquals(19, MockInterview9.confusingNumberII(1000000000))

    }

    @Test
    fun `test case 2`() {
        Assert.assertEquals(
            4, MockInterview9.minSwap(
                intArrayOf(0, 7, 8, 10, 10, 11, 12, 13, 19, 18),
                intArrayOf(4, 4, 5, 7, 11, 14, 15, 16, 17, 20),
            )
        )
        Assert.assertEquals(
            1, MockInterview9.minSwap(
                intArrayOf(0, 3, 5, 8, 9),
                intArrayOf(2, 1, 4, 6, 9),
            )
        )
        Assert.assertEquals(
            1, MockInterview9.minSwap(
                intArrayOf(0, 4, 4, 5, 9),
                intArrayOf(0, 1, 6, 8, 10),
            )
        )
        Assert.assertEquals(
            1, MockInterview9.minSwap(
                intArrayOf(3, 3, 8, 9, 10),
                intArrayOf(1, 7, 4, 6, 8),
            )
        )
        Assert.assertEquals(
            1, MockInterview9.minSwap(
                intArrayOf(3, 7, 8, 9, 8),
                intArrayOf(1, 3, 4, 6, 10),
            )
        )
    }
}

object MockInterview9 {
    fun reorderSpaces(text: String): String {
        val n = text.length
        val words = text.split(" ").filter { it.isNotBlank() }
        val spaces = n - words.sumBy { it.length }
        val res = StringBuilder()
        if (words.size == 1) {
            res.append(words.first())
            res.append(" ".repeat(spaces))
        } else {
            val divider = spaces / (words.size - 1)
            words.forEachIndexed { index, s ->
                if (index != 0) res.append(" ".repeat(divider))
                res.append(s)
            }
            res.append(" ".repeat(spaces % (words.size - 1)))
        }
        return res.toString()
    }

    fun minSwap(nums1: IntArray, nums2: IntArray): Int {
        val n = nums1.size
        val memo = Array(2) { IntArray(n) }
        Arrays.fill(memo[0], -1)
        Arrays.fill(memo[1], -1)
        memo[0][0] = 0
        memo[1][0] = 1
        return Math.min(
            recurse(nums1, nums2, n - 1, 0, memo),
            recurse(nums1, nums2, n - 1, 1, memo)
        );
    }

    private fun recurse(nums1: IntArray, nums2: IntArray, i: Int, swap: Int, memo: Array<IntArray>): Int {
        //check dp table
        if (memo[swap][i] != -1) return memo[swap][i]

        // initial value is set as max
        var res = Int.MAX_VALUE

        // if array is increasing without swapping
        if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) res = recurse(nums1, nums2, i - 1, swap, memo)

        // if array is increasing with swapping
        if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) res = Math.min(
            res,
            recurse(nums1, nums2, i - 1, 1 - swap, memo)
        )
        memo[swap][i] = if (swap == 0) res else res + 1
        return memo[swap][i]
    }

    fun confusingNumberII(n: Int): Int {
        val options = listOf('0', '1', '6', '8', '9')
        return cnt(StringBuilder(), n, options)
    }

    fun cnt(cur: StringBuilder, n: Int, options: List<Char>): Int {
        if (cur.length > 9) {
            return 0
        }
        var ans = 0
        if (cur.isNotEmpty()) {
            val num = cur.toString().toInt()
            if (num > n) {
                return 0
            }
            if (rotate(cur).toInt() != num) {
                ans++
            }
        }
        options.forEach {
            if (cur.isEmpty() && it == '0') {

            } else {
                cur.append(it)
                ans += cnt(cur, n, options)
                cur.deleteCharAt(cur.lastIndex)
            }

        }
        return ans
    }

    private fun rotate(cur: StringBuilder): String {
        val rotate = cur.reversed()
        val res = StringBuilder("")
        rotate.forEach {
            when (it) {
                '6' -> res.append('9')
                '9' -> res.append('6')
                else -> res.append(it)
            }
        }
        return res.toString()
    }

}
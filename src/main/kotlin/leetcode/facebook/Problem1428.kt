package leetcode.facebook

class Problem1428 {
    interface BinaryMatrix {
        fun get(row: Int, col: Int): Int
        fun dimensions(): List<Int>
    }

    fun leftMostColumnWithOne(binaryMatrix: BinaryMatrix): Int {
        val (n, m) = binaryMatrix.dimensions()
        var min = Int.MAX_VALUE
        for (i in 0 until n) {
            val index = search(binaryMatrix, i, m)
            if (index == 0) return 0
            min = Math.min(min, index)
        }
        return if (min == Int.MAX_VALUE) -1 else min
    }

    private fun search(binaryMatrix: BinaryMatrix, row: Int, m: Int): Int {
        var start = 0
        var end = m - 1
        while (start < end) {
            val mid = ((start + end) / 2)
            if (binaryMatrix.get(row, mid) == 1) {
                end = mid
            } else {
                start = mid + 1
            }
        }
        if (binaryMatrix.get(row, start) == 0) return Int.MAX_VALUE
        return start
    }
}
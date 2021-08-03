package leetcode

class RotatingtheBox {
    fun rotateTheBox(box: Array<CharArray>): Array<CharArray> {
        val n = box.size
        if (n == 0) return emptyArray()
        val m = box[0].size
        if (m == 0) return box

        box.map { row ->
            applyGravity(row)
        }

        val newBox = Array(m) {
            CharArray(n)
        }
        for (j in 0 until m) {
            for (i in 0 until n) {
                newBox[j][i] = box[n-i-1][j]
            }
        }
        return newBox
    }

    private fun applyGravity(row: CharArray) {
        var lastSpace = -1
        for (index in row.size - 1 downTo 0) {
            if (row[index] == '.' && lastSpace == -1) {
                lastSpace = index
            } else if (row[index] == '*') {
                lastSpace = -1
            } else if (row[index] == '#' && lastSpace != -1) {
                row[lastSpace] = row[index]
                row[index] = '.'
                lastSpace--
            }
        }
    }
}
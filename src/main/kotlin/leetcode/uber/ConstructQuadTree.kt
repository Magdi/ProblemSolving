package leetcode.uber


class ConstructQuadTree {
    data class Node(
        var `val`: Boolean,
        var isLeaf: Boolean,
    ) {
        var topLeft: Node? = null
        var topRight: Node? = null
        var bottomLeft: Node? = null
        var bottomRight: Node? = null
    }

    fun construct(grid: Array<IntArray>): Node? {
        if (grid.isEmpty()) {
            return null
        }
        return constructQTree(grid, 0, 0, grid.size)
    }

    fun constructQTree(grid: Array<IntArray>, row: Int, col: Int, length: Int): Node {
        if (length == 1) {
            return Node(grid[row][col] == 1, true)
        }
        val mid = length / 2
        val topLeft = constructQTree(grid, row, col, mid)
        val topRight = constructQTree(grid, row, col + mid, mid)
        val bottomLeft = constructQTree(grid, row + mid, col, mid)
        val bottomRight = constructQTree(grid, row + mid, col + mid, mid)
        if (topLeft.`val` == topRight.`val` && topRight.`val` == bottomRight.`val`
            && bottomRight.`val` == bottomLeft.`val` && topRight.isLeaf && topLeft.isLeaf && bottomRight.isLeaf && bottomLeft.isLeaf
        ) {
            return Node(topLeft.`val`, true)
        } else {
            val node = Node(false, false)
            node.topLeft = topLeft
            node.topRight = topRight
            node.bottomRight = bottomRight
            node.bottomLeft = bottomLeft
            return node
        }
    }
}
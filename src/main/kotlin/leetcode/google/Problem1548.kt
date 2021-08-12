package leetcode.google

/**
 * The Most Similar Path in a Graph
 * https://leetcode.com/problems/the-most-similar-path-in-a-graph/
 */
class Problem1548 {
    private val cache = hashMapOf<Pair<Int, Int>, Int>()

    /**
     * Time
     * O ( p * n * n )
     * p: path length
     * n: number of nodes
     *
     * Space
     * O ( p * n )
     */
    fun mostSimilar(n: Int, roads: Array<IntArray>, names: Array<String>, targetPath: Array<String>): List<Int> {
        val nodes = names.mapIndexed { index, name ->
            Node(index, name)
        }
        roads.forEach { (from, to) ->
            nodes[from].adj.add(nodes[to])
            nodes[to].adj.add(nodes[from])
        }
        var min = Int.MAX_VALUE
        var start: Node = nodes[0]
        cache.clear()
        nodes.forEach { startNode ->
            val cur = dp(0, startNode, targetPath)
            if (cur < min) {
                min = cur
                start = startNode
            }
        }
        val result = IntArray(targetPath.size)
        generatePath(start, 0, result)
        return result.asList()
    }

    private fun generatePath(cur: Node, index: Int, results: IntArray) {
        if (index == results.size) return
        results[index] = cur.id
        var minAdj = cur.adj.minBy { cache[Pair(index + 1, it.id)] ?: Int.MAX_VALUE }
        generatePath(minAdj!!, index + 1, results)
    }

    private fun dp(index: Int, cur: Node, targetPath: Array<String>): Int {
        if (index == targetPath.size) {
            return 0
        }
        val key = Pair(index, cur.id)
        if (cache.contains(key)) return cache[key]!!
        var min = Int.MAX_VALUE
        cur.adj.forEach { adjNode ->
            val cost = if (cur.name != targetPath[index]) 1 else 0
            min = Math.min(min, cost + dp(index + 1, adjNode, targetPath))
        }
        cache[key] = min
        return min
    }

    data class Node(
        val id: Int,
        val name: String,
        val adj: MutableList<Node> = mutableListOf()
    )
}
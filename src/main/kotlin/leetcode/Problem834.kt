package leetcode

/**
 * https://leetcode.com/problems/sum-of-distances-in-tree/
 */
class Problem834 {
    private val graph = HashMap<Int, HashSet<Int>>()

    fun sumOfDistancesInTree(n: Int, edges: Array<IntArray>): IntArray {
        edges.forEach { (x, y) ->
            graph.getOrPut(x) { hashSetOf(y) }.apply {
                this.add(y)
            }
            graph.getOrPut(y) { hashSetOf(x) }.apply {
                this.add(x)
            }
        }
        val ans = IntArray(n) { 0 }
        val cnt = IntArray(n) { 1 }
        cntForParent(0, -1, ans, cnt)
        cntForAllNodes(0, -1, ans, cnt, n)
        return ans
    }

    private fun cntForParent(cur: Int, parent: Int, ans: IntArray, cnt: IntArray) {
        graph[cur]?.forEach { adj ->
            if (parent != adj) {
                cntForParent(adj, cur, ans, cnt)
                cnt[cur] += cnt[adj]
                ans[cur] += ans[adj] + cnt[adj]
            }
        }
    }

    private fun cntForAllNodes(cur: Int, parent: Int, ans: IntArray, cnt: IntArray, n: Int) {
        graph[cur]?.forEach { adj ->
            if (parent != adj) {
                ans[adj] = ans[cur] - cnt[adj] + (n - cnt[adj])
                cntForAllNodes(adj, cur, ans, cnt, n)
            }
        }
    }
}
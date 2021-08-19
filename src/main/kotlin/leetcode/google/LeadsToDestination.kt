package leetcode.google

class LeadsToDestination {
    private val graph = HashMap<Int, List<Int>>()

    fun leadsToDestination(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
        edges.forEach { (x, y) ->
            val adj = graph.getOrDefault(x, emptyList()).toMutableList()
            adj.add(y)
            graph[x] = adj
        }
        if (graph[destination] != null) { // destination has outgoing edges
            return false
        }
        val endDestinations = HashSet<Int>()
        dfs(source, endDestinations, HashSet())
        return endDestinations.size == 1 && endDestinations.first() == destination
    }

    private fun dfs(cur: Int, endDestination: HashSet<Int>, visited: HashSet<Int>): Boolean {
        if (visited.contains(cur)) return true // there is a loop
        if (graph.containsKey(cur)) {
            endDestination.add(cur)
        }
        visited.add(cur)
        val adj = graph.get(cur)!!
        adj.forEach { j ->
            if (dfs(j, endDestination, visited)) return true
        }
        return false
    }
}
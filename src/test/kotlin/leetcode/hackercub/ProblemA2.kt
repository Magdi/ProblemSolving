package leetcode.hackercub

import java.io.File
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class ProblemA2 {
    fun minSeconds(s: String, edges: List<String>): Int {
        val graph = HashMap<Char, HashSet<Char>>()
        edges.forEach {
            val adj = graph.getOrDefault(it[0], HashSet())
            adj.add(it[1])
            graph[it[0]] = adj
        }
        val cache = HashMap<Pair<Char, Char>, Int>()
        ('A'..'Z').forEach { a ->
            ('A'..'Z').forEach { b ->
                val x = bfs(a, b, graph)
                cache[Pair(a, b)] = x
            }
        }
        var res = Int.MAX_VALUE
        ('A'..'Z').forEach { t ->
            val target = "$t".repeat(s.length)
            val c = calc(s, target, cache)
            if (c != -1) {
                res = Math.min(c, res)
            }
        }
        return if (res == Int.MAX_VALUE) -1 else res
    }

    private fun calc(s: String, target: String, cache: HashMap<Pair<Char, Char>, Int>): Int {
        var ans = 0
        for (i in 0..s.lastIndex) {
            val pair = Pair(s[i], target[i])
            if (cache[pair] == -1) return -1
            ans += cache[pair]!!
        }
        return ans
    }

    private fun bfs(s: Char, e: Char, graph: HashMap<Char, HashSet<Char>>): Int {
        val queue: Queue<Char> = LinkedList()
        val visited = HashSet<Char>()
        queue.add(s)
        var level = 0
        while (queue.isNotEmpty()) {
            val l = queue.size
            for (i in 0 until l) {
                val c = queue.poll()
                if (c == e) return level
                if (visited.contains(c)) continue
                visited.add(c)
                graph.getOrDefault(c, HashSet()).forEach {
                    queue.add(it)
                }
            }
            level++
        }
        return -1
    }

}

fun main() {
    val read = File("inA1.txt").readLines().iterator()
    val n = read.next().toInt()
    val problem = ProblemA2()

    val text = StringBuilder()
    for (i in 1..n) {
        val s = read.next()
        val m = read.next().toInt()
        val edges = (0 until m).map { read.next() }
        text.append("Case #${i}: ${problem.minSeconds(s, edges)}\n")
    }

    println(text)
    val fileOut = File("out1.txt")
    fileOut.writeText(text.toString())
}
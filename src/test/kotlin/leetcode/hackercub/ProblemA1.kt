package leetcode.hackercub

import java.io.File

class ProblemA1 {
    fun minSeconds(s: String): Int {
        val v = setOf('A', 'E', 'I', 'O', 'U')
        var min = s.length * 2
        ('A'..'Z').forEach { toChar ->
            val toVowel = v.contains(toChar)
            var cnt = 0
            s.forEach { test ->
                val testVowel = v.contains(test)
                if (test != toChar) {
                    cnt += if (testVowel == toVowel) 2 else 1
                }
            }
            min = Math.min(min, cnt)
        }
        return min
    }
}

fun main() {
    val read = File("inA1.txt").readLines().iterator()
    val n = read.next().toInt()
    val problem = ProblemA1()
    val fileOut = File("out2.txt")
    val text = StringBuilder()
    for (i in 1 .. n) {
        text.append("Case #${i}: ${problem.minSeconds(read.next())}\n")
    }
    fileOut.writeText(text.toString())
}
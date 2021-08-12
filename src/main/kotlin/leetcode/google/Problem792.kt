package leetcode.google


/**
 * https://leetcode.com/problems/number-of-matching-subsequences/
 * Number of Matching Subsequences
 */
class Problem792 {

    fun numMatchingSubseq(s: String, words: Array<String>): Int {
        val histogram = Array(s.length) {
            IntArray(26) { -1 }
        }
        for (i in s.lastIndex - 1 downTo 0) {
            histogram[i] = histogram[i + 1].clone()
            histogram[i][getIndex(s[i + 1])] = i + 1
        }
        return words.count {
            val res = isSubSequance(s, it, histogram)
            if (res) println(it)
            res
        }
    }

    private fun isSubSequance(s: String, it: String, histogram: Array<IntArray>): Boolean {
        var index = 0
        it.forEach { char ->
            if (index >= s.length) {
                return false
            }
            if (s[index] != char) {
                if (histogram[index][getIndex(char)] == -1) {
                    return false
                } else {
                    index = histogram[index][getIndex(char)] + 1
                }
            } else {
                index++
            }

        }
        return true
    }

    private fun getIndex(s: Char): Int = (s.toInt() - 'a'.toInt())

}

class Problem792_S2 {

    fun numMatchingSubseq(s: String, words: Array<String>): Int {
        val groups = words.map { Node(it, 0) }.groupBy { it.word[0] }.toMutableMap()
        var ans = 0
        s.forEach { c ->
            val tmp = groups[c]
            groups[c] = mutableListOf()
            tmp?.forEach { node ->
                node.index++
                if (node.index == node.word.length) {
                    ans++
                } else {
                    val list = groups.getOrDefault(node.word[node.index], mutableListOf()).toMutableList()
                    list.add(node)
                    groups[node.word[node.index]] = list
                }
            }
        }
        return ans
    }


    data class Node(val word: String, var index: Int)
}
package leetcode.mock

import org.junit.Assert
import org.junit.Test


class MockInterview3 {

    @Test
    fun `test case 1`() {
        Assert.assertTrue(
            SimilarSentences().areSentencesSimilar(
                arrayOf("great", "acting", "skills"),
                arrayOf("fine", "drama", "talent"),
                listOf(
                    listOf("great", "fine"),
                    listOf("drama", "acting"),
                    listOf("skills", "talent"),
                )
            )
        )
    }

}

class SimilarSentences {
    fun areSentencesSimilar(
        sentence1: Array<String>,
        sentence2: Array<String>,
        similarPairs: List<List<String>>
    ): Boolean {
        val similarMap = HashMap<String, HashSet<String>>()
        similarPairs.forEach { (a, b) ->
            val aSimilars = similarMap.getOrDefault(a, HashSet())
            aSimilars.add(b)
            similarMap[a] = aSimilars
            val bSimilars = similarMap.getOrDefault(b, HashSet())
            bSimilars.add(a)
            similarMap[b] = bSimilars
        }
        if (sentence1.size != sentence2.size) {
            return false
        }
        sentence1.forEachIndexed { index, _ ->
            val a = sentence1[index]
            val b = sentence2[index]
            if (a != b && !isSimilar(a, b, similarMap, HashSet())) {
                return false
            }
        }
        return true
    }

    private fun isSimilar(
        src: String,
        dest: String,
        similarMap: HashMap<String, HashSet<String>>,
        visited: HashSet<String>
    ): Boolean {
        val similars = similarMap.getOrDefault(src, HashSet())
        if (similars.contains(dest)) return true
        if (visited.contains(src)) return false
        visited.add(src)
        similars.forEach {
            if (isSimilar(it, dest, similarMap, visited)) {
                return true
            }
        }
        return false
    }
}


class AutocompleteSystem(sentences: Array<String>, times: IntArray) {

    private val history: MutableList<Sentence> = sentences.mapIndexed { index, s ->
        Sentence(s, times[index])
    }.toMutableList()

    private val query = StringBuilder()
    fun input(c: Char): List<String> {
        if (c == '#') {
            val item = history.find { it.string == query.toString() }
            if (item == null) {
                history.add(Sentence(query.toString(), 1))
            } else {
                item.cnt++
            }
            query.clear()
            return emptyList()
        }
        query.append(c)
        val list = history.filter {
            it.string.startsWith(query)
        }.sorted().map { it.string }

        if (list.size > 3) return list.subList(0, 3)
        return list
    }

    private data class Sentence(val string: String, var cnt: Int) : Comparable<Sentence> {
        override fun compareTo(other: Sentence): Int {
            return if (other.cnt.compareTo(cnt) == 0) {
                string.compareTo(other.string)
            } else other.cnt.compareTo(cnt)
        }
    }
}

class Sol {
    fun numberOfPatterns(m: Int, n: Int): Int {
        val count = IntArray(n + 1)
        for (i in 0..2) {
            for (j in 0..2) {
                backtrack(i, j, 1, count, HashSet())
            }
        }
        var sum = 0
        for (i in m..n) sum += count[i]
        return sum
    }

    private fun backtrack(row: Int, col: Int, step: Int, count: IntArray, seqSet: MutableSet<Int>) {
        if (step >= count.size) return
        seqSet.add(row * 3 + col)
        ++count[step]
        for (i in 0..2) {
            for (j in 0..2) {
                if (seqSet.contains(i * 3 + j)) continue
                if ((i - row) % 2 != 0 || (j - col) % 2 != 0 || seqSet.contains((i + row) / 2 * 3 + (j + col) / 2)) {
                    backtrack(i, j, step + 1, count, seqSet)
                }
            }
        }
        seqSet.remove(row * 3 + col)
    }
}
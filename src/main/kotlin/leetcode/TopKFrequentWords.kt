package leetcode

import java.util.*

/**
 * https://leetcode.com/problems/top-k-frequent-words/
 */

class TopFrequentWords {
    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        val wordsCount = mutableMapOf<String, Int>()
        words.forEach { word ->
            val count = wordsCount.getOrDefault(word, 0)
            wordsCount[word] = count + 1
        }

        val pQueue = PriorityQueue<WordFrequency>()
        wordsCount.forEach { word, count ->
            pQueue.add(WordFrequency(word, count))
            if (pQueue.size > k) {
                pQueue.poll()
            }
        }

        val topKWords = mutableListOf<String>()
        while (pQueue.isNotEmpty()) {
            topKWords.add(pQueue.poll().word)
        }
        return topKWords.reversed()
    }

    data class WordFrequency(val word: String, val count: Int) : Comparable<WordFrequency> {
        override fun compareTo(other: WordFrequency): Int {
            return if (count == other.count) {
                other.word.compareTo(word)
            } else {
                count.compareTo(other.count)
            }
        }
    }
}
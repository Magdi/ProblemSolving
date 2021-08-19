package leetcode.google

import java.util.*

class TimeMap {

    /** Initialize your data structure here. */
    private val map = hashMapOf<String, List<Node>>()

    fun set(key: String, value: String, timestamp: Int) {
        val list = map.getOrDefault(key, emptyList()).toMutableList()
        list.add(Node(timestamp, value))
        map[key] = list
    }

    fun get(key: String, timestamp: Int): String {
        if (!map.containsKey(key)) {
            return ""
        }
        return map[key]?.search(timestamp) ?: ""
    }

    private fun List<Node>.search(timestamp: Int): String {
        var start = 0
        var end = size - 1
        while (start < end) {
            val mid = ((start + end) / 2) + 1
            if (get(mid).timestamp > timestamp) {
                end = mid - 1
            } else {
                start = mid
            }
        }
        return if (start >= 0 && get(start).timestamp <= timestamp) {
            get(start).value
        } else {
            ""
        }
    }

    private data class Node(val timestamp: Int, val value: String)

}

class TimeMap2 {

    /** Initialize your data structure here. */
    private val map = hashMapOf<String, TreeMap<Int, String>>()

    fun set(key: String, value: String, timestamp: Int) {
        val treemap = map.getOrDefault(key, TreeMap())
        treemap.set(timestamp, value)
        map[key] = treemap
    }

    fun get(key: String, timestamp: Int): String {
        if (!map.containsKey(key)) {
            return ""
        }
        return map[key]?.floorEntry(timestamp)?.value ?: ""
    }
}
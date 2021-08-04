package leetcode.uber

/**
 * 1531. String Compression II
 * https://leetcode.com/problems/string-compression-ii/
 */

typealias Length = Int

class StringCompressionII {
    fun getLengthOfOptimalCompression(s: String, k: Int): Int {
        if (s.isEmpty()) return 0
        val compressions = mutableListOf<Compression>()
        var cnt = 0
        var cur = s[0]
        s.forEachIndexed { index, c ->
            if (c != cur) {
                compressions.add(Compression(cur, cnt))
                cur = c
                cnt = 1
            } else {
                cnt++
            }
            if (index == s.lastIndex) {
                compressions.add(Compression(cur, cnt))
            }
        }
        return minLength(0, null, k, compressions, hashMapOf())
    }

    fun minLength(
        ind: Int,
        prev: Compression? = null,
        rem: Int,
        compressions: List<Compression>,
        cache: HashMap<State, Length>
    ): Length {
        if (ind > compressions.size || rem < 0) return 102
        if (ind == compressions.size) return 0
        val key = State(ind, prev, rem)
        if (cache.contains(key)) {
            return cache[key]!!
        }
        val cur = compressions[ind]
        var min = 102
        if (prev?.char != cur.char) {
            for (r in 0..Math.min(rem, cur.cnt)) {
                val nCnt = cur.cnt - r
                val nPrev = if (nCnt == 0) prev else cur.copy(cnt = nCnt)
                min = Math.min(min, length(nCnt) + minLength(ind + 1, nPrev, rem - r, compressions, cache))
            }
        } else {
            val newCnt =  prev.cnt + cur.cnt
            min = minLength(
                ind + 1,
                cur.copy(cnt = newCnt),
                rem,
                compressions,
                cache
            ) - length(prev.cnt) + length(newCnt)
        }
        cache[key] = min
        return min
    }

    private fun length(nCnt: Int): Int {
        return when (nCnt) {
            0 -> 0
            1 -> 1
            else -> {
                1 + nCnt.toString().length
            }
        }
    }


    data class Compression(val char: Char, val cnt: Int)
    data class State(val ind: Int, val compression: Compression?, val rem: Int)
}
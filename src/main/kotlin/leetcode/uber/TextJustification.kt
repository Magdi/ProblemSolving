package leetcode.uber

import java.lang.StringBuilder

class TextJustification {
    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
        val results = mutableListOf<String>()
        var index = 0
        while (index < words.size) {
            val lineBuilder = StringBuilder()
            lineBuilder.append(words[index])
            var end = index
            var remSpaces = maxWidth + 1
            while (end < words.size && remSpaces - (words[end].length + 1) >= 0) {
                remSpaces -= (words[end].length + 1)
                end++
            }
            val spaceCnt = maxWidth - (index until end).map { words[it].length }.sum()
            val wordsCnt = end - index
            if (wordsCnt == 1) {// one word line
                lineBuilder.append(" ".repeat(spaceCnt))
            } else if (end == words.size) {
                for (s in index + 1 until end) {
                    lineBuilder.append(" ")
                    lineBuilder.append(words[s])
                }
                lineBuilder.append(" ".repeat(maxWidth - lineBuilder.length))
            } else {
                val midSpaces = spaceCnt / (wordsCnt - 1)
                var extraSpaces = spaceCnt % (wordsCnt - 1)
                for (s in index + 1 until end) {
                    val extra = if (extraSpaces-- > 0) 1 else 0
                    lineBuilder.append(" ".repeat(midSpaces + extra))
                    lineBuilder.append(words[s])
                }
            }
            results.add(lineBuilder.toString())
            index = end
        }
        return results
    }
}
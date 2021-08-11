package leetcode.google

/**
 * https://leetcode.com/problems/sentence-screen-fitting/
 * Given a rows x cols screen and a sentence represented as a list of strings,
 * return the number of times the given sentence can be fitted on the screen.
 * The order of words in the sentence must remain unchanged,
 * and a word cannot be split into two lines. A single space must separate two consecutive words in a line.
 */
class SentenceScreenFitting {
    fun wordsTyping(sentence: Array<String>, rows: Int, cols: Int): Int {
        var cnt = 0
        var r = 0
        var c = 0
        var i = 0
        while (r < rows) {
            var w = sentence[i].length
            while (c + w <= cols) {
                c += w + 1
                i += 1
                if (i == sentence.size) {
                    cnt++
                    i = 0
                }
                w = sentence[i].length
            }
            r++
            c = 0
        }
        return cnt
    }
}
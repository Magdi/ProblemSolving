package leetcode.uber

class ConstructKPalindromeStrings {
    fun canConstruct(s: String, k: Int): Boolean {
        if (k > s.length) return false
        val charCount = hashMapOf<Char, Int>()
        s.forEach { char ->
            val cnt = charCount.getOrDefault(char, 0)
            charCount[char] = cnt + 1
        }
        val oddCnt = charCount.values.count { it % 2 != 0 }
        return oddCnt <= k
    }
}
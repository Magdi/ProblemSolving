package leetcode.google

class Logger() {

    /** Initialize your data structure here. */
    private val map = hashMapOf<String, Int>()

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
    If this method returns false, the message will not be printed.
    The timestamp is in seconds granularity. */
    fun shouldPrintMessage(timestamp: Int, message: String): Boolean {
        if(map.containsKey(message) && timestamp - map.get(message)!! < 10)
            return false;

        map.put(message, timestamp);
        return true;
    }

}

/**
 * Your Logger object will be instantiated and called as such:
 * var obj = Logger()
 * var param_1 = obj.shouldPrintMessage(timestamp,message)
 */
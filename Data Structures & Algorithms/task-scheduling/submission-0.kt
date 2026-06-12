class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val count = IntArray(26)

        for(t in tasks) {
            count[t - 'A']++
        }

        val maxF = count.maxOrNull() ?: 0

        var maxCount = 0

        for(c in count) {
            if(c == maxF) {
                maxCount++
            }
        }

        val time = ((maxF - 1) * (n + 1)) + maxCount
        return max(tasks.size, time)
    }
}

class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val n = temperatures.size
        val res = IntArray(n)

        for (i in n - 2 downTo 0) {
            var j = i + 1
            while (j < n && temperatures[j] <= temperatures[i]) {
                if (res[j] == 0) {
                    j = n
                    break
                }
                j += res[j]
            }

            if (j < n) {
                res[i] = j - i
            }
        }
        return res
    }
}
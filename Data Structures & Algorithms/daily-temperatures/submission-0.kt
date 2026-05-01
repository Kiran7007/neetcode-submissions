class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val res =IntArray(temperatures.size)

        for (i in temperatures.lastIndex-1 downTo 0) {
            for(j in i+1 .. temperatures.lastIndex) {
                if (temperatures[i] < temperatures[j])  {
                    res[i] = j - i
                    break
                }
            }
        }

        return res
    }
}

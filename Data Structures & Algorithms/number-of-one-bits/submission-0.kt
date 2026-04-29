class Solution {
    fun hammingWeight(n: Int): Int {
        var sum = 0
        var num = n
        while(num != 0) {
            num = num and (num - 1)
            sum++
        }
        return sum
    }
}

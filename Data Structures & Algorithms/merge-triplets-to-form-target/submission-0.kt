class Solution {
    fun mergeTriplets(triplets: Array<IntArray>, target: IntArray): Boolean {
        var x = false
        var y = false
        var z = false

        for (t in triplets) {
            x = x || (t[0] == target[0] && t[1] <= target[1] && t[2] <= target[2])
            y = y || (t[0] <= target[0] && t[1] == target[1] && t[2] <= target[2])
            z = z || (t[0] <= target[0] && t[1] <= target[1] && t[2] == target[2])

            if (x && y && z) return true
        }
        return false
    }
}

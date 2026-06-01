class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var l = 1
        var r = piles.max()!!
        var res = r

        while(l <= r) {
            var mid = (r+l)/2
            var totalTime = 0L

            for(p in piles) {
                totalTime += Math.ceil(p.toDouble() / mid).toLong()
            }

            if(totalTime <= h) {
                res = mid
                r = mid - 1
            } else {
                l = mid + 1
            }
        }

        return res
    }
}

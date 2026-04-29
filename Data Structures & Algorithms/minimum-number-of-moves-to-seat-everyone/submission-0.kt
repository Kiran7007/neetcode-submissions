class Solution {
    fun minMovesToSeat(seats: IntArray, students: IntArray): Int {
        val maxSeat = seats.max()
        val maxStud = students.max()

        val countSeat = IntArray(maxSeat + 1)
        val countStud = IntArray(maxStud + 1)

        for(s in students) countStud[s]++
        for(s in seats) countSeat[s]++

        var i = 0
        var j = 0
        var res = 0
        var remain = seats.size

        while(remain > 0) {
            while(countSeat[i] == 0) i++
            while(countStud[j] == 0) j++

            val temp = minOf(countSeat[i], countStud[j])
            res += kotlin.math.abs(i - j) * temp
            countSeat[i] -= temp
            countStud[j] -= temp
            remain -= temp
        }

        return res
    }
}

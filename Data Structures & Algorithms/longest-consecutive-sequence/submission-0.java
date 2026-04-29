class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int longestSub = 0;

        for(int n: nums) {
            set.add(n);
        }

        for(int n: nums) {
            if(!set.contains(n-1)) {
                int longest = 0;
                while(set.contains(n+longest)) {
                    longest++;
                }
                longestSub = Math.max(longestSub, longest);
            }
        }

        return longestSub;
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int res = 0;
        Set set = new HashSet<Character>();

        for(char c: s.toCharArray()) {
            while(set.contains(c)) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(c);
            res = Math.max(res, set.size());
        }
        return res;
    }
}

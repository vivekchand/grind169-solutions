class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int start = 0;
        int end = 0;
        int longest = 0;
        
        while(end < s.length()) {
            if(!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                longest = Math.max(longest, set.size());
                end++;
            } else {
                set.remove(s.charAt(start));
                start++;
            }
        }
        return longest;
    }
}
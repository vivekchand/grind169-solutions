class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> count = new TreeMap<>();
        
        for(char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0)+1);
        }
        int ans = 0;
        for(Character key : count.keySet()) {
            int keyCount = count.get(key);
            ans += keyCount / 2 * 2;
            if(ans % 2 == 0 && keyCount % 2 == 1)
                ans++;
        }
        return ans;
    }
}
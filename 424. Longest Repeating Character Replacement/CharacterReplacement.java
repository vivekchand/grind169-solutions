class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] count = new int[26];
        int maxCount = 0, maxLength = 0, left = 0;
        for (int right = 0; right < n; right++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(right) - 'A']);
            while (right - left + 1 - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}

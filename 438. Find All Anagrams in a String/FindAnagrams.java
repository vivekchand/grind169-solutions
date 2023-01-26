class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] target = new int[26];
        for (char c : p.toCharArray()) {
            target[c - 'a']++;
        }
        int start = 0, end = 0;
        int[] window = new int[26];
        while (end < s.length()) {
            window[s.charAt(end) - 'a']++;
            end++;
            if (end - start == p.length()) {
                if (Arrays.equals(target, window)) {
                    res.add(start);
                }
                window[s.charAt(start) - 'a']--;
                start++;
            }
        }
        return res;
    }
}
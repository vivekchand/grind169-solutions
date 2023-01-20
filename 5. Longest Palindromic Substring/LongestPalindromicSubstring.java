class Solution {
	private int lo, maxLen;
	public String longestPalindrome(String s) {
		int len = s.length();
		if (len < 2) return s;
		for(int i=0; i<s.length(); i++) {
			extendAroundCenter(s, i, i); // odd length
			extendAroundCenter(s, i, i+1); // event length
		}
		return s.substring(lo, lo + maxLen);
	}
	
	private void extendAroundCenter(String s, int i, int j) {
		while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
			i--;
			j++;
		} 

		if(maxLen < j - i - 1) {
			maxLen = j - i - 1;
			lo = i+1;
		}
	}
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int count = 0;
        int minLength = Integer.MAX_VALUE;
        for(String str: strs) {
            minLength = Math.min(minLength, str.length());
        }
        int low = 1;
        int high = minLength;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(isCommonPrefix(strs, mid))
                low = mid + 1;
            else
                high = mid - 1;
        }
        return strs[0].substring(0, (low + high)/2);
    }
    
    public boolean isCommonPrefix(String[] strs, int len) {
        String str1 = strs[0].substring(0, len);
        for(int i=1; i<strs.length; i++) {
            if(!strs[i].startsWith(str1))
                return false;
        }
        return true;
    }
}
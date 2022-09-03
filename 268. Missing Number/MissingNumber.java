class Solution {
    public int missingNumber(int[] nums) {
        int expectedXor = 0;
        int actualXor = 0;
        for(int i=0; i<=nums.length; i++) {
            expectedXor = expectedXor ^ i;
        }
        for(int i=0; i<nums.length; i++) {
            actualXor = actualXor ^ nums[i];
        }
        
        return expectedXor ^ actualXor;
    }
}
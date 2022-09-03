class Solution {
    public int maxSubArray(int[] nums) {
        int curSub = nums[0], maxSub = nums[0];
        for(int i=1; i<nums.length; i++) {
            curSub = Math.max(nums[i], curSub + nums[i]);
            maxSub = Math.max(curSub, maxSub);
        }
        return maxSub;
    }
}
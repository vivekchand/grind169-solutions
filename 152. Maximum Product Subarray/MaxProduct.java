class Solution {
	public int maxProduct(int[] nums) {
		int res = Integer.MIN_VALUE;
		int curMax = 1, curMin = 1;
		for(int i=0; i<nums.length; i++) {
			int prevCurMax = curMax ;
			curMax = Math.max(nums[i], Math.max(curMax * nums[i], curMin * nums[i]));
			curMin = Math.min(nums[i], Math.min(prevCurMax * nums[i], curMin * nums[i]));
			res = Math.max(res, curMax);
        }
        return res;
    }
}
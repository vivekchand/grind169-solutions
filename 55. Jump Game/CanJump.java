class Solution {
	public boolean canJump(int[] nums) {
		int end = nums.length - 1; // initialize the end index to the last position in the array
		for (int i = nums.length - 2; i >= 0; i--) { // start from the second to last position and move backwards
			if (i + nums[i] >= end) { // check if we can reach the end from this position
				end = i; // update the end index to the current position
			}
		}
		return end == 0; // return true if we can reach the end from the start, false otherwise
	}
}

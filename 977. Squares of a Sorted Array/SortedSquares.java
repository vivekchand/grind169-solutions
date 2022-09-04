class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int[] result = new int[n];
        
        for(int i=n-1; i>=0; i--) {
            if(Math.abs(nums[left]) < Math.abs(nums[right])) {
                result[i] = nums[right] * nums[right];
                right--;
            } else {
                result[i] = nums[left] * nums[left];
                left++;
            }
        }
        return result;
    }
}
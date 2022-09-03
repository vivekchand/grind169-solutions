class Solution {
    public void moveZeroes(int[] nums) {
        int zeroCount = 0;
        int index = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != 0) {
                nums[index++] = nums[i];
            } else {
                zeroCount++;
            }
        }
        for(int i=0; i<zeroCount; i++) {
            nums[index++] = 0;
        }
    }
}
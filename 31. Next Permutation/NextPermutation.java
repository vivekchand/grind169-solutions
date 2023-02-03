class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        int pivot = n - 1;

        while (pivot >= 1 && nums[pivot] <= nums[pivot - 1]) {
            pivot--;
        }
        
        if (pivot != 0) {
            int i = n - 1;
            while (nums[i] <= nums[pivot - 1]) {
                i--;
            }
            swap(nums, pivot-1, i);
        }
        
        reverseArray(nums, pivot, n - 1);
    }
    
    private void reverseArray(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

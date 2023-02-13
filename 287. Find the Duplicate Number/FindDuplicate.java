class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        
        // move slow and fast pointers in the array until they meet
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        
        // find the entry point of the cycle
        int ptr1 = nums[0];
        int ptr2 = slow;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        
        return ptr1;
    }
}

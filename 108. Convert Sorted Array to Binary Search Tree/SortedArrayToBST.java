/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int low = 0;
        int high = nums.length -1;
        return preOrder(nums, low, high);
    }
    
    private TreeNode preOrder(int[] nums, int low, int high) {
        if(low > high) return null;

        int mid = (low + high) / 2;
        int val = nums[mid];
        TreeNode root = new TreeNode(val);
        
        root.left = preOrder(nums, low, mid-1);
        root.right = preOrder(nums, mid+1, high);
        return root;
    }
}
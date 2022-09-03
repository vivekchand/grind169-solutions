class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(Math.abs(maxHeight(root.left) - maxHeight(root.right)) > 1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int maxHeight(TreeNode root) {
        if(root == null) return -1;
        return Math.max(maxHeight(root.left), maxHeight(root.right)) + 1;
    }
}
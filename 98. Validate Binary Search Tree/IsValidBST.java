class Solution {
	public boolean isValidBST(TreeNode root) {
		return check(root, null, null);
	}
 
	private boolean check(TreeNode root, Integer minVal, Integer maxVal) {
		if(root == null) return true;

		if(minVal != null && root.val <= minVal || maxVal != null && root.val >= maxVal) {
			return false;
		}
		return check(root.left, minVal, root.val) && check(root.right, root.val, maxVal);
	} 
}

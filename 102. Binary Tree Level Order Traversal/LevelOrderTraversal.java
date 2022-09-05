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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        inOrder(root, 0, map);
        
        return new ArrayList<>(map.values());
    }
    
    private void inOrder(TreeNode root, int level, Map<Integer, List<Integer>> map) {
        if(root == null) {
            return;
        }

        inOrder(root.left, level+1, map);
        
        if(!map.containsKey(level)) {
            map.put(level, new ArrayList<>());
        }
        map.get(level).add(root.val);
        
        inOrder(root.right, level+1, map);
    }
    
    
}
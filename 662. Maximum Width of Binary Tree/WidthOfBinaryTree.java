class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int maxWidth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> indices = new LinkedList<>();
        queue.add(root);
        indices.add(1);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            int left = indices.peek();
            int right = left;
            
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                int index = indices.poll();
                right = index;
                
                if (curr.left != null) {
                    queue.add(curr.left);
                    indices.add(index * 2);
                }
                
                if (curr.right != null) {
                    queue.add(curr.right);
                    indices.add(index * 2 + 1);
                }
            }
            
            maxWidth = Math.max(maxWidth, right - left + 1);
        }
        
        return maxWidth;
    }
}

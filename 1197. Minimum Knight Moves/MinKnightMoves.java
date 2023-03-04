class Solution {
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        
        int[][] directions = new int[][]{{1,2}, {2,1}, {2,-1}, {1,-2}, {-1,-2}, {-2,-1}, {-2,1}, {-1,2}};
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        
        Set<String> visited = new HashSet<>();
        visited.add("0,0");
        
        int moves = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int currX = curr[0];
                int currY = curr[1];
                
                if (currX == x && currY == y) {
                    return moves;
                }
                
                for (int[] direction : directions) {
                    int nextX = currX + direction[0];
                    int nextY = currY + direction[1];
                    String key = nextX + "," + nextY;
                    
                    if (!visited.contains(key) && nextX >= -1 && nextY >= -1) {
                        queue.offer(new int[]{nextX, nextY});
                        visited.add(key);
                    }
                }
            }
            moves++;
        }
        
        return -1;
    }
}

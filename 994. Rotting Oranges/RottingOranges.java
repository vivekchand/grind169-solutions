class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new int[] {i, j});
                } else if(grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        
        // Mark the round / level, the ticker of timestamp
        queue.offer(new int[] {999, 999});
        
        int minutesElapsed = -1;
        
        int[] rowDirs = {-1, +1, 0, 0};
        int[] colDirs = {0, 0, -1, +1};
        
        while(!queue.isEmpty()) {
            int[] p = queue.poll();
            
            int row = p[0];
            int col = p[1];
            
            if(row == 999) {
                // We finished one round of processing
                minutesElapsed++;
                // to avoid endless loop
                if(!queue.isEmpty()) {
                    queue.offer(new int[] {999, 999});
                }
            } else {
                // this is a rotten orange
                // then it would contaminate its neighbors
                
                for(int d=0; d<4; d++) {
                    int nRow = row + rowDirs[d];
                    int nCol = col + colDirs[d];
                    if(nRow < 0 || nRow > grid.length-1 || nCol < 0 || nCol > grid[0].length-1) {
                        continue;
                    }
                    if(grid[nRow][nCol] == 1) {
                        grid[nRow][nCol] = 2;
                        freshOranges--;
                        queue.add(new int[] {nRow, nCol});
                    }
                }
            }
            
        }
        return freshOranges == 0 ? minutesElapsed : -1;
    }
}
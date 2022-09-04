class Solution {
    private Map<String, Integer> visited = new HashMap<>();
    
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new ArrayDeque<>();
        for(int r=0; r<mat.length; r++) {
            for(int c=0; c<mat[0].length; c++) {
                if(mat[r][c] == 0) 
                    q.offer(new int[] {r, c});
                else 
                    mat[r][c] = -1; // Marked as not processed yet!
            }
        }

        int[] rowDirs = {0, +1, -1, 0};
        int[] colDirs = {+1, 0, 0, -1};

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];
            for(int d=0; d<4; d++) {
                int next_r = r + rowDirs[d];
                int next_c = c + colDirs[d];
                if(next_r < 0 || next_r == mat.length || next_c < 0 || next_c == mat[0].length || mat[next_r][next_c] != -1)
                    continue;
                
                mat[next_r][next_c] = mat[r][c] + 1;
                q.offer(new int[] {next_r, next_c});
            }
        }
        return mat;
    }
}
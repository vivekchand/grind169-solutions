class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j) {
        if(i < 0 || i > grid.length-1 || j < 0 || j > grid[0].length-1 || grid[i][j] == '0') return;
        
        
        grid[i][j] = '0';
        
        int[] rowDirs = {0, -1, +1, 0};
        int[] colDirs = {-1, 0, 0, +1};
        
        for(int d=0; d<4; d++) {
            dfs(grid, i+rowDirs[d], j+colDirs[d]);
        }
    }
}
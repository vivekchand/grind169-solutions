class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        int newColor = color;
        return fill(image, sr, sc, newColor, oldColor);
    }
    
    public int[][] fill(int[][] image, int sr, int sc, int newColor, int oldColor) {
        if(image[sr][sc] == newColor) {
            return image;
        }
        
        image[sr][sc] = newColor;
        
        int[] rowDirs = {0, -1, +1, 0};
        int[] colDirs = {-1, 0, 0, +1};
        
        for(int i=0; i<4; i++) {
            int newSr = sr + rowDirs[i];
            int newSc = sc + colDirs[i];
            if(newSr < 0 || newSr >= image.length || newSc < 0 || newSc >= image[0].length) {
                continue;
            }
            int color = image[newSr][newSc];
            if(color == oldColor) {
                image = fill(image, newSr, newSc, newColor, oldColor);
            }
        }
        return image;
    }
}
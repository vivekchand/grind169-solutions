class Solution {
    private int[] prefixSum;
    private int totalSum;

    public Solution(int[] w) {
        this.prefixSum = new int[w.length];
        this.totalSum = 0;
        
        for (int i = 0; i < w.length; i++) {
            totalSum += w[i];
            prefixSum[i] = totalSum;
        }
    }
    
    public int pickIndex() {
        int rand = (int) (Math.random() * totalSum);
        int left = 0;
        int right = prefixSum.length - 1;
        
        while (left < right) {
            int mid = (left + right) / 2;
            
            if (rand >= prefixSum[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}

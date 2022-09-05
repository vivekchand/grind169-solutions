class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> maxHeap = new PriorityQueue<>((p1, p2) -> (
            getDistanceFromOrigin(p2) - getDistanceFromOrigin(p1)
        ));
        
        for(int[] point : points) {
            maxHeap.add(point);
            while(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        
        List<int[]> closest = new ArrayList<>();
        while(!maxHeap.isEmpty()) {
            closest.add(maxHeap.poll());
        }
        return closest.toArray(new int[closest.size()][]);
    }
    
    private int getDistanceFromOrigin(int [] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

}
import java.util.PriorityQueue;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            if (heap.size() < k) {
                heap.offer(num);
            } else {
                if (num > heap.peek()) {
                    heap.poll();
                    heap.offer(num);
                }
            }
        }
        return heap.peek();
    }
}

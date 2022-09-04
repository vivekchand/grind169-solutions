class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int index = 0;
        LinkedList<int[]> output = new LinkedList<>();
        while(index < intervals.length && intervals[index][0] < newInterval[0]) {
            output.add(intervals[index]);
            index++;
        }
        
        if(output.isEmpty() || output.getLast()[1] < newInterval[0]) {
            output.add(newInterval);
        } else {
            output.getLast()[1] = Math.max(output.getLast()[1], newInterval[1]);
        }
        
        while(index < intervals.length) {
            int[] currentInterval = intervals[index];
            if(output.getLast()[1] < currentInterval[0]) {
                output.add(currentInterval);
            } else {
                output.getLast()[1] = Math.max(output.getLast()[1], currentInterval[1]);
            }
            index++;
        }
        return output.toArray(new int[output.size()][]);
    }
}
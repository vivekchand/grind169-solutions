class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] taskCount = new int[26];
        for (char task : tasks) {
            taskCount[task - 'A']++;
        }
        int maxCount = 0;
        for (int count : taskCount) {
            maxCount = Math.max(maxCount, count);
        }
        int maxCountTasks = 0;
        for (int count : taskCount) {
            if (count == maxCount) {
                maxCountTasks++;
            }
        }
        int totalInterval = (maxCount - 1) * (n + 1) + maxCountTasks;
        return Math.max(tasks.length, totalInterval);
    }
}

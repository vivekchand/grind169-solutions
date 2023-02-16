class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Initialize the graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegrees = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<Integer>());
        }
        for (int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
            indegrees[edge[0]]++;
        }

        // Perform the topological sort using BFS
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        int[] result = new int[numCourses];
        int i = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result[i++] = node;
            for (int neighbor : graph.get(node)) {
                indegrees[neighbor]--;
                if (indegrees[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        if (i == numCourses) {
            return result;
        } else {
            return new int[0];
        }
    }
}

class Solution {
    public boolean validTree(int n, int[][] edges) {
        // Create an adjacency list to represent the graph
        List<List<Integer>> adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        // Initialize a visited array to keep track of visited nodes
        boolean[] visited = new boolean[n];

        // Check if the graph is cyclic or not
        if (isCyclic(adjList, 0, visited, -1)) {
            return false;
        }

        // Check if all nodes are visited
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }

        return true;
    }

    private boolean isCyclic(List<List<Integer>> adjList, int u, boolean[] visited, int parent) {
        visited[u] = true;

        // Visit all neighbors of the current node
        for (int v : adjList.get(u)) {
            if (!visited[v]) {
                if (isCyclic(adjList, v, visited, u)) {
                    return true;
                }
            } else if (v != parent) { // can visit the parent node, but if some other node then there is a cycle
                return true;
            }
        }

        return false;
    }
}

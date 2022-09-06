class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[numCourses];
        
        for(int[] pre: prerequisites) {
            List<Integer> l = adj.getOrDefault(pre[1], new ArrayList<>());
            l.add(pre[0]);
            indegree[pre[0]]++;
            adj.put(pre[1], l);
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<indegree.length; i++) {
            if(indegree[i] == 0) q.add(i);
        }
        
        int count = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            if(indegree[cur] == 0) count++;
            if(!adj.containsKey(cur)) continue;
            for(int nei : adj.get(cur)) {
                indegree[nei]--;
                if(indegree[nei] == 0) q.add(nei);
            }
        }
        
        return count == numCourses;
    }
}
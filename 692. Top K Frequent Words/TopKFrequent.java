class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // Create a map to store the frequency of each word
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
        
        // Create a priority queue to store the top k frequent words
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> frequencyMap.get(a).equals(frequencyMap.get(b)) ? 
                                                        b.compareTo(a) : frequencyMap.get(a) - frequencyMap.get(b));
        for (String word : frequencyMap.keySet()) {
            pq.offer(word);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        // Create a list to store the result
        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(0, pq.poll());
        }
        
        return result;
    }
}

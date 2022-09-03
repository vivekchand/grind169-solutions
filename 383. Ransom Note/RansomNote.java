class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magMap = new HashMap<>();

        
        for(char c : magazine.toCharArray()) {
            magMap.put(c, magMap.getOrDefault(c, 0)+1);
        }
        int removeCount = 0;
        for(char c : ransomNote.toCharArray()) {
            if(magMap.containsKey(c) && magMap.get(c) > 0) {
                removeCount++;
                magMap.put(c, magMap.get(c) - 1);
            }
        }
        return removeCount == ransomNote.length();
    }
}
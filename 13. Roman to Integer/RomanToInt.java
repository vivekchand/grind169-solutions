class Solution {
    public int romanToInt(String s) {
        if(s.isEmpty()) return -1;
        Map<Character, Integer> map = new HashMap<>();
        
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        if(s.length() == 1) return map.get(s.charAt(0));
        
        char[] chars = s.toCharArray();
        int prev = chars.length-1;
        int result = map.get(chars[prev]);
        for(int i=chars.length-2; i>=0; i--) {
            if(map.get(chars[i]) < map.get(chars[prev])) {
                result -= map.get(chars[i]);
            } else {
                result += map.get(chars[i]);
            }
            prev = i;
        }
        return result;
    }
}
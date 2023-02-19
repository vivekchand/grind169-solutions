class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longestSequence = 0;
        for (int num : nums) {
            if (!set.contains(num-1)) { // check if num is the start of a sequence
                int currentNum = num;
                int currentSequenceLength = 1;
                while (set.contains(currentNum+1)) { // continue adding elements to sequence
                    currentNum += 1;
                    currentSequenceLength += 1;
                }
                longestSequence = Math.max(longestSequence, currentSequenceLength);
            }
        }
        return longestSequence;
    }
}

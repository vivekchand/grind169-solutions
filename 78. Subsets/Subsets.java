class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        backtrack(subsets, new ArrayList<>(), nums, 0);
        return subsets;
    }

    private void backtrack(List<List<Integer>> subsets, List<Integer> currentSubset, int[] nums, int start) {
        subsets.add(new ArrayList<>(currentSubset));
        for (int i = start; i < nums.length; i++) {
            currentSubset.add(nums[i]);
            backtrack(subsets, currentSubset, nums, i + 1);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}

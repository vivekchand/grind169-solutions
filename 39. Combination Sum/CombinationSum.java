class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    
    public void backtrack(int[] candidates, int remain, int start, List<Integer> tempList, List<List<Integer>> result) {
        if(remain == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        
        if(remain < 0) {
            return;
        }
        
        for(int i=start; i<candidates.length; i++) {
            tempList.add(candidates[i]);
            backtrack(candidates, remain-candidates[i], i, tempList, result); // not i + 1 because we can reuse same elements
            tempList.remove(tempList.size() - 1);
        }
        
        return;
    }
}
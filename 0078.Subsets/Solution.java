class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        recursiveSubset(nums, 0, new ArrayList<Integer>(), result);

        return result;
        // Solution 1
        // backtracing
        // recursiveSubset(nums, 0, [], [])
        //
        // fun recursiveSubset(nums, size, currentSet, result)
        //   result add currentSet
        //   if (size == nums.length) 
        //     return
        //   foreach num in nums
        //     if currentSet contains num
        //       continue
        //     newCurrentSet = new currentSet
        //     newCurrentSet add num
        //     recursiveSubset(nums, size + 1, newCurrentSet, result)
        
        // Solution 2
        // better backtracing
        // (Copied)
    }

    public void recursiveSubset(int[] nums, int start, List<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++){
            path.add(nums[i]);
            recursiveSubset(nums, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }
}
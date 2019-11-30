class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // 0 length - []
        // duplicates - not
        // sorted?
        // recursion
        // backtracking

        // Solution 1
        // findPermutations(nums, LinkedHashSet path, result)
        //   if path.length == nums.length
        //      result.add(path)
        //      break
        //   foreach number
        //     if number exists in path
        //       skip
        //     path.add(number)
        //     findPermutations(nums, path, result)
        // O(2^N)
        
        // decrease number of operations...
        // (actually, passed without optimizations..)

        List<List<Integer>> result = new ArrayList<>();

        findPermutations(nums, new LinkedHashSet<>(), result);
        
        return result;
    }

    public void findPermutations(int[] nums, Set<Integer> path, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            Integer number = nums[i];
            if (path.contains(number)) {
                continue;
            }
            path.add(number);
            findPermutations(nums, path, result);
            path.remove(number);
        }
    }
}
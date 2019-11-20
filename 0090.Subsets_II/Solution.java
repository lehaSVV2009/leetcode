class Solution {
 
        // sublist
        // power set
        // negative numbers
        // [1, 2, 3, 4] => 
        // [
        //   [], 
        //   [1], [1, 2], [1, 2, 3], [1, 2, 3, 4], [1, 2, 4], [1, 3], [1, 3, 4], [1, 4]
        //   [2], [2, 3], [2, 3, 4],
        //   [3], [3, 4]
        //   [4]
        // ]
        
        // Solution 1
        // Power set is SET
        // foreach
        //   foreach
        //     foreach
        //       subarray! but not subset or subsequence
        
        // Solution 2
        // recursion
        //
        // func subSets(size, nums, result)
        //   if number == 0
        //      return
        //   
        //   if size == 1
        //     foreach number in nums
        //       result.push(numberIndex)
        //   
        //   if size == 2
        //     foreach i in nums
        //        foreach j in nums
        //          if i == j continue
        //          result.push(Set[i, j])
        //
        //   if size == 3
        //     foreach i in nums
        //       foreach j in nums
        //         if i == j continue
        //         foreach k in nums
        //           if k == i || k == j continue
        //             result.push(Set[i, j, k])
        //   subSets(size-1, nums, result)
        
        //   func getValue(taken)
        
        
        //  func recursion (nums, index)
        //    if index >= nums.length
        //      return
        //    print index
        //    recursion(nums, index + 1)
        
        //   backtracing:
        //   if found return
        //   foreach children
        //     if found return
        
        
//    public List<List<Integer>> subsetsWithDup(int[] nums) {
//         ArrayList<Integer> numbers = Arrays.stream(nums).boxed().sorted().collect(Collectors.toCollection(ArrayList::new));                   Set<Set<Integer>> memory = new LinkedHashSet<>();
        
//         subsets(0, new HashSet<>(), numbers, memory);
        
//         Set<List<Integer>> memoryWithoutDuplicates = new LinkedHashSet<>();        
//         for (Set<Integer> row : memory) {
//             memoryWithoutDuplicates.add(row
//                 .stream()
//                 .map(index -> numbers.get(index))
//                 .sorted()
//                 .collect(Collectors.toList())
//             );
//         }
        
//         return new ArrayList(memoryWithoutDuplicates);
//     }

//     public void subsets(
//         int size, 
//         Set<Integer> currentSet, 
//         ArrayList<Integer> nums, 
//         Set<Set<Integer>> memory
//     ) {
//         // Set<Set<IndexInArray>> result = []
//         // subsets(0, [], nums, [])        
//         // func subsets(size, currentSet, nums, result)
//         //   result.push(currentSet)
//         //   if size == nums.length
//         //     return
//         //   
//         //   foreach i from nums
//         //     if (currentSet.contains i)
//         //       continue
//         //     Set newCurrentSet = new HashSet(currentSet)
//         //     newCurrentSet.push(i)
//         //     subsets(size + 1, newCurrentSet, nums, result)

//         if (!memory.contains(currentSet)) {
//             memory.add(currentSet);
//         }
//         if (size == nums.size()) {
//             return;
//         }
        
//         for (int i = 0; i < nums.size(); ++i) {
//             if (currentSet.contains(i)) {
//                 continue;
//             }
//             Set<Integer> newCurrentSet = new HashSet(currentSet);
//             newCurrentSet.add(i);
//             subsets(size + 1, newCurrentSet, nums, memory);
//         }        
//     }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        subsets(nums, 0, new ArrayList<>(), result);
        return result;
    }
    
    public void subsets(int[] nums, int index, List<Integer> path, List<List<Integer>> result) {
        result.add(path);
        for (int i = index; i < nums.length; i++){
            if (i > index && nums[i] == nums[i-1]) {
                continue;
            }
            List<Integer> newPath = new ArrayList<>(path);
            newPath.add(nums[i]);
            subsets(nums, i + 1, newPath, result);
        }
    }
}
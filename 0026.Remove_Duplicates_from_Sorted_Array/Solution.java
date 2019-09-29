class Solution {
    public int removeDuplicates(int[] nums) {
        // [1, 2, 3] => 3, [1, 2, 3]
        // [] => 0, []
        // [1, 1, 1] => 1, [1]
        
        // Solution 1
        // brute force
        // duplicates = []
        // foreach i
        //   foreach j = i + 1
        //     find duplicates
        // foreach duplicates
        //   if first skip
        //   remove duplicate
        // O(N^2)
        // Memory - O(N)
        
        // Solution 2
        // i = 0
        // j = 0
        // length = nums.length
        // while (i < length)
        //   while (j < length && a[i] == a[j])
        //     j++
        // TODO separate function to remove items from array
        // remove items from i exclusive to j exclusive (rewrite)
        // length -= (j - i)
        // i++
        // j = i
        // Algorithm complexity - O(N)
        // Space complexity - O(1)
        
        // Solution 3
        // new Set(nums).length
        // but no effect to current array

        if (nums.length == 0) {
            return 0;
        }

        int result = 0;

        for (int j = 1; j < nums.length; ++j) {
            if (nums[j] != nums[result]) {
                result++;
                nums[result] = nums[j];
            }
        }

        return result + 1;
    }
}
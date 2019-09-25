class Solution {
    public int search(int[] nums, int target) {
        // Solution 1
        // Find smallest value in array
        // How?
        // while start <= end
        //   Go to the middleIndex (start + end) / 2
        //   middleIndex
        //   If middleValue > endValue
        //     start = middle + 1
        //   else 
        //     end = middle - 1

        // binarySearch (subarray )
        
        // Binary search - find value in left array
        // Binary search - find value in right array
        // or tricky binary search with start = minIndex and end = mindIndex - 1
        // O(logN)
        
        // Solution 2
        // sort
        // Then binary search...
        // NlogN
        
        // Solution 3
        // Simple foreach
        // O(N)

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                if (nums[left] <= nums[mid] && nums[left] > target) { 
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[right] >= nums[mid] && nums[right] < target) { 
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
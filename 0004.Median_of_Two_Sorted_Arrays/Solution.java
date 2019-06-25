class Solution {
    // O(n), but not O(logn)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] allNumbers = new int[nums1.length + nums2.length];

        int allIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < nums1.length || rightIndex < nums2.length) {
            if (leftIndex == nums1.length) {
                allNumbers[allIndex] = nums2[rightIndex];
                rightIndex++;
            } else if (rightIndex == nums2.length) {
                allNumbers[allIndex] = nums1[leftIndex];
                leftIndex++;
            } else if (nums1[leftIndex] < nums2[rightIndex]) {
                allNumbers[allIndex] = nums1[leftIndex];
                leftIndex++;
            } else {
                allNumbers[allIndex] = nums2[rightIndex];
                rightIndex++;
            }
            allIndex++;
        }

        int middleIndex = (allNumbers.length - 1) / 2;

        if (allNumbers.length % 2 == 1) {
            return allNumbers[middleIndex];
        }

        int middleOne = allNumbers[middleIndex];
        int middleTwo = allNumbers[middleIndex + 1];

        return ((double) (middleOne + middleTwo)) / 2;
    }
}
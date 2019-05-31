class Solution {
    // Kadane algorithm
    public int maxSubArray(int[] nums) {
        int currentMax = Integer.MIN_VALUE;
        int totalMax = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            currentMax = Math.max(currentMax, 0) + nums[i];
            totalMax = Math.max(totalMax, currentMax);
        }
        return totalMax;
    }
}
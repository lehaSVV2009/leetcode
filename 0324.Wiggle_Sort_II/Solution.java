class Solution {
    public void wiggleSort(int[] nums) {
        int[] sortedCopy = IntStream.of(nums).sorted().toArray();

        int length = nums.length;
        int secondHalfFirstIndex = ((length - 1) / 2) + 1;

        int wiggledIndex = 0;
        for (int i = secondHalfFirstIndex - 1, j = length - 1; i >= 0; i--, j--) {
            nums[wiggledIndex] = sortedCopy[i];
            wiggledIndex++;

            if (j >= secondHalfFirstIndex) {
                nums[wiggledIndex] = sortedCopy[j];
                wiggledIndex++;
            }
        }
    }
}

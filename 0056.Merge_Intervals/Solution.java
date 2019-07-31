class Solution {
    public int[][] merge(int[][] intervals) {
        // [1, 45], [2, 67], [3, 50] => overlapped
        // All intervals are valid? i.e. start number is less than end number
        // [1, 4], [4, 5] => overlapped
        // negative?
        // [-6, 45], [46, 55] => not overlapped
        
        // Solution 1
        // O N^2
        // Check every interval 
        // if firstStart >= secondStart && firstStart <= secondEnd 
        //    or firstEnd >= secondStart && firstEnd <= secondEnd
        // => replace value with [Math.min(firstStart, secondStart), Math.min(firstEnd, secondEnd) + remove second
        // or add to the end of check array...

        // Solution 2 - find independant intervals?

        // Solution 3 - sort by 1st element
        // After sort go from the 1st element
        // If first element is part of next -> merge else ++
        // O NlogN

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int resultLength = intervals.length;

        for (int i = 0; i < intervals.length - 1; ++i) {
            int[] first = intervals[i];
            int[] second = intervals[i + 1];

            if (isOverlapping(first, second)) {
                intervals[i + 1][0] = Math.min(first[0], second[0]);
                intervals[i + 1][1] = Math.max(first[1], second[1]);

                intervals[i] = null;
                resultLength--;
            }
        }

        int[][] result = new int[resultLength][2];
        int resultIndex = 0;
        for (int i = 0; i < intervals.length; ++i) {
            if (intervals[i] != null) {
                result[resultIndex][0] = intervals[i][0];
                result[resultIndex][1] = intervals[i][1];
                resultIndex++;
            }
        }

        return result;
    }
    
    private boolean isOverlapping(int[] first, int[] second) {
        int firstStart = first[0];
        int firstEnd = first[1];

        int secondStart = second[0];
        int secondEnd = second[1];
        return (firstStart >= secondStart && firstStart <= secondEnd) 
            || (firstEnd >= secondStart && firstEnd <= secondEnd)
            || (secondStart >= firstStart && secondStart <= firstEnd)
            || (secondEnd >= firstStart && secondEnd <= firstEnd);
    }
}
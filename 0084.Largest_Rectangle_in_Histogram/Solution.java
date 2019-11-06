class Solution {
    public int largestRectangleArea(int[] heights) {
        // 0 heights?
        // tricky thing - high then low
        // overflow?
        
        // []
        // [2,1,5,6,2,3]
        // [1, 1, 1, 1, 5]
        // [1, 1, 1, 1, 4]
        // [1, 2, 3, 4, 5]
        // [5, 4, 3, 4, 5]
        
        // Solution 1
        // maxRectrangleSize
        // foreach
        //   width = 1
        //   height = element
        //   rectangle = height * width
        //   if rectangle > maxRectrangleSize
        //     maxRectrangleSize = rectangle
        //   while (leftIndex != -1 && rightIndex != length)
        //     heigth = Math.min(left, right, height)
        //     rectangle = height * width
        //     if rectangle > maxRectrangleSize
        //       maxRectrangleSize = rectangle
        //     
        //     if (leftIndex == 0)
        //       rightIndex++
        //     else if rightIndex == length - 1
        //       leftIndex--
        //     else if heights[leftIndex - 1] > heights[rightIndex + 1]
        //       leftIndex--
        //     else
        //       rightIndex++
        //     width++
        // O(N^2)

        // Solution 2
        // Stack???
        // [2,1,5,6,2,3]

        // [0]
        // 2 >= 1 => area = 2 * 1 => maxArea = 2
        // [1]
        // 1 >= 5 FAILED
        // [1, 2]
        // 5 >= 6 FAILED
        // [1, 2, 3]
        // 6 >= 2 => area = 6 * (4 - 2 - 1) => maxArea = 6
        // 5 >= 2 => area = 5 * (4 - 1 - 1) => maxArea = 10
        // [1, 4]
        // [1, 4, 5]
        Deque<Integer> stack = new ArrayDeque<>(); 
        int maxArea = 0, n = heights.length; 
        for (int i = 0; i < heights.length; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                int area = heights[stack.pop()] * (stack.isEmpty() ? i : i - stack.peek() - 1);   
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i); 
        }
        
        // [1, 4, 5]
        // area = 3 * (6 - 4 - 1) = 3
        // [1, 4]
        // area = 2 * (6 - 1 - 1) = 8
        // [1]
        // area = 1 * 6 = 6
        while(!stack.isEmpty()) {
            int area = heights[stack.pop()] * (stack.isEmpty() ? n : n - stack.peek() - 1);   
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;         
    }
}
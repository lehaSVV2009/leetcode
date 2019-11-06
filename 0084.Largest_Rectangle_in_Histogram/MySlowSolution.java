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
        // Stack?
        // [2,1,5,6,2,3]
        // 2 ways -> left-right
        // array of min neighbors
        // stack of rectangles? 
        // width = 1
        // [2]
        // pop 2
        // push 2-1
        // pop

        int maxRectangleSize = 0;

        for (int i = 0; i < heights.length; ++i) {
            int width = 1;
            int height = heights[i];

            int leftIndex = i;
            int rightIndex = i;
            while (leftIndex != -1 && rightIndex != heights.length) {
                height = Math.min(height, Math.min(heights[leftIndex], heights[rightIndex]));
                int rectangle = height * width;
                
                if (rectangle > maxRectangleSize) {
                    maxRectangleSize = rectangle;
                }

                if (leftIndex == 0) {
                    rightIndex++;
                } else if (rightIndex == heights.length - 1) {
                    leftIndex--;
                } else if (heights[leftIndex - 1] > heights[rightIndex + 1]) {
                    leftIndex--;
                } else {
                    rightIndex++;
                }
                width++;
            }
        }

        return maxRectangleSize;
        
    }
}
class Solution {
    public int maxArea(int[] heights) {       
        // most square
        // 7*7 = 49
        // [1, 1, 1, 1, 1, 1, 1, 1] => 7
        // [1,8,6,2,5,4,8,3,7] => 49

        // ?array is valid?
        // ?array is empty?
        // ?array is one element? 0?
        // ?array is 2 elemenets
        // ?array height is 0
        // ?array heigth = Integer.MAX_VALUE?
        
        // Solution 1
        // brute force
        // maxSqaure = 0;
        // foreach i
        //   foreach j = i + 1
        //     square = ((j - i) * Math.min(heights[i], heights[j]))
        //     if square > maxSquare
        //        maxSquare = square
        // O(N^2)
        
        // Solution 2
        // 2 pointers
        // maxSquare = 0
        // left, right
        // while (left < right)
        //   width = right - left;
        //   square = (width * Math.min(heights[right], heights[left]))
        //   if square > maxSquare
        //     maxSquare = square
        //   if (height[left] < height[right])
        //     left++
        //   else
        //     right++
        // O(N)

        // [1, 1, 1] -> ok
        // [1, 2, 3] -> ok
        // [3, 2, 1] -> ok
        // [9, 4, 3, 2, 20, 1, 5, 4] -> ok
        // 7*4 = 28
        // 6*5 = 30
        // 5*1 = 5
        // 4*9 = 36
        // [6, 4, 3, 2, 10, 1, 5, 4] -> ok
        // 7*4 = 28
        // 6*5 = 30
        // 5*1 = 5
        // 6*4 = 24
        // [1,8,6,2,5,4,8,3,7] -> ok
        // 8*1 = 8
        // 7*7 = 49
        
        // neigbour difference?
        // [10,11,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]
        // 1*21 => 21
        // 1*20 => 20
        // 1*19 => 19
        // 1*3 => 3
        // 10*2 => 20
        
        // if equals?
        
        int maxSquare = 0;
        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            int width = right - left;
            int square = width * Math.min(heights[right], heights[left]);
            if (square > maxSquare) {
                maxSquare = square;
            }
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxSquare;
    }
}
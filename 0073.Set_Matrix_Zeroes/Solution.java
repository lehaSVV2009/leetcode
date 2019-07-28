class Solution {
    public void setZeroes(int[][] matrix) {
        // Solution 1
        // 1. Go through every item in matrix
        // 2. If an element is zero, set all row and column items as +2 (if they are not 0)
        //    If an element is 1, skip
        //    If an element is 2, set all row and column items as +2 if they are less than 2
        //    If an element is 3, skip
        // 3. Go through the matrix again and replace all 2 and 3 with 0
        // O(M*N*(M+N))
        // No extra memory

        // Solution 2
        // Create separate matrixCopy and put 1, if skipped and 0 on row and column if not 
        // Extra memory
        // O(M*N) memory

        // Solution 3
        // DP???
        // But no extra memory...

        // Solution 4
        // Go trough matrix and find all rows and columns with 0
        // If already in list - skip
        // For all 0 rows set 0
        // For all 0 columns set 0
        // O(N^2)
        // O(M+N) memory

        // Solution 5
        // Mix of 1 and 4
        // int rowIndex
        // List<Integer> columns
        // O()

        // Solution 6
        // Go trough all matrix elements starting from matrix[1][1].
        // If element has 0, set matrix[i][0] = 0 and matrix[0][j] = 0

        if (matrix.length == 0) {
            return;
        }

        boolean firstRowHasZero = false;
        boolean firstColumnHasZero = false;

        // Check 1st row and 1st column on 0 existence
        for (int i = 0; i < matrix.length; ++i) {
            if (matrix[i][0] == 0) {
                firstColumnHasZero = true;
                break;
            }
        }
        for (int j = 0; j < matrix[0].length; ++j) {
            if (matrix[0][j] == 0) {
                firstRowHasZero = true;
                break;
            }
        }
        
        // If matrix[5][7] is 0, set matrix[5][0] and matrix[0][7] as 0 
        for (int i = 1; i < matrix.length; ++i) {
            for (int j = 1; j < matrix[i].length; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Mark all needed elements from matrix[1][1] as 0 if 1st rows/columns are 0
        for (int i = 1; i < matrix.length; ++i) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < matrix[i].length; ++j) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 1; j < matrix[0].length; ++j) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < matrix.length; ++i) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstColumnHasZero) {
            for (int i = 0; i < matrix.length; ++i) {
                matrix[i][0] = 0;
            }
        }
        if (firstRowHasZero) {
            for (int j = 0; j < matrix[0].length; ++j) {
                matrix[0][j] = 0;
            }
        }
    }
}
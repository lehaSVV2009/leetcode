class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int number = 1;
    
        int leftBound = 0;
        int topBound = 0;
        int rightBound = n - 1;
        int bottomBound = n - 1;

        while (number != n * n + 1) {
            for (int i = leftBound; i <= rightBound; i++) {
                matrix[topBound][i] = number;
                number++;
            }

            for (int i = topBound + 1; i <= bottomBound; i++) {
                matrix[i][rightBound] = number;
                number++;
            }

            for (int i = rightBound - 1; i >= leftBound; i--) {
                matrix[bottomBound][i] = number;
                number++;
            }

            for (int i = bottomBound - 1; i > topBound; i--) {
                matrix[i][leftBound] = number;
                number++;
            }

            rightBound--;
            bottomBound--;
            leftBound++;
            topBound++;
        }
        
        return matrix;
    }
}

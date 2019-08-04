class Solution {
    public void rotate(int[][] matrix) {
        // Matrix item value limit?
        // Rotate to which side? Is it important?
        // N == M??? YES!

        // Solution 1
        // Easy way, but restricted -> Create another matrix[N][N], O(N*N)

        // Solution 2
        // If value has a limit like 100, go through array and add array[i][j] += 100*array[i][j]
        
        // Solution 3 
        // replace every related 4 items in one time
        
        // 1 2
        // 3 4
        // TO
        // 3 1
        // 4 2

        // range 0...N
        // first = array[0][0]
        // second = array[0][N-1]
        // third = array[N-1][N-1]
        // fourth = array[N-1][0]
        // FOUR_SWAP
        // array[0][0] = fourth;
        // array[0][N-1] = first;
        // array[N-1][N-1] = second;
        // array[N-1][0] = third;

        // range i = 0..N/2 - 1
            // range j = i...N-1-i, 
            // first = array[i][j]
            // second = array[j][N-1-i]
            // third = array[N-1-i][N-1-j]
            // fourth = array[N-1-j][i]

        // TODO j must depend on i
        // TODO test 5*5 and its center
        // TODO test 1*1
        // TODO test i < N/2
        int n = matrix.length;
        
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n/2; ++i) {
            for (int j = i; j <= (n - 1 - i) - 1; ++j) {
                fourSwap(i, j, n, matrix);
            }
        }
    }

    private void fourSwap(int i, int j, int n, int[][] matrix) {
        int top = matrix[i][j];
        int right = matrix[j][n-1-i];
        int bottom = matrix[n-1-i][n-1-j];
        int left = matrix[n-1-j][i];

        matrix[i][j] = left;
        matrix[j][n-1-i] = top;
        matrix[n-1-i][n-1-j] = right;
        matrix[n-1-j][i] = bottom;
    }
}
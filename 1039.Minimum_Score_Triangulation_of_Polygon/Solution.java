class Solution {
    
    // 1, 2, 3 => 1    
    //    1
    //   / \
    //  3 - 2

    // 1, 2, 3, 4 => 2 combinations of 2 triangles
    //    1 - 2
    //    |   |
    //    4 - 3    
    // 2-4, 1-3
    // 2-4 => 1*2*4 + 2*4*3 = 32
    // 1-3 => 1*2*3 + 1*3*4 = 18 WIN

    // 1, 2, 3, 4, 5 => 
    // 
    //  1 - 2 
    //  |   |
    //  5   3
    //   \ /
    //    4
    //
    // 3 triangles
    
    // 1-2-3 + 3-4-5 + 1-3-5, 1-2-3 + 1-4-5 + 1-3-4
    // 1-2-4 + 1-5-4 + 2-3-4
    // 1-2-5 + 2-5-3 + 3-5-4, 1-2-5 + 2-5-4 + 2-3-4

    
    // 1, 3, 1, 4, 1, 5 => 
    // 
    //    1 - 3 
    //   / \   \
    //  5   \   1
    //   \   \ /
    //    1 - 4
    //
    // 4 triangles
    
    // 1, 3, 1, 4, 1, 5, 6
    // 
    //  6 - 1 - 3 
    //  | /   \ |
    //  5  ---  1
    //   \  \  /
    //    1 - 4
    // 5 triangles

    // 1-1-1 + 1-1-5 + 1-1-3 + 1-1-4

    // 1, 3, 1, 1, 1, 5
    //
    //    1 - 3 
    //   /     \
    //  5       1
    //   \     /
    //    1 - 1


    
    //    1 - 2
    //    |   |
    //    4 - 3    
    // dp = [][], n = 4, 
    // d = 2, i = 0, j = 2, k = 1
    // dp[0][2] = MAX
    // dp[0][2] = 0+0+1*2*3 = 6
    // d = 2, i = 1, j = 3, k = 2
    // dp[1][3] = MAX
    // dp[1][3] = 0+0+2*4*3 = 24
    // d = 3, i = 0, j = 3, k = 1
    // dp[0][3] = MAX
    // dp[0][3] = 0 + 0 + 1*4*2 = 8
    // d = 3, i = 0, j = 3, k = 2
    // dp[0][3] = min(8, 6 + 0 + 1*4*3) = 8
    // ... Just copied... Dynamic programming solution
  public int minScoreTriangulation(int[] A) {
      if (A.length == 3) {
          return A[0] + A[1] + A[2];
      }
      
      int n = A.length;
      int[][] dp = new int[n][n];
      for (int d = 2; d < n; ++d) {
          for (int i = 0; i + d < n; ++i) {
              int j = i + d;
              dp[i][j] = Integer.MAX_VALUE;
              for (int k = i + 1; k < j; ++k) {
                  dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + A[i] * A[j] * A[k]);
              }
          }
      }
      return dp[0][n - 1];
  }
}
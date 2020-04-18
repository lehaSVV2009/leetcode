/**
 * @param {number[][]} grid
 * @return {number}
 */
var minPathSum = function(grid) {
    // [] ? 0
    // [[]] ? failed
    // [[0]] ? 0
    // [[1]] ? 1
    // [[1, 2]] ? 3
    // [[1, 2, 3, 4]] ? 10
    // [[1], [2], [3], [4]] ? 10
    // 
    // [
    //   [0, 0, 0],
    //   [2, 2, 3],
    //   [2, 2, 3]
    // ]
    // ? 6
    //
    // Solution 1
    // Brute force
    // check empty grid
    // go right or go down for first cell
    //
    // deepRightOrDown (rowIndex, colIndex, grid)
    // if rowIndex === grid.length - 1 && colIndex == grid[rowIndex].length - 1
    //   return grid[rowIndex][colIndex]
    // if not possible to right
    //   return deepRightOrDown(rowIndex + 1, colIndex, grid) + grid[rowIndex][colIndex]
    // if not possible to down
    //   return deepRightOrDown(rowIndex, colIndex + 1, grid) + grid[rowIndex][colIndex]
    //
    // right = deepRightOrDown(rowIndex, colIndex + 1, grid) + grid[rowIndex][colIndex]
    // down = deepRightOrDown(rowIndex + 1, colIndex, grid) + grid[rowIndex][colIndex]
    // return Math.min(right, down) + grid[rowIndex][colIndex] ??? (can it skip min path that max in the end?)

    // Solution 2
    // dp
    // ?
    // [[1,3,1],[1,5,1],[4,2,1]]
    // [[3,8,6,0,5,9,9,6,3,4,0,5,7,3,9,3],[0,9,2,5,5,4,9,1,4,6,9,5,6,7,3,2],[8,2,2,3,3,3,1,6,9,1,1,6,6,2,1,9],[1,3,6,9,9,5,0,3,4,9,1,0,9,6,2,7],[8,6,2,2,1,3,0,0,7,2,7,5,4,8,4,8],[4,1,9,5,8,9,9,2,0,2,5,1,8,7,0,9],[6,2,1,7,8,1,8,5,5,7,0,2,5,7,2,1],[8,1,7,6,2,8,1,2,2,6,4,0,5,4,1,3],[9,2,1,7,6,1,4,3,8,6,5,5,3,9,7,3],[0,6,0,2,4,3,7,6,1,3,8,6,9,0,0,8],[4,3,7,2,4,3,6,4,0,3,9,5,3,6,9,3],[2,1,8,8,4,5,6,5,8,7,3,7,7,5,8,3],[0,7,6,6,1,2,0,3,5,0,8,0,8,7,4,3],[0,4,3,4,9,0,1,9,7,7,8,6,4,6,9,5],[6,5,1,9,9,2,2,7,4,2,7,2,2,3,7,2],[7,1,9,6,1,2,7,0,9,6,6,4,4,5,1,0],[3,4,9,2,8,3,1,2,6,9,7,0,2,4,2,0],[5,1,8,8,4,6,8,5,2,4,1,6,2,2,9,7]]
    // 
    if (!grid || grid.length === 0) {
        return 0;
    }

    const memo = Array(grid.length);
    for (let i = 0; i < memo.length; ++i) {
        memo[i] = Array(grid[0].length);
    }
    memo[0][0] = grid[0][0];

    for (let j = 1; j < grid[0].length; ++j) {
        memo[0][j] = memo[0][j - 1] + grid[0][j];
    }

    for (let i = 1; i < grid.length; ++i) {
        const row = grid[i];
        for (let j = 0; j < row.length; ++j) {
            memo[i][j] = row[j] + 
                (j === 0 ? memo[i - 1][j] : Math.min(memo[i][j - 1], memo[i - 1][j]));
        }
    }
    
    return memo[grid.length - 1][grid[0].length - 1];
};

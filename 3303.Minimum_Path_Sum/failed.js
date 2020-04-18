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
    if (!grid || grid.length === 0) {
        return 0;
    }
    
    return deepRightOrDown(0, 0, grid);
};

function deepRightOrDown(rowIndex, colIndex, grid) {
    const currentValue = grid[rowIndex][colIndex];
    if (rowIndex === grid.length - 1 && colIndex === grid[rowIndex].length - 1) {
        return currentValue;
    }
    if (rowIndex + 1 >= grid.length) {
        // go right on bottom border
        return deepRightOrDown(rowIndex, colIndex + 1, grid) + currentValue;
    }
    if (colIndex + 1 >= grid[rowIndex].length) {
        // go down on right border
        return deepRightOrDown(rowIndex + 1, colIndex, grid) + currentValue;
    }

    const right = deepRightOrDown(rowIndex, colIndex + 1, grid);
    const down = deepRightOrDown(rowIndex + 1, colIndex, grid);
    return Math.min(right, down) + currentValue;
}
/**
 * @param {character[][]} matrix
 * @return {number}
 */
var maximalSquare = function(matrix) {
    
    // Can I change this matrix?
    //
    // 1 1 => 1 1
    // 1 1    1 2 (if left, top and left top is 1)

    // 1 1 1 => 1 1 1 (if number is 1 and left === top === left top && >= 1 => number is left + 1)
    // 1 1 1    1 2 2
    // 1 1 1    1 2 3
    
    // 1 1 => 1 1
    // 1 0    1 0
    
    // 1 1 1 1 => 1 1 1 1
    // 1 1 1 1    1 2 2 2
    // 1 1 1 0    1 2 3 0

    // 1 1 1 1 => 1 1 1 1
    // 1 1 1 1    1 2 2 2
    // 0 1 1 1    0 1 2 3

    // 1 1 1 1 => 1 1 1 1
    // 1 1 1 1    1 2 2 2
    // 0 1 1 1    0 1 2 3
    // 0 1 1 1    0 1 2 3

    // if number is 1 and left and top and left top exist and they all are greater than 0 then
    // if left and top are equal then write left + 1
    // if left and top are different then write Max(left, top)
    
    // 1 1 1 1 1 => 1 1 1 1 1
    // 1 1 1 1 1    1 2 2 2 2
    // 0 1 1 1 1    0 1 2 3 3
    // 0 1 1 1 1    0 1 2 3 4

    // 1 1 1 1 1 => 1 1 1 1 1
    // 1 1 1 1 1    1 2 2 2 2
    // 0 0 1 1 1    0 0 1 2 3
    // 0 1 1 1 1    0 1 1 2 3

    // 1 1 1 1 1 => 1 1 1 1 1
    // 0 0 1 1 1    0 0 1 2 2
    // 0 1 0 1 1    0 1 0 1 2

    // 0 0 0 => 0 0 0
    // 0 1 1    0 1 1
    // 0 1 1    0 1 2
    
    // 1 1 1 1 1 => 1 1 1 1 1
    // 1 1 1 1 1    1 2 2 2 2
    // 0 0 0 1 1    0 0 0 1 2
    // 0 1 1 1 1    0 1 1 1 2

    // 1 1 0 0 => 1 1 0 0
    // 1 1 1 0    1 2 1 0
    // 1 1 1 1    1 2 2 1
    // 1 0 1 1    1 0 1 2
    
    // 0 0 => 0 0 (if number is 1 and result < 1 result = 1)
    // 0 1    0 0

    // 1 0 0 0
    // 0 1 0 0    
    // 0 0 1 0
    // 0 0 0 1
    
    // 1 0 1 0 0 => 1 0 1 0 0
    // 1 0 1 1 1    1 0 1 1 1
    // 1 1 1 1 1    1 1 1 2 2
    // 1 0 0 1 0    1 0 0 1 0
    
    // [["1","1","1","0","0"],
    //  ["1","1","1","0","0"],
    //  ["1","1","1","1","1"],
    //  ["0","1","1","1","1"],
    //  ["0","1","1","1","1"],
    //  ["0","1","1","1","1"]]

    // 1 1 1 0 0
    // 1 2 2 0 0
    // 1 2 3 1 1
    // 0 1 3 1 1
    // 0 1 3 3 3
    // 0 1 3 3 4
    
    // [["1","0","1","0","0","1","1","1","0"],
    //  ["1","1","1","0","0","0","0","0","1"],
    //  ["0","0","1","1","0","0","0","1","1"],
    //  ["0","1","1","0","0","1","0","0","1"],
    //  ["1","1","0","1","1","0","0","1","0"],
    //  ["0","1","1","1","1","1","1","0","1"],
    //  ["1","0","1","1","1","0","0","1","0"],
    //  ["1","1","1","0","1","0","0","0","1"],
    //  ["0","1","1","1","1","0","0","1","0"],
    //  ["1","0","0","1","1","1","0","0","0"]]
    
    // 1 0 1 0 0 1 1 1 0
    // 1 1 1 0 0 0 0 0 1
    // 0 0 1 1 0 0 0 1 1
    // 
    
    // Solution 1
    // straight forward
    // O(N^3)
    // result
    // foreach i
    //   foreach j
    //     if item is 1
    //     try to go down and right until 0 on any checked row/column
    //     (foreach checked cols in checkedrow)
    //     (foreach checked rows in checkedcol)
    //     result = Math.max(result, length)
    
    // Solution 2
    // store visited somehow
    // dynamice programming?

    let result = 0;
    
    for (let i = 0; i < matrix.length; ++i) {
        for (let j = 0; j < matrix[i].length; ++j) {
            const cell = matrix[i][j] == 1 ? 1 : 0;
            matrix[i][j] = cell;
            if (cell === 0) {
                continue;
            }
            // cell === 1
            result = Math.max(result, cell);
            if (i === 0 || j === 0) {
                continue;
            }
            const left = matrix[i][j - 1];
            const top = matrix[i - 1][j];
            const leftTop = matrix[i - 1][j - 1];
            if (left === 0 || top === 0 || leftTop === 0) {
                continue;
            }
            matrix[i][j] = Math.min(left, top, leftTop) + 1;
            result = Math.max(result, matrix[i][j]);
        }
    }
    
    return result ** 2;
};
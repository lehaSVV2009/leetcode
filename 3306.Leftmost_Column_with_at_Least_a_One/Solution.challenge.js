/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * function BinaryMatrix() {
 *     @param {integer} x, y
 *     @return {integer}
 *     this.get = function(x, y) {
 *         ...
 *     };
 *
 *     @return {[integer, integer]}
 *     this.dimensions = function() {
 *         ...
 *     };
 * };
 */

/**
 * @param {BinaryMatrix} binaryMatrix
 * @return {number}
 */
var leftMostColumnWithOne = function(binaryMatrix) {
    // [[0,0],[1,1],[0,1]] ? is it possible? y - s
    // different n and m - possible
    // matrix.get(i, j) or matrix.get(j, i)
    
    // Solution 1
    // NlogM
    // Run binary search for all rows
    // Store list of start/end
    
    // Solution 2
    // NlogM
    // binarySearch with best end only

    const [rowsLength, colsLength] = binaryMatrix.dimensions();

    let leftMostIndex = colsLength;

    for (let rowIndex = 0; rowIndex < rowsLength; ++rowIndex) {
        let result = -1;

        let start = 0;
        let end = colsLength - 1;
        while (start <= end && start < leftMostIndex) {
            const medium = Math.floor((start + end) / 2);
            const value = binaryMatrix.get(rowIndex, medium);

            if (value === 1) {
                result = medium;
                end = medium - 1;
            } else {
                start = medium + 1;
            }
        }

        if (result !== -1) {
            leftMostIndex = Math.min(leftMostIndex, result);
        }
    }
    
    return leftMostIndex === colsLength ? -1 : leftMostIndex;
};
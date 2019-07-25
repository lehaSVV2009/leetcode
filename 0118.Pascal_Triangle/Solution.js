/**
 * @param {number} numRows
 * @return {number[][]}
 */
var generate = function(numRows) {
  // num rows maximum value?
  // num rows minimum value?
  // element is a sum of next

  // result = []; ([[1], [1, 1], [1, 2, 1], [1, 3, 3, 1]])
  // rowLength = 1
  // range (i = 0...numRows)
  //   range (j = 0...rowLength)
  //     if (j == 0 || j == rowLength - 1) => arr[j] = 1
  //     arr[j] = result[i - 1][j] + result[i - 1][j - 1] or 0

  if (numRows < 0) {
      return [];
  }
  if (numRows === 1) {
      return [[1]];
  }
  
  const result = [];

  let rowLength = 1;
  for (let i = 0; i < numRows; ++i) {
      const row = [];
      for (let j = 0; j < rowLength; ++j) {
          if (j === 0 || j === rowLength - 1) {
              row.push(1);
              continue;
          }

          const previous1 = result[i - 1][j - 1];
          const previous2 = result[i - 1][j];
          row.push(previous1 + previous2);
      }
      rowLength++;
      result.push(row);
  }
  
  return result;
};
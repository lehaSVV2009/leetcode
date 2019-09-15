function getNumberOfIslands(binaryMatrix) {
  // your code goes here

  let islandsCount = 0;
  
  for (let rowNumber = 0; rowNumber < binaryMatrix.length; ++rowNumber) {
    var row = binaryMatrix[rowNumber];
    for (let columnNumber = 0; columnNumber < row.length; columnNumber++) {
      var column = row[columnNumber];
      if (column === 1) {
        floodFill(rowNumber, columnNumber, binaryMatrix);
        islandsCount++;
      }
    }
  }

  return islandsCount;

}

// foreach // N loops 
//  foreach // N loops
//    for 50% of cases you call floodFill which marks single cell O(1)

// => O(N^2)

// 1 0 1 0 1
// 0 1 0 1 0
// 1 0 1 0 1


// foreach // N loops 
//  foreach // N loops
//    for 2 of cases you call floodFill which marks whole row O(N)
// not N^3 but only N^2

// 1 1 1 1 1
// 0 0 0 0 0
// 1 1 1 1 1
// 0 0 0 0 0

// it is depth first search
function floodFill (rowNumber, columnNumber, matrix) { // count calls of floodFill
                                                       // it will be 4*(N^2)
  const rowsLength = matrix.length;
  const columnsLength = rowsLength === 0 ? 0 : matrix[0].length;

  if (
    rowNumber < 0 
    || rowNumber >= rowsLength
    || columnNumber < 0
    || columnNumber >= columnsLength
    || matrix[rowNumber][columnNumber] === 0) {
    return;
  }

  matrix[rowNumber][columnNumber] = 0; // count those calls

  floodFill(rowNumber, columnNumber + 1, matrix);
  floodFill(rowNumber + 1, columnNumber, matrix);
  floodFill(rowNumber, columnNumber - 1, matrix);
  floodFill(rowNumber - 1 , columnNumber, matrix);
}

console.log(getNumberOfIslands([[0, 1, 1], [0, 1, 0], [0, 0, 0]]))
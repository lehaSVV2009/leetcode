/**
 * @param {character[][]} grid
 * @return {number}
 */

// [["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]
// [["1","1","0","0","0"],["1","1","0","0","0"],["0","0","1","0","0"],["0","0","0","1","1"]]
var numIslands = function(grid) {
  // for each row
  //   for each column
  //     if visited
  //       skip
  //     if island
  //       increment islands count
  //       go to right, to bottom, to left, to top until water or visited
  //       mark everything as visited
  
  let islandsCount = 0;

  for (let rowIndex = 0; rowIndex < grid.length; rowIndex++) {
      const row = grid[rowIndex];
      for (let colIndex = 0; colIndex < row.length; colIndex++) {
          const cell = row[colIndex];
          if (cell === '1') {
              islandsCount++;
              floodFill(rowIndex, colIndex, grid);
          }
      }
  }

  return islandsCount;
};

function floodFill(rowIndex, colIndex, grid) {
  if (rowIndex < 0
      || rowIndex >= grid.length
      || colIndex < 0
      || colIndex >= grid[rowIndex].length
      || grid[rowIndex][colIndex] !== '1') {
      return;
  }
  
  grid[rowIndex][colIndex] = '0';
  
  floodFill(rowIndex, colIndex + 1, grid);
  floodFill(rowIndex + 1, colIndex, grid);
  floodFill(rowIndex, colIndex - 1, grid);
  floodFill(rowIndex - 1, colIndex, grid);
}
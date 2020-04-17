/**
 * @param {character[][]} grid
 * @return {number}
 */

// [["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]
// [["1","1","0","0","0"],["1","1","0","0","0"],["0","0","1","0","0"],["0","0","0","1","1"]]
var numIslands = function(grid) {
  // Solution 1
  // for each row
  //   for each column
  //     if visited
  //       skip
  //     if island
  //       increment islands count
  //       go to right, to bottom, to left, to top until water or visited
  //       mark everything as visited

  // Solution 2
  // Find all 1 cells
  // Unite all 1 neigbour cells
  
  if (!grid || grid.length === 0) {
    return 0;
  }

  const rowsLength = grid.length;
  const colsLength = grid[0].length;

  const unionFind = new UnionSet(grid);

  for (let rowIndex = 0; rowIndex < rowsLength; ++rowIndex) {
      for (let colIndex = 0; colIndex < colsLength; ++colIndex) {
          if (grid[rowIndex][colIndex] === '1') {
              grid[rowIndex][colIndex] = '0';
              if (rowIndex - 1 >= 0 && grid[rowIndex - 1][colIndex] === '1') {
                  unionFind.union(rowIndex * colsLength + colIndex, (rowIndex - 1) * colsLength + colIndex);
              }
              if (rowIndex + 1 < rowsLength && grid[rowIndex + 1][colIndex] === '1') {
                  unionFind.union(rowIndex * colsLength + colIndex, (rowIndex + 1) * colsLength + colIndex);
              }
              if (colIndex - 1 >= 0 && grid[rowIndex][colIndex - 1] === '1') {
                  unionFind.union(rowIndex * colsLength + colIndex, rowIndex * colsLength + colIndex - 1);
              }
              if (colIndex + 1 < colsLength && grid[rowIndex][colIndex + 1] === '1') {
                  unionFind.union(rowIndex * colsLength + colIndex, rowIndex * colsLength + colIndex + 1);
              }
      }
    }
  }

  return unionFind.count;
};


class UnionSet {
  constructor (grid) {
      this.count = 0;
      this.parent = Array(grid.length * grid[0].length);
      this.rank = Array(grid.length * grid[0].length);

      for (let rowIndex = 0; rowIndex < grid.length; ++rowIndex) {
          for (let colIndex = 0; colIndex < grid[0].length; ++colIndex) {
              const index = rowIndex * grid[0].length + colIndex;
              if (grid[rowIndex][colIndex] === '1') {
                  this.parent[index] = index;
                  this.count++;
              }
              this.rank[index] = 0;
          }
      }
  }

  find = index => {
      if (this.parent[index] !== index) {
          this.parent[index] = this.find(this.parent[index]);
      }
      return this.parent[index];
  }
  
  union = (leftIndex, rightIndex) => {
      const leftParent = this.find(leftIndex);
      const rightParent = this.find(rightIndex);
      if (leftParent !== rightParent) {
          if (this.rank[leftParent] > this.rank[rightParent]) {
              this.parent[rightParent] = leftParent;
          } else if (this.rank[leftParent] < this.rank[rightParent]) {
              this.parent[leftParent] = rightParent;
          } else {
              this.parent[rightParent] = leftParent;
              this.rank[leftParent]++;
          }
          --this.count;
      }
  }
}
/**
 * @param {number[]} stones
 * @return {number}
 */
var lastStoneWeight = function(stones) {
  // [] ? not possible
  // [1] ? 1
  // [5] ? 5
  // [1,1] ? 0 
  // [1,6] ? 5
  // [1,2,3] ? 0
  // [1,2,4] ? 1

  stones.sort((a, b) => b - a);

  while (stones.length > 1) {
      const [firstMax, secondMax] = stones.splice(0, 2);
      
      const diff = firstMax - secondMax;
      
      if (diff > 0) {
          stones.push(diff);
          stones.sort((a, b) => b - a);
      }
  }
  
  return stones.length === 0 ? 0: stones[0];
  // Solution 1
  // Sort NlogN
  // while array.length > 1
  //   Smash 2 max elements (remove elements from array)
  //   Calculate diff
  //   (or simpler, but slower - insert diff to array and sort)
  //   Find position for diff by binary search logN
  //   Insert diff to position N
  
  // Option LinkedList - find will take O(N), but insert will take O(1)
  
  // Solution 2
  // Same, but with tree as data structure
  // find 2 max will take O(log N)
  // insert will take O(log N)

  // Solution 3
  // Priority queue
  
  // Solution 2
  // Figure out simpler logic
};

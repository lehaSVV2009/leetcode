/**
 * @param {number[]} arr
 * @return {number}
 */
var countElements = function(arr) {
  // Unsorted
  // [1,3,2,3,5,0,1,2]
  // [0,1,1,2,2]? 3

  // Solution 1
  // Try to modify [0,1,1,2,2] to [0,1,2] and [1,2]
  
  // Solution 2
  // Sort array and calculate and

  // Solution 3 O(N)
  // Convert to map with { 0: 1, 1: 2, 2:2 }
  // result = 0
  // for (key in map)
  //   if map[key + 1] 
  //     result += Math.min(map[key], map[key+1])

  const map = {};
  
  for (const number of arr) {
      if (!map[number]) {
          map[number] = 1;
      } else {
          map[number]++;            
      }
  }

  let result = 0;
  for (const key in map) {
      const number = Number(key);
      if (map[number + 1]) {
          result += map[number];
      }
  }
  return result;
};
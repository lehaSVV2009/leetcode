/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function(nums) {
  // means length is always odd
  // negative integers?
  
  // Solution 1 
  // extra memory
  // Set<Integer>
  //   1st - add
  //   2nd - remove
  // set.get(0);
  // O(N)
  // memory O(N)
  
  // Solution 2
  // O(N^2)
  // for every find duplicate
  //  not found - return

  // Solution 3
  // 1 | 2 

  // 2 -> 10
  // 2 -> 10
  // 1 -> 01

  // | - 11
  // & - 00
  // xor - 00
  // xor - 01
  
  // 4,1,2,1,2
  
  // 4 -> 100
  // 1 -> 001
  // 2 -> 010
  // 1 -> 001
  // 2 -> 010
  
  // 101
  // 111
  // 110
  // 100

  var result = nums[0];
  for (var i = 1; i < nums.length; ++i) {
      result = result ^ nums[i]; // xor
  }
  return result;
};
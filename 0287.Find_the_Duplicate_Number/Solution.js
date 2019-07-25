/**
 * @param {number[]} nums
 * @return {number}
 */
var findDuplicate = function(nums) {
  // Set<> -> check if already in set, return value;
  // 
  // n+1 integers between 1 and n!!! 
  // 5 numbers between 1 and 4, like [1, 4, 4, 3, 1]
  // sum? 1 2 3 4 X
  // At least one number is a duplicated value
  // 1*2*3*4 = 24
  // 1*2*3*4*1 = 24 => 1
  // 1*2*3*4*4 = 24*4 => 4
  // if duplicated value is one -> SUM(Array) - SUM(Range(1..N-1))
  // Sort??

  // You can think that value is an index of array
  // [1, 2, 3, 4, 4]
  // [4, 3, 2, 1, 1]
  var tortoise = nums[nums[0]],
      hare = nums[nums[nums[0]]]; // hare is 2 times faster than tortoise

  while (tortoise != hare) {
      tortoise = nums[tortoise];
      hare = nums[nums[hare]];
  }

  // [2,5,9,6,9,3,8,9,7,1]
  // tortoise - 9, 1, 5, 3, 6, 8, 7, 9, 1, 5, ...
  // hare - 1, 3, 8, 9, 5, 6, 7
  var ptr1 = nums[0],
      ptr2 = tortoise;

  while(ptr1 != ptr2) {
      ptr1 = nums[ptr1];
      ptr2 = nums[ptr2];
  }

  return ptr1;
};
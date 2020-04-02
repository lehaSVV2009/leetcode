/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function(nums) {
  // even elements length in array?

  // Solution 1
  // Set
  // for every element
  //   check if element is in set
  //   if yes - remove from set
  //   else - add to set
  // at the end check length of get single set element

  // Solution 2
  // xor?

  return nums.reduce((result, value) => result ^ value, 0);
};

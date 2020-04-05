/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
  // [0, 0, 0, 0]? [0, 0, 0, 0]
  // [-1, -1]? [-1, -1]
  // []? []

  // Solution 1
  // Go through array, find all indexes of zeros

  // Solution 2
  // 2 pointers
  // 1st pointer is left zero
  // 2nd pointer is current index
  //
  // j = 0
  // while nums[j] != 0
  //   j++
  // for i = j + 1 ... nums
  //   if nums[i] != 0
  //     swap(i, j)
  //     j++

  // Solution 3
  // Go from the end

  // Solution 4
  // foreach element
  //   lastZero = element
  //   while lastZero is 0
  //     lastZero++
  //   if lastZero > element
  //     remove elements from element to lastZero
  //     push (lastZero - element) zeros to end

  let j = 0;
  while (j < nums.length && nums[j] !== 0) {
    j++;
  }

  for (let i = j + 1; i < nums.length; ++i) {
    if (nums[i] !== 0) {
      nums[j] = nums[i];
      nums[i] = 0;
      j++;
    }
  }
};

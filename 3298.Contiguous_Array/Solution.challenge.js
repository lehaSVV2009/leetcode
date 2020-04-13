/**
 * @param {number[]} nums
 * @return {number}
 */
var findMaxLength = function(nums) {
  // only binary???
  // [0] ? 0
  // [1] ? 0
  // [0, 1] ? 2
  // [1, 0] ? 2
  // [0, 0] ? 0
  // [1, 0] ? 2
  // [1, 0, 1]? 2
  // [0, 0, 1]? 2
  // [1, 0, 0, 1] ? 4
  // [1, 0, 1, 0] ? 4
  // [1, 1, 1, 0, 0] ? 4 BUT NOT 2
  // [1, 0, 0, 1, 1, 0] ? 6
  // [1, 0, 0, 1, 1, 1, 0] ? 6 BUT NOT 4
  // [1, 0, 0, 1, 1, 1, 1] ? 4
  // [1, 0, 0, 0, 1, 1, 1] ? 6
  // [1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0] ? 8
  // [1, 0, 0, 1, 0, 0, 1] ? 4
  // [1, 0, 0, 1, 0, 0, 1, 1] ? 8
  // [1, 0, 0, 1, 0, 0, 1, 0, 0, 1] ? 4
  // [0, 0, 0, 1, 0, 0, 1, 0, 0, 0] ? 4

  // always even

  // Solution 1
  // Straight-forward
  // O(N^2)
  
  // result
  // foreach i...n-2
  //   zeroCount = 0
  //   oneCount = 0
  //   foreach j = i...n-1
  //     if array[j] === 0
  //       zeroCount++
  //     if array[j] === 1
  //       oneCount++
  //     if zeroCount === oneCount
  //       result = Math.max(result, zeroCount + oneCount)
  
  // let result = 0;
  // for (let i = 0; i < nums.length - 1; ++i) {
  //     let zeroCount = 0;
  //     let oneCount = 0;
  //     for (let j = i; j < nums.length; ++j) {
  //         if (nums[j] === 0) {
  //             zeroCount++;
  //         }
  //         if (nums[j] === 1) {
  //             oneCount++;
  //         }
  //         if (zeroCount === oneCount) {
  //             result = Math.max(result, zeroCount + oneCount);
  //         }
  //     }
  // }
  // return result;

  
  // Solution 2
  // Find logic with & or ^ or |
  
  // Solution 3
  // +-+-+-
  
  // Solution 4
  // FAILED in [1, 0, 0, 1, 0, 0, 1] (expected - 4, real - 6)
  // O(N)
  // zeroCount
  // oneCount
  // foreach 
  //   if item is zero
  //     zeroCount++
  //   if item is one
  //     oneCount++
  // return Math.min(zeroCount, oneCount) * 2
  
  // Solution 5
  // 2 pointers
  // 
  
  // Solution 6
  // [1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0] ? 8
  // Map of all 1 and indexes and all 0 and indexes
  // [ 0, 1, 2, 3, 7, 8, 9 ]

  // Solution 7
  // [1, 0, 0, 1, 0, 0, 1]
  // zeroReversed = [1, -1, -1, 1, -1, -1, 1]
  // sum = [1, 0, -1, 0, -1, -2, -1]
  // sumMap = { 1: 0, 0: 1, -1: 2, -2: 5 }
  // maxSum = 4
  //
  // foreach item
  //  if item is 0 item = -1
  //
  // let maxLength = 0
  // let sum
  // foreach item
  //   sum += item
  //   if sum === 0
  //     maxLength = i + 1
  //   if !sumMap.has(sum)
  //     sum.set(sum, i)
  //   else 
  //     maxLength = Math.max(maxLength, i - sumMap.get(sum))
  //
  // return 
  
  let maxLength = 0;
  let sum = 0;
  const sumMap = new Map();
  
  for (let i = 0; i < nums.length; ++i) {
      const number = nums[i] === 0 ? -1 : nums[i];
      sum += number;
      
      if (sum === 0) {
          maxLength = i + 1;
      }
      if (sumMap.has(sum)) {
          maxLength = Math.max(maxLength, i - sumMap.get(sum));
      } else {
          sumMap.set(sum, i);
      }
  }
  
  return maxLength;
};
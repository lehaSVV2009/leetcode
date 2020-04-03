/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
  // []?
  // [1]? 1
  // [1, 2, 3, 4, 5]? [1, 2, 3, 4, 5]
  // [1, 2, -5, 3, 4]? [3, 4]
  // [10, 2, -5, 3, 4]? [10, 2, -5, 3, 4]
  // [4, 10, -5, 43, 4]?
  // [20, -5, 1, 2, 3, 4]
  // [-1, -2, -3, -4, -5]? [-1]
  // [0, 1, 2, 3]? []
  // [0, 1, -50, 1, 0]?

  // Solution 1
  // brute force
  // O(N^2)
  // maxSum = nums[0];
  // foreach element
  //   sum += element
  //   foreach next elements
  //     sum += next element
  //     if sum > maxSum
  //       maxSum = sum

  // Solution 2
  // 2 pointers
  // i, j
  // while j is positive
  // if j is negative and in sum with negative it will be less than maxNumber

  // or i from start, j from end

  // Solution 3
  // divide and conquer
  // find smallest number
  // try to calculate max on left and right (same way)
  // return max of LEFT or RIGHT or LEFT + RIGHT + MIN

  let maxSum = -2147483648;

  for (let i = 0; i < nums.length; ++i) {
    let sum = nums[i];
    if (sum > maxSum) {
      maxSum = sum;
    }

    for (let j = i + 1; j < nums.length; ++j) {
      sum += nums[j];
      if (sum > maxSum) {
        maxSum = sum;
      }
    }
  }

  return maxSum;
};

/**
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function(nums) {
  // [1] ? [0]
  // [1, 2] ? [2, 1]
  // [1, 2, 3] ? [6, 3, 2]
  // [0, 1, 2] ? [1, 0, 0]
  // [2, 2, 2] ? [4, 4, 4]
  // [-1, -1, -1] ? [1, 1, 1]

  // Solution 1
  // Calculate product of all elements
  // Go through all elements, divide product on element and push to array
  
  // Solution 2
  // O(N^2)
  // Brute force
  // result
  // for every i
  //   product = 1
  //   for every j skipping i
  //     product *= nums[j]
  //   result push product
  
  // Solution 3
  // dp like?
  // 2 arrays
  // [1, 2, 3, 4, 5]
  // left - [1, 2, 6, 24, 120]
  // right - [120, 120, 60, 20, 5]
  // go for all elements and get left and right items

  if (nums.length < 2) {
      throw new Error("Length must be at least 2");
  }

  const result = new Array(nums.length);
  result[0] = 1;
  for (let i = 1; i < nums.length; ++i) {
      result[i] =  result[i - 1] * nums[i - 1];
  }

  let rightProduct = 1;
  for (let i = nums.length - 1; i >= 0; --i) {
      result[i] = result[i] * rightProduct;
      rightProduct *= nums[i];
  }

  return result;
};


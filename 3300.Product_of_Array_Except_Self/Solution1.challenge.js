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

    const leftProducts = []
    let leftProduct = 1;
    for (let i = 0; i < nums.length; ++i) {
        leftProduct *= nums[i];
        leftProducts.push(leftProduct);
    }

    const rightProducts = new Array(nums.length);
    let rightProduct = 1;
    for (let i = nums.length - 1; i >= 0; --i) {
        rightProduct *= nums[i];
        rightProducts[i] = rightProduct;
    }

    const result = [];
    for (let i = 0; i < nums.length; ++i) {
        const leftProduct = i - 1 >= 0 ? leftProducts[i - 1] : 1;
        const rightProduct = i + 1 < nums.length ? rightProducts[i + 1] : 1;
        result.push(leftProduct * rightProduct);
    }
    return result;
};


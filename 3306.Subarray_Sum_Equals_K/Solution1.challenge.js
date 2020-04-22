/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var subarraySum = function(nums, value) {
    // 2, [] ? 0
    // 0, [] ? 0
    // 0, [1, -1] ? 1
    // 0, [1, 0, -1, 0] ? 
    // 2, [1, -1, 1, 1] ? 2
    // 2, [1, 1, -1, 1] ? 2
    // 2, [1, 2, -1, 1] ? 3
    // 2, [1, 1, 1, 1] ? 3
    // 2, [1, 1, -1, 1, 1] ? 4

    // Solution 1
    // Brute force
    // O(N^2)

    // Solution 2
    // 2 pointers

    // Solution 3
    // divide and conquer

    // Solution 1
    // sums from left
    // [1, 2, 3]
    // sums from right
    // [3, 2, 1]

    let result = 0;

    for (let i = 0; i < nums.length; ++i) {
        let sum = 0;
        for (let j = i; j < nums.length; ++j) {
            sum += nums[j];
            if (sum === value) {
                result++;
            }
        }
    }

    return result;
};
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */

// [1, 2, 3]
// [2, 3, 1]
// [3, 1, 2]
// [1, 2, 3, 4]
// [2, 3, 4, 1]
// [3, 4, 1, 2]
// [4, 1, 2, 3]
// [2, 3, 4, 5, 1]
// [3, 4, 5, 1, 2]
// [4, 5, 1, 2, 3]
// [3, 4, 1, 2, 3]
// [3, 3, 4, 1, 2]
// [4, 1, 2, 3, 3]
var search = function(nums, target) {
    // duplicates??

    // Solution 1
    // O(logN)
    // 
    // 1. Find min or max value (binary search???)
    // 2. Use binary search, with context of min value (binary search)

    // 1. 
    // Take first value (and maybe last value)
    // Check that greater than last
    // Go via binary search from 1 to length - 1
    // if array[medium] < array[medium - 1] 
    //   return medium

    // 2.
    // every time before Math.floor((start + end) / 2)
    // [5, 6, 7, 1, 2, 3, 4]
    // start = 6, end = 2, pivot = 3
    // start -= pivot // 3
    // if start < 0
    //   start += length
    // end -= pivot
    // if end < 0 // -1
    //   end += length // 6

    // floor((3 + 6) / 2) = 4

    if (!nums || nums.length === 0) {
        return -1;
    }
    if (nums.length === 1) {
        return nums[0] === target ? 0 : -1;
    }

    const shift = nums[0] < nums[nums.length - 1] ? 0 : findPivot(nums);
    if (shift === -1) {
        throw new Error("Invalid array");
    }

    return binarySearchWithShift(nums, target, shift);
};

function findPivot(nums) {
    const firstValue = nums[0];
    let start = 1;
    let end = nums.length - 1;

    while (start <= end) {
        const medium = Math.floor((start + end) / 2);
        if (nums[medium] < nums[medium - 1]) {
            return medium;
        }
        if (nums[medium] > firstValue) {
            start = medium + 1;
        }
        if (nums[medium] <= firstValue) {
            end = medium - 1;
        }
    }

    return -1;
}

// [3, 3, 4, 1, 2]
// 2

// shift = 3
// start = 0
// end = 4
// medium = (4 + 0) / 2 = 2
// mediumWithShift = (2 + 3) % 5 = 0
// end = 2
//
// medium = (0 + 2) / 2 = 1
// mediumWithShift = (1 + 3) % 5 = 4
function binarySearchWithShift (nums, value, shift) {
    let start = 0;
    let end = nums.length - 1;

    while (start <= end) {
        let medium = Math.floor((start + end) / 2);
        let mediumWithShift = (medium + shift) % nums.length;

        if (nums[mediumWithShift] === value) {
            return mediumWithShift;
        }

        if (nums[mediumWithShift] < value) {
            start = medium + 1;
        } else {
            end = medium - 1;
        }
    }
    
    return -1;
}
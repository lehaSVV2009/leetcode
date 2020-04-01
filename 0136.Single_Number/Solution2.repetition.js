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

  const set = new Set();

  for (const number of nums) {
    if (set.has(number)) {
      set.delete(number);
    } else {
      set.add(number);
    }
  }

  return set.size === 0 ? 0 : set.values().next().value;
};

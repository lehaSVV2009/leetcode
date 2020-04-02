/**
 * @param {number} n
 * @return {boolean}
 */
var isHappy = function(n) {
  // 1 - true, because 1^2 = 1
  // 2 - false, because 2^2 = 4, 4^2 = 16, 1^2 + 6^2 = 37, 3^2 + 7^2 = 9 + 49 = 58, 5^2 + 8^2 = 25 + 64 = 89, 8^2 + 9^2 = 145, 1^2 + 4^2 + 5^2 = 42, 4^2 + 2^2 = 20, 2^2 + 0^2 = 4
  // 7 - true, 7^2 = 49, 4^2+9^2 = 97, 9^2+7^2 = 130, 1^2 + 3^2 = 10
  // 10 - true
  // 130 - true
  // what should happen with endless loop numbers?
  // TODO handle too much values?

  // Solution 1
  // brute force
  // will hang if number is not happy
  // Stop in limit? (like 40)

  // Solution 2
  // Find logic?
  // e.g. 100 - positive number
  //

  // Maybe only constant number of squares can bring to 10?

  // 1
  // 10
  // 100
  // 1000
  // 10000
  // 100000
  // 1000000 ...

  // 1 = 1?
  // 10 = 1 + 0?
  // 1+9 = 10?

  // check if 10000 - tostring + regexp like [1][0]*

  // 10 = 1 + 9
  // 100 = 36 + 64
  // 1000 =

  // It seems that if your number has 1 digit, maximum square is 9^2 => 81 (2 digits)
  // for 2 digits, maximum square is 9^2 + 9^2 => 162 (3 digits)
  // for 3 digits, max is 9^2 + 9^2 + 9^2 = 243 (3 digits)
  // for 12 digits, max is 12*9^2 = 972 (3 digits)
  // for 13 digits, max is 13*9^2 = 1053 (4 digits)
  //

  // Solution 3 (found in internet)
  // text
  //
  // set visited
  // while !visited.has(text)
  //  numbers = text.split().map(Number.parseInt())
  //  text = String(numbers.reduce square)
  //  if text matches pattern
  //    return true;
  // return false

  // Solution 4
  // Same as 3, but instead of text implement toDigits(number) function

  // Solution 5 (found in internet)
  // slow - fast

  let number = n;

  const set = new Set();

  while (!set.has(number)) {
    set.add(number);

    const digits = toDigits(number);
    number = digits.reduce((result, digit) => result + digit * digit, 0);

    if (number === 1) {
      return true;
    }
  }

  return false;
};

function toDigits(number) {
  const digits = [];

  while (Math.floor(number / 10) !== 0) {
    digits.push(number % 10);
    number = Math.floor(number / 10);
  }
  digits.push(number);

  return digits;
}

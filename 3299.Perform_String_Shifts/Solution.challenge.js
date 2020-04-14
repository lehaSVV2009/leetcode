/**
 * @param {string} s
 * @param {number[][]} shift
 * @return {string}
 */
var stringShift = function(text, shifts) {
  // possible shift 0? e.g. [2, 0]?
  // possible shift -1?
  // a [*, *] ? a
  // ab [0, 1] ? ba
  // ab [1, 1] ? ba
  // abc [0, 1] ? bca
  // abc [1, 1] ? cab
  // abc [1, 3] ? abc
  // abc [1, 4] ? cab
  // abc [1, 7] ? cab
  // abc [0, 1][0, 1] ? bca
  // abc [0, 1][1, 1] ? abc
  // Can i return new string?

  // Solution 1
  // Merge all shift to one
  // Use shift[x][y] % string length
  // Shift all characters
  
  if (text.length <= 1) {
      return text;
  }

  let finalShift = 0;
  for (const shift of shifts) {
      if (shift[0] === 0) {
          finalShift -= shift[1];
      }
      if (shift[0] === 1) {
          finalShift += shift[1];
      }
  }

  // 1
  // abc
  // 1 % 3 = 1
  // cab
  // 2
  // abc
  // 2 % 3 = 2
  // bca
  // 3
  // abc
  // 3 % 3 = 0
  // abc
  // -1
  // -1 % 3 = -1
  // 3 + (-1) = 3
  // abc
  // bca
  
  return shiftText(text, finalShift);
};

function shiftText(text, shift) {    
  let finalShift = shift % text.length;

  if (finalShift === 0) {
      return text;
  }

  if (finalShift < 0) {
      finalShift = text.length + finalShift;
  }

  // TODO try inplace?
  // abc
  // 1
  // cab
  let result = ''
  for (let i = 0; i < text.length; ++i) {
      let oldIndex = i + (text.length - finalShift);
      if (oldIndex >= text.length) {
          oldIndex -= text.length;
      }
      result += text.charAt(oldIndex);
  }
  return result;
}
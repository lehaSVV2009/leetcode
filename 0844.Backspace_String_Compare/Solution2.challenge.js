/**
 * @param {string} S
 * @param {string} T
 * @return {boolean}
 */
var backspaceCompare = function(left, right) {
  // "##" "" ? true 
  
  // Solution 1
  // 2 stacks
  // than compare length and characters
  
  // Solution 2
  // 2 pointers from end of string

  let i = left.length - 1;
  let j = right.length - 1;

  // S = "ab##", T = "c#d#"
  // S = "a##c", T = "#a#c"
  // S = "c###", T = "b"
  while (i >= 0 || j >= 0) {
      i = findUnbackspacedCharIndex(i, left);
      j = findUnbackspacedCharIndex(j, right);
      
      if (i >= 0 && j >= 0 && left.charAt(i) !== right.charAt(j)) {
          return false;
      }
      i--;
      j--;
  }

  return i === j;
};

function findUnbackspacedCharIndex(currentIndex, text) { // index = 2
  let leftBackspaceCounter = 0; // counter = 0

  while (currentIndex >= 0) {
      if (text.charAt(currentIndex) === '#') {
          leftBackspaceCounter++;
          currentIndex--;
      } else if (leftBackspaceCounter > 0) {
          leftBackspaceCounter--;
          currentIndex--;
      } else {
          break;
      }
  }
  return currentIndex;
}

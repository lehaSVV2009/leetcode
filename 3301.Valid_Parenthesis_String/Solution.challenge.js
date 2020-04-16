/**
 * @param {string} s
 * @return {boolean}
 */
var checkValidString = function(s) {
  // "" ? true
  // "(" ? false
  // "*" ? true
  // "**" ? true
  // "(*"? true
  // "(*))" true
  // "(*()(*()(*)*" ? true
  // "*())" ? true
  // "*(" ? false
  // "()*(" ? false
  // "((*" ? false
  // "((**(("
  // abc ? false
  // (((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(()) ? false

  // Solution 1
  // stack, but something tricky with *
  // Same stack, but star counter is added
  // And in the end, when length of stack must be 0, if not 0 - try to come to zero by * count
  // Probably will fail cause of *( example
  // So, we can try to check stack length before adding *
  // If stack length === 0 then we add " (" to stack
  // If stack length > 0 then we add " ()" to stack
  // Refresh * count sometimes (but when?)
  
  // Solution 2
  // Brute force solution?
  // If stack has *, duplicate stack twice, add "(", ")" and " " to new stacks and continue checking all of them
  // O(N^2)

  let minStatus = 0;
  let maxStatus = 0;

  // ((**)
  // ()*(
  for (const letter of s) {
      if (letter === '(') {
          minStatus++;
          maxStatus++;
      } else if (letter === ')') {
          minStatus--;
          maxStatus--;
      } else if (letter === '*') {
          minStatus--;
          maxStatus++;
      } else if (letter !== ' ') {
          return false;
      }
      if (maxStatus < 0) {
          return false;
      }
      minStatus = Math.max(minStatus, 0);
  }

  return minStatus === 0;
};
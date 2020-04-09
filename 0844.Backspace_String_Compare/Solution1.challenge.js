/**
 * @param {string} S
 * @param {string} T
 * @return {boolean}
 */
var backspaceCompare = function(S, T) {
  // "##" "" ? true 
  
  // Solution 1
  // 2 stacks
  // than compare length and characters

  const firstText = execBackspaces(S);    
  const secondText = execBackspaces(T);

  return firstText === secondText;
};

function execBackspaces(expression) {
  const result = [];
  
  for (const key of expression) {
      if (key === '#') {
          result.pop();
      } else {
          result.push(key);
      }
  }

  return result.join();
}
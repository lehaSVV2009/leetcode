/**
 * @param {string} text1
 * @param {string} text2
 * @return {number}
 */
var longestCommonSubsequence = function(firstText, secondText) {
  // "a", "" ? failed
  // "a", "a" ? 1
  // "ab", "ca" ? 1
  // "kab", "crda" ? 
  // "cab", "crda" ? 2
  // "abce", "acde" ? 3
  // "aabce", "acde" ? 3
  // "abcbc", "abc" ? 3
  // "abcccdrdex", "rdefabccd" ? 3
  // "zabcd", "abcdz" ? 4


  // Solution 1
  // brute-force
  // 2^n
  // Set subsequences1 = findAllSubsequences (backtrack)
  // Set subsequences2 = findAllSubsequences (backtrack)
  // foreach subsequences1 
  //   if contains subsequences2
  //     result = Math.max(result, subsequence1.length)
  
  // Solution 2
  // O(N^2)
  // 2 pointers from end
  // Convert second string to Map<Char, Index>
  // let result = 0;
  // foreach char in line 1 from end
  //   let secondIndex
  //   if map has char
  //     let subsequenceLength = 1;
  //     foreach next chars
  //       if map has char && map[char] has index > secondIndex
  //         secondIndex += 
  //     result = Math.max(result, )
  const firstTextMap = new Map();
  for (let index = 0; index < firstText.length; ++index) {
      const letter = firstText[index];
      if (firstTextMap.has(letter)) {
          firstTextMap.get(letter).push(index);
      } else {
          firstTextMap.set(letter, [index]);
      }
  }

  let result = 0;
  // store already checked indexes?
  for (let i = secondText.length - 1; i >= 0; --i) {
      const letter = secondText[i];

      if (firstTextMap.has(letter)) {
          result = Math.max(result, findSubsequenceLength(letter, i, firstTextMap, secondText));
      }
  }
  return result;
};

function findSubsequenceLength(letter, i, firstTextMap, secondText) {
  let subsequenceLength = 1;

  let firstLetterIndexes = firstTextMap.get(letter);
  let firstCurrentIndex = firstLetterIndexes[firstLetterIndexes.length - 1];

  for (let j = i - 1; j >= 0; --j) {
      const subsequenceLetter = secondText[j];
      if (firstTextMap.has(subsequenceLetter) && firstTextMap.get(subsequenceLetter).some(index => index < firstCurrentIndex)) {
          subsequenceLength++;
          // binary search??
          firstLetterIndexes = firstTextMap.get(subsequenceLetter);
          for (let k = firstLetterIndexes.length - 1; k >= 0; --k) {
              if (firstLetterIndexes[k] < firstCurrentIndex) {
                  firstCurrentIndex = firstLetterIndexes[k];
                  break;
              }
          }
      }
  }

  return subsequenceLength;
}
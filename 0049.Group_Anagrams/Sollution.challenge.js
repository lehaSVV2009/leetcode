/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(words) {
  const map = new Map();

  words.forEach(word => {
      const letterCountsText = toLetterCountsText(word);
      
      if (map.has(letterCountsText)) {
          const countWords = map.get(letterCountsText);
          countWords.push(word);
          map.set(letterCountsText, countWords);
      } else {
          map.set(letterCountsText, [word]);
      }
  })

  return Array.from(map.values());
};

const A_CHAR_CODE = 'a'.charCodeAt();

function toLetterCountsText (word) {
  const counts = new Array(26).fill(0);

  word.split("").forEach(letter => {
      const code = letter.charCodeAt() - A_CHAR_CODE;
      counts[code]++;     
  })

  let text = '';
  counts.forEach((count, index) => {
      if (count > 0) {
          const char = String.fromCharCode(index + A_CHAR_CODE);
          text += char.repeat(count);
      }
  })
  return text;
}
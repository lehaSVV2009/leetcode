/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(words) {
  // same characters?
  const map = {};

  for (let word of words) {
    const letterCountsText = toLetterCountsText(word);

    if (map[letterCountsText]) {
      map[letterCountsText].push(word);
    } else {
      map[letterCountsText] = [word];
    }
  }

  return Object.values(map);
};

function toLetterCountsText(word) {
  const lettersMap = {};

  for (let letterIndex in word) {
    const letter = word[letterIndex];
    if (lettersMap[letter]) {
      lettersMap[letter]++;
    } else {
      lettersMap[letter] = 1;
    }
  }

  let text = "";
  const alphabet = "abcdefghijklmnopqrstuvwxyz";
  for (let letterKey in alphabet) {
    const letter = alphabet[letterKey];
    text += letter;
    text += lettersMap[letter] || 0;
  }
  return text;
}

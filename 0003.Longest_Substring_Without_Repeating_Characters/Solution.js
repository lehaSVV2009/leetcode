module.exports = {
  //param A : string
  //return an integer
  lengthOfLongestSubstring: function(text) {
    // same length? - one of them
    // any character?
    // empty array? 0

    // Solution 1
    // 2 pointers + hashmap
    // int fromIndex = 0
    // int result = 0
    // map<visited>
    // foreach character, toIndex
    //   if visited contains key
    //     fromIndex = map[key]
    //   map[key] = toIndex
    //   if toIndex - fromIndex > result
    //     result = toIndex - fromIndex
    // O(N), but O(N) memory

    var result = 0;

    var fromIndex = 0;
    var map = {};

    // abcabcda
    for (var toIndex = 0; toIndex < text.length; ++toIndex) {
      var letter = text.charAt(toIndex);
      if (map[letter] || map[letter] === 0) {
        fromIndex = Math.max(map[letter] + 1, fromIndex);
      }
      map[letter] = toIndex;
      var substringLength = 1 + toIndex - fromIndex;
      if (substringLength > result) {
        result = substringLength;
      }
    }

    return result;
  }
};

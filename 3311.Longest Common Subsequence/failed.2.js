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
    const firstSubsequences = findAllSubsequences(firstText, -1, "", new Set());
    const secondSubsequences = findAllSubsequences(secondText, -1, "", new Set());
    
    let result = 0;
    for (const firstSubsequence of firstSubsequences) {
        if (firstSubsequence.length < result) {
            continue;
        }
        if (secondSubsequences.has(firstSubsequence)) {
            result = Math.max(result, firstSubsequence.length)
        }
    }
    return result;
};

function findAllSubsequences(text, index, path, result) {
    if (index === text.length) {
        return result;
    }
    
    result.add(path);
    
    for (let i = index + 1; i < text.length; ++i) {
        path += text[i];
        findAllSubsequences(text, i, path, result);
        path = path.slice(0, -1);
    }
    
    return result;
}
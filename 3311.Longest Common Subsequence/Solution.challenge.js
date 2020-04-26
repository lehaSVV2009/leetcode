/**
 * @param {string} text1
 * @param {string} text2
 * @return {number}
 */
// "papmretkborsrurgtina"
// "nsnupotstmnkfcfavaxgl"
//
// "yzebsbuxmtcfmtodclszgh"
// "ejevmhcvshclydqrulwbyha"
var longestCommonSubsequence = function(firstText, secondText) {
    const memo = Array(firstText.length + 1).fill(null).map(() => Array(secondText.length + 1));

    for (let i = 0; i <= firstText.length; ++i) {
        for (let j = 0; j <= secondText.length; ++j) {
            if (i === 0 | j === 0) {
                memo[i][j] = 0;
            } else if (firstText[i - 1] === secondText[j - 1]) {
                memo[i][j] = memo[i - 1][j - 1] + 1;
            } else {
                memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1])
            }
        }
    }

    return memo[firstText.length][secondText.length];
};
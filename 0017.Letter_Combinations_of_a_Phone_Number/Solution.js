/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {
        // "" - [""]
        // 1 - []
        // xyz? - ignore
        // *? - ignore
        // #? - ignore
        // 0? - []
        // 2 -> [a, b, c]
        // 23 -> [ad, ae, af, bd, be, bf, cd, ce, cf]
        // 123 -> []
        // 234 -> ["adg","adh","adi","aeg","aeh","aei","afg","afh","afi","bdg","bdh","bdi","beg","beh","bei","bfg","bfh","bfi","cdg","cdh","cdi","ceg","ceh","cei","cfg","cfh","cfi"]
        // 22 -> [aa, ab, ac, bb, ba, bc, cc, ca, cb]
        // returned string is sorted
        // 
        // Solution 1
        // backtracking
        // func backtrack (digits, path, result)
        //   nextIndex = path.length
        //   if nextIndex > digits.length
        //     result push path
        //     return
        //   letters = get_number_letters(digits[nextIndex])
        //   foreach letter in letters
        //     path.push(letter)
        //     backtrack(digits, path, result)
        //     path.pop()

        // func get_number_letters (number)
        //   if (number=== '1') return []
        //   if (number === '2') return ['a', 'b', 'c']
        // ... 
        // . return []
    if (!digits) {
        return []
    }

    result = [];
    backtrack(digits, '', result);
    return result;
};

function backtrack(digits, path, result) {
    var nextIndex = path.length;
    if (nextIndex >= digits.length) {
        result.push(path);
        return;
    }
    
    var letters = getPhoneNumberLetters(digits.charAt(nextIndex));

    for (var i = 0; i < letters.length; ++i) {
        var letter = letters[i];
        backtrack(digits, path + letter, result);
    }

    return letters;
}

function getPhoneNumberLetters(number) {
    switch (number) {
        case '1': {
            return [];
        }
        case '2': {
            return ['a', 'b', 'c'];
        }
        case '3': {
            return ['d', 'e', 'f'];
        }
        case '4': {
            return ['g', 'h', 'i'];
        }
        case '5': {
            return ['j', 'k', 'l'];
        }
        case '6': {
            return ['m', 'n', 'o'];
        }
        case '7': {
            return ['p', 'q', 'r', 's'];
        }
        case '8': {
            return ['t', 'u', 'v'];
        }
        case '9': {
            return ['w', 'x', 'y', 'z']
        }
        default: {
            return [];
        }
    }
}

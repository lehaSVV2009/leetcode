class Solution {
    public int myAtoi(String str) {
        // ""? 0
        // "abc"? 0
        // "999999999999999999999999999999999"? 2147483647
        //                          
        // "-999999999999999999999999999999999"? -2147483648
        // "99abc" 99 
        // "abc99" 0
        // "abc99abc" 0
        // "99 99" 99
        // "99\t99" 99
        // "99\n99" 99
        // "12,01" 12
        // "12,99" 12
        // "12.01" 12
        // "12.00" 12
        // "12.0" 12
        // "0" 0
        // "-0"
        // "-123" -123
        // "--123" 0
        // "+123" 123
        // "++123" 0
        // "   1223   "?
        // "\n1223   "? 0
        // "+ 123" 0

        // Solution 1
        // char is from 48 to 57
        // straight-forward
        // map[char, int]
        // trim
        // if empty or first not a number and not a sign
        //   0
        // if sign
        //   minus = true/false
        //   text = text.substring
        // result = 0
        // foreach
        //   if char not int break
        
        //   char to int
        
        //   if result >= 214748364 and int > 7
        //      return INT.MAX
        
        //   if result <= -214748364 and int > 8
        //      return INT.MIN

        //   result = result * 10 + (minus) ? -int : int 
        
        // return result
        int asciiPlus = 43;
        int asciiMinus = 45;

        if (str == null) {
            return 0;
        }
        String text = str.trim();
        if (text.isEmpty()) {
            return 0;
        }
        int first = (int) text.charAt(0);
        if (first != asciiPlus && first != asciiMinus && !isDigit(first)) {
            return 0;
        }
        
        boolean minus = false;
        if (first == asciiPlus || first == asciiMinus) {
            text = text.substring(1);
            minus = first == asciiMinus;
        }

        int result = 0;

        for (int i = 0; i < text.length(); ++i) {
            int asciiCode = (int) text.charAt(i);
            if (!isDigit(asciiCode)) {
                break;
            }
            int digit = toDigit(asciiCode);
            
            if (result > 214748364 || (result == 214748364 && digit > 7)) {
                return 2147483647;
            }
            if (result < -214748364 || (result == -214748364 && digit > 8)) {
                return -2147483648;
            }
            result = result * 10 + (minus ? -digit : digit);
        }

        return result;        
    }
    
    private boolean isDigit(int asciiCode) {
        return asciiCode >= 48 && asciiCode <= 57;
    }

    private int toDigit(int asciiCode) {
        return asciiCode - 48;
    }    
}

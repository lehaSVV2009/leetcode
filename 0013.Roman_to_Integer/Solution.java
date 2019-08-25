class Solution {
    
    public static Map<Character, Integer> romanArabicMap = 
        Stream.of(new Object[][] { 
            { 'I', 1 }, 
            { 'V', 5 }, 
            { 'X', 10 },
            { 'L', 50 },
            { 'C', 100 },
            { 'D', 500 },
            { 'M', 1000 }
        })
        .collect(Collectors.toMap(
            data -> (Character) data[0], 
            data -> (Integer) data[1]));

    public static Map<Character, Character> romansPrefixesMap = 
        Stream.of(new Object[][] { 
            { 'V', 'I' }, 
            { 'X', 'I' }, 
            { 'L', 'X' },
            { 'C', 'X' },
            { 'D', 'C' },
            { 'M', 'C' }
        })
        .collect(Collectors.toMap(
            data -> (Character) data[0], 
            data -> (Character) data[1]));

    public int romanToInt(String s) {
        // Should I check for invalid strings?
        // lower case?
        
        // Solution 1
        // static Map <Roman, Arabic>
        // static Map <Roman, RomanPrefix>
        // Go from the end os string to the start and increment
        // Before the incrementation check if value has substracted prefix
        // If it has increment on value minus value of prefix and i -= 2
        
        // Solution 2 
        // From the start to end
        // if next value is greater than current add [next value - current value] and i += 2 

        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        int result = 0;
        
        int length = s.length();        
        int i = length - 1;
        while (i >= 0) {
            Character letter = s.charAt(i);
            
            // Fail if non-roman characters
            if (!romanArabicMap.containsKey(letter)) {
                return 0;
            }

            Integer arabic = romanArabicMap.get(letter);
            if (
                i - 1 >= 0 
                && ((Character) s.charAt(i - 1)).equals(romansPrefixesMap.get(letter))
            ) {
                Character prefix = s.charAt(i - 1);
                Integer arabicPrefix = romanArabicMap.get(prefix);
                result += (arabic - arabicPrefix);
                i -= 2;
            } else {
                result += arabic;
                i--;
            }
        }

        return result;
    }
}
public class Solution {
    static Character vowels[] = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
    static Set<Character> vowelsSet = new HashSet<>(Arrays.asList(vowels));

    public int solve(String A) {
        // What about spaces?
        // length - vowelIndex -> number of substrings starting with this vowel

        // Solution 1
        // straight-forward
        // result
        // loop
        //   if character is vowel
        //     result += (length - vowelIndex)
        // O(N)

        // Solution 2
        // regexp
        // smth like 
        
        int length = A.length();
        if (length == 0) {
            return 0;
        }
        
        int result = 0;
        for (int i = 0; i < length; ++i) {
            if (vowelsSet.contains(A.charAt(i))) {
                result += (length - i);
            }
        }
        
        return result % 10003;
    }
}

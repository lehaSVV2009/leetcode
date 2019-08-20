public class Solution {
    public String longestCommonPrefix(ArrayList<String> array) {
        // aa, aa = > aa
        // bc, rd => ""?
        // bc, bc, rd => ""

        // Solution 1
        // foreach elements in min
        //   check all elements in cycle
        //   if greater than length return 
        //   if not match return
        // O(N*M)

        // Solution 2
        // Tree, build tree. Not better..

        if (array == null || array.size() == 0) {
            return "";
        }
        
        if (array.size() == 1) {
            return array.get(0);
        }

        String prefix = "";

        String firstText = array.get(0);
        for (int i = 0; i < firstText.length(); ++i) {
            char letter = firstText.charAt(i);
            for (int j = 1; j < array.size(); ++j) {
                String text = array.get(j);
                if (i >= text.length()) {
                    return prefix;
                }
                if (letter != text.charAt(i)) {
                    return prefix;
                }
            }
            prefix += letter;
        }
        
        return prefix;
    }
}

class Solution {
    public List<Integer> findSubstring(String text, String[] words) {
        // barfoothe, ['bar', 'foo', 'the'] ? [0]
        // "" [...] ? []
        // "foobar" [] ? []
        // foobar ["foo" "bar"] ? [0]
        // "barfoothefoobarman" ["foo","bar","the"] ? [0, 6]
        // "foofoothefoobarman" ["foo","bar","the"] ? [6]
        // "foofoothebarman" ["foo","foo", "bar","the"] [0]
        // duplicates?
        // "fobafobafo" ["fo", "ba"] ? [0,2,4,6]

        // Solution 1
        // Set of all concatenations..
        // foreach
        //   foreach
        //     foreach
        // O(N^3) or even I'm wrong and O(2^N)

        // Solution 2
        // Find substring, get next 3 chars, find in visited
        // foreach word
        //   initialIndex
        //   while (s.indexOf(word, initialIndex) != -1)
        //     

        // Solution 3
        // [] result
        // words length sum
        // for i = 0...n - words length sum
        //   substring
        //   Map<Word, Count> map
        //   String substring = 
        //   for every word length item
        //     if map !contains word
        //       break
        //     else
        //       map remove word or decrease count
        //       substring += word
        // N - string length
        // M - words number
        // L - word length
        // O(N*M*L)
        if (text == null 
            || text.isEmpty() 
            || words.length == 0 
            || words[0].length() == 0) {
            return new ArrayList<>();
        }
        
        List<Integer> result = new ArrayList<>();

        int wordLength = words[0].length();
        int wordsLength = words.length * wordLength;
        Map<String, Integer> wordsMap = toWordsMap(words);
        
        for (int i = 0; i < text.length() - (wordsLength - 1); ++i) {
            String currentSubtext = text.substring(i, i + wordsLength);
            String potentialSubstring = "";
            Map<String, Integer> unvisited = wordsMap.clone();
            for (int j = 0; j < wordsLength; j += wordLength) {
                String potentialWord = currentSubtext.substring(j, j + wordLength);
                if (!unvisited.containsKey(potentialWord)) {
                    break;
                }
                potentialSubstring += potentialWord;
                int count = unvisited.get(potentialWord);
                if (count > 1) {
                    unvisited.put(potentialWord, count - 1);
                } else {
                    unvisited.remove(potentialWord);
                }
            }
            if (unvisited.size() == 0 && potentialSubstring.length() == wordsLength) {
                result.add(i);
            }
        }
        
        return result;
    }
    
    public Map<String, Integer> toWordsMap(String[] words) {
        Map<String, Integer> wordsMap = new HashMap<>();
        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            wordsMap.merge(word, 1, Integer::sum);
        }
        return wordsMap;
    }
}
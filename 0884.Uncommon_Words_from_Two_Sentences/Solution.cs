public class Solution {
    public string[] UncommonFromSentences(string A, string B) {
        string[] Words = (A + " " + B).Split(" ");
        
        Dictionary<string, int> WordCountMap = new Dictionary<string, int>();
        
        for (int i = 0; i < Words.Length; i++) {
            string Word = Words[i];

            if (WordCountMap.ContainsKey(Word)) {
                WordCountMap[Word] = WordCountMap[Word] + 1;
            } else {
                WordCountMap.Add(Word, 1);
            }    
        }

        List<string> singleWords = new List<string>();
        foreach(KeyValuePair<string, int> entry in WordCountMap) {
            if (entry.Value == 1) {
                singleWords.Add(entry.Key);
            }
        }

        return singleWords.ToArray();
    }
}
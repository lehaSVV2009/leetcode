public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        // [0, 0, 0]? 
        // [0, 0, 0, 0]?
        // array sorted?
        
        // Solution 1 brute force
        // for i
        //   for j
        //     for k
        // Set<Triple>
        // O n^3
        
        // Solution 2
        // All pair that gives 0 in sum
        // foreach i
        //   foreach j
        //     Map<Integer, Pair<Integer, Integer>>
        // O n^2
        // foreach k
        //   contains in map?
        //   put to result of Set<Triple>
        // Set<Triple> to Array<Array>

        // Solution 3
        // sorting
        // -1 -1 -2 2 2 -1 0
        // -2 -2 -1 -1 -1 0 2 2
        // -8 -4 -3 -2 -1 0 1 2 4 4 7 9
        // NlogN
        // foreach i
        //   j = 1, k = length - 1
        //   start = i + 1, end = k
        //     if a[i] + a[j] + a[k] == 0 and not in cache
        //       add to result
        //     if sum > 0 k--
        //     if sum <= 0 j++

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (A.size() <= 2) {
            return result;
        }
        
        Set<String> cache = new HashSet<>();

        Collections.sort(A);
        
        for (int i = 0; i < A.size(); ++i) {
            int first = A.get(i);
            
            int j = i + 1;
            int k = A.size() - 1;
            while (j < k) {
                int second = A.get(j);
                int third = A.get(k);

                int sum = first + second + third;
                if (sum == 0 && !cache.contains(first + "" + second + "" + third)) {
                    ArrayList<Integer> triple = new ArrayList<>();
                    triple.add(first);
                    triple.add(second);
                    triple.add(third);
                    result.add(triple);
                    cache.add(first + "" + second + "" + third);
                }
                
                if (sum <= 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }
}

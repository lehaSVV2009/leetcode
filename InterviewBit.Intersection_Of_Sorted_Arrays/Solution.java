public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        // Handle duplicates - yes
        // Max length
        
        // Solution 1 stupid
        // foreach
        //   binarySearch
        // NlogN
        
        // Solution 2
        // i,j = 0
        // while i < length && j < length
        //   if a[i] < b[j]
        //     i++
        //   else if a[i] > b[j]
        //     j++
        //   else
        //     i++
        //     j++
        // O(N+M)
        ArrayList<Integer> intersection = new ArrayList<>();
        
        int i = 0, j = 0;
        while (i < A.size() && j < B.size()) {
            if (A.get(i) < B.get(j)) {
                i++;
            } else if (A.get(i) > B.get(j)) {
                j++;
            } else {
                intersection.add(A.get(i));
                i++;
                j++;
            }
        }
        
        return intersection;
    }
}

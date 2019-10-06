public class Solution {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        // Any array is empty? -> Math.MAX
        // [1] [1] [1] => a=1, b=1, c=1 => absolute dif = 0
        // [2] [5] [3] => a=2, b=5, c=3 => absolute dif = 5-2 = 3
        // [1, 2] [3, 4] [5, 6] => a = 2, b = 3 or 4, c = 5 => absolute dif = 5-2 = 3
        // 
        
        // Solution 1
        // straight forward
        // minDif
        // foreach
        //   a = A[i]
        //   foreach
        //      b = A[j]
        //      foreach
        //         c = A[k]
        //         max = Math.max(a, b, c)
        //         min = Math.min(a, b, c)
        //         minDif = Math.min(Math.abs(max - min), minDiff);
        // O(N^3)

        // Solution 2
        // 3 pointers
        // 1. Try with just 2 arrays and 2 pointers (found)
        // [5, 6] [4, 3]
        // i = 0
        // j = 0
        // minDif = Integer.MAX_VALUE
        // while (i < length && j < length)
        //   minDiff = Math.min(Math.abs(B[j] - A[i]), minDiff)
        //   if (a[i] > a[j])
        //     j++
        //   else
        //     i++
        // 2. Try with 3 arrays and 3 pointers
        // [1] [1] [1]
        // [1, 2] [0, 2, 4] [5, 6]
        // while (i < A.length && j < B.length && k < C.length)
        //   max = Math.max(a, b, c)
        //   min = Math.min(a, b, c)
        //   minDiff = Math.min(Math.abs(max - min), minDiff)
        //   if a <= b && a <= c
        //     i++
        //   if b <= a && b <= c
        //     j++
        //   if c <= a && c <= b
        //     k++
        // corner cases:
        // * equality
        // * skip all ifs

        
        int minDiff = Integer.MAX_VALUE,
            i = 0,
            j = 0,
            k = 0;
        
        while (i < A.size() && j < B.size() && k < C.size()) {
            int a = A.get(i);
            int b = B.get(j);
            int c = C.get(k);

            int max = Math.max(a, Math.max(b, c));
            int min = Math.min(a, Math.min(b, c));
            
            minDiff = Math.min(Math.abs(max - min), minDiff);
            
            if (a <= b && a <= c) {
                i++;
            } else if (b <= a && b <= c) {
                j++;
            } else {
                k++;
            }
        }
        
        return minDiff;
    }
}

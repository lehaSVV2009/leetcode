class Solution {
    public String getPermutation(int n, int k) {
            // k is out of permutation number? no! k is maximum n!
    // k starts from 1 (not 0)? yes
    // n are from 1 to 9
    // permutations unique? yes

    // 2
    // 1, 2
    // 2, 1

    // 3^3 = 27
    // 3! = 1*2*3 = 6
    
    // 3
    // 1 2 3
    // 1 3 2
    // 2 1 3
    // 2 3 1
    // 3 1 2
    // 3 2 1

    // length = 3!
    // [1, 2, 3], but limit is 2
    // 1 2
    // 1 3
    // 2 1
    // 2 3
    // 3 1
    // 3 3
    
    // length = 10! = 3628800
    // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9], but limit is 4 (door code)
    // But if permutation with duplicates, than 10^4
    
    // So, in lottery with 4 numbers
    // if there are no duplicates, there are:
    // 4! permutations like [3, 1, 2]
    // if there are duplicates, than
    // 4^3 permutations like [3, 3, 1]
    // If we have n objects and we want to choose k of them, 
    // we can find the total number of combinations by using the following formula:
    // n! / (k! * (n - k)!)
    // 4! / (3! * (4 - 3)!) = 24 / 6 * (1) = 4 combinations of [0, 1, 2, 3] in hands of 3

    // Solution - permutation backtrack. If counter -> return. But it looks like not dfs, but bfs
    //
    // func backtrack (numbers, path, result)
    //   if path === numbers.length
    //     result.counter++
    //     if (result.counter !== result.limit)
    //       return false
    //     result.path = path
    //     return true
    //   foreach number in numbers
    //     if path contains number
    //       continue
    //     path.push number
    //     if backtrack(numbers, path, result)
    //       return true
    //     path.pop
    //   return false
    // TOO SLOW...    
    
    // Solution 2
    // Same, but we know index of permutation
    // we know all items count -> n! (e.g. 4! = 24)
    // we know how many numbers we have -> n (e.g. 4 => [1, 2, 3, 4])
    // we know k index - e.g. 10
    // Every 1st digit takes his area 24 / 4 = 6 
    // from 1 to 6 - 1
    // from 7 to 12 - 2
    // from 13 to 18 - 3
    // from 19 to 24 - 4
    // 
        if (n < 1) {
            return "";
        }
        if (k < 1) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        
        // create an array of factorial lookup
        double factorial = 1.0;
        List<Double> factorials = new ArrayList<>();
        factorials.add(factorial);
        for (int i = 1; i <= n; i++) {
            factorial *= (double) i;
            factorials.add(factorial);
        }
        // factorial[] = {1, 1, 2, 6, 24, ... n!}
        
        // create a list of numbers to get indices
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        // numbers = {1, 2, 3, 4}
        
        k--;
        
        for (int i = 1; i <= n; i++) {
            int index = (int) ((double) k / factorials.get(n - i));
            builder.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k -= index * factorials.get(n - i);
        }

        return builder.toString();
    }
}
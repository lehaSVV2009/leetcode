public class Solution {
    public int maxSpecialProduct(ArrayList<Integer> array) {
        // duplicates possible? yes

        // 4 3 2 5 => 3
        // i = 0 
        // A[j] > A[i]
        // leftSpecialValue = 0
        // rightSpecialValue = 3
        // product => 0
        // i = 1
        // leftSpecialValue = 0
        // rightSpecialValue = 3
        // product => 0
        // i = 2
        // leftSpecialValue = 1
        // rightSpecialValue = 3
        // product => 3
        // i = 3
        // leftSpecialValue = 0
        // rightSpecialValue = 0
        // product => 0

        // Solution 1 - straight forward
        // Assign maxProduct = 0
        // For each item
        //   find max index of left side where value is greater
        //   find min index of right side where value is greater
        //   calculate product
        //   if (product > maxProduct)
        //     maxProduct = product
        // O(N^2)

        // Solution 2 - sorting? It will break smth. Only if there is any magic logic
        // 2 arrays - sorted and origin
        // when goes through origin, check sorted

        // Solution 3 - map? dp like)
        // Map<index, leftSpecialValue> leftSpecialsCache
        // Map<index, rightSpecialValue> rightSpecialsCache
        //
        // 4 3 2 6 10 5 21 8 1 => 24
        // 4 [left -> 0, rigth -> 3]
        // 3 [left -> 0, right -> 3]
        // 2 [left -> 1, right -> 3]
        // 6 [left -> 0, rifht -> 4]
        // 10 [left -> 0, right -> 6]
        // 5 [left -> 4, right -> 6]
        // 6 [left -> 0, right -> 0]
        // 8 [left -> 6, right -> 0]
        // 9 [left -> 7, right -> 0]

        // Assign maxProduct = 0
        // For each item
        //   find max index of left side where value is greater
        //     if left value is less than current, go to check leftSpecialIndex.get(left) and again
        //   find min index of right side where value is greater
        //      if right value is less than current, go to check rightSpecialsCache.get(right) and again
        //   calculate product
        //   if (product > maxProduct)
        //     maxProduct = product
        //   put to cache


        int size = array.size();
        if (size <= 3) {
            return 0;
        }

        double maxProduct = 0.0;

        Map<Integer, Integer> leftSpecialsCache = new HashMap<>();

        for (int index = 0; index < size; ++index) {
            int currentValue = array.get(index);

            int leftSpecial = findLeftSpecialValue(index, currentValue, array, leftSpecialsCache);
            int rightSpecial = findRightSpecialValue(index, currentValue, size, array);

            leftSpecialsCache.put(index, leftSpecial);

            double product = ((double) leftSpecial) * (rightSpecial);
            if (product > maxProduct) {
                maxProduct = product;
            }
        }

        while (maxProduct > 1000000007) {
            maxProduct %= 1000000007;
        }

        return (int) maxProduct;
    }
    
    private int findLeftSpecialValue(int currentIndex, int currentValue, List<Integer> array, Map<Integer, Integer> leftSpecialsCache) {
        int leftSpecial = 0;
        int leftIndex = currentIndex - 1;
        // > 0, but not >= 0 because of always zero left index if comes to zero
        while (leftIndex > 0) {
            if (array.get(leftIndex) > currentValue) {
                leftSpecial = leftIndex;
                break;
            }
            leftIndex = leftSpecialsCache.get(leftIndex);
        }
        return leftSpecial;
    }
    
    private int findRightSpecialValue(int currentIndex, int currentValue, int size, List<Integer> array) {
        int rightSpecial = 0;
        int rightIndex = currentIndex + 1;
        while (rightIndex < size) {
            if (array.get(rightIndex) > currentValue) {
                rightSpecial = rightIndex;
                break;
            }
            rightIndex++;
        }

        return rightSpecial;
    } 
}

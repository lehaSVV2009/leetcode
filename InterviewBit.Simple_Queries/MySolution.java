public class Solution {
    class Interval {
        public Integer start;
        public Integer end;
        public Integer value;
        
        public Interval(Integer start, Integer end, Integer value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
        
        public String toString() {
            return "<" + this.start + "," + this.end + "," + this.value + ">";
        }
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        // A = [1, 6, 7]. B = [1, 4, 10, 20]
        // generate all subarrays of A. NOT SUBSEQUENCES!!!
        // [1], [1, 6], [1, 6, 7], [6], [7],  [6, 7], set?
        // Any duplicates
        
        // take the maximum element from each subarray of A and insert it into a new array G.
        // [1, 6, 7, 7, 6, 7, 7]
        // Probably we can skip subarray step, but just calculate ammount of max values..

        // replace every element of G with the product of their divisors mod 1e9 + 7.
        // [1, 2*3*6, 7, 7, 2*3*6, 7, 7]
        // Probably it might be cached
        // Plus when I check value, I can put 2 values to multiply

        // sort G in descending order
        // [36, 36, 7, 7, 7, 7, 1]
        // Simple array sort if still needed

        // perform Q queries
        // [36, 7, 0?, 0?]
        // pretty easy
        
        // Solution 1
        // Straight forward

        // Solution 2 FAILED
        // Sorting
        // [1, 6, 7] => [1], [1, 6], [1, 6, 7], [6], [7],  [6, 7],
        // 6 subarrays
        // 1 will be in 3 subarrays = length
        // 6 will be in 4 subarrays = length + (length - 2)
        // 7 will be in 3 subarrays = length
        // BUT 
        // Max 1 will be in 1 subarrays
        // Max 6 will be in 2 subarrays
        // Max 7 will be in 3 subarrays

        // [9, 8, 6, 1] => 
        // [9], [9, 8], [9, 8, 6], [9, 8, 6, 1], 
        // [8], [8, 6], [8, 6, 1]
        // [6], [6, 1]
        // [1]
        // 9 will be in 4 subarrays  = length
        // 8 will be in 6 subarrays = length + (length - 2)
        // 6 will be in 6 subarrays = length + (length - 2)
        // 1 will be in 4 subarrays = length
        // Max 1 will be in 1 subarrays
        // Max 6 will be in 2 subarrays
        // Max 8 will be in 3 subarrays
        // Max 9 will be in 4 subarrays

        // [6, 8, 9, 1] => 
        // [6], [6, 8], [6, 8, 9], [6, 8, 9, 1]
        // [8], [8, 9], [8, 9, 1]
        // [9], [9, 1]
        // [1]
        // Max 1 will be in 1 subarrays
        // Max 6 will be in 1 subarrays
        // Max 8 will be in 2 subarrays
        // Max 9 will be in 6 subarrays
        

        // [1, 6, 6, 7] => 4+3+2
        // Subarrays unique if duplicated?

        if (B == null || B.size() == 0) {
            return new ArrayList<>();
        }

        TreeMap<Integer, Integer> productsFrequences = calculateProductsFrequences(A);
        List<Interval> intervals = generateIntervals(productsFrequences);

        Map<Integer, Integer> intervalsValuesCache = new HashMap<>();

        ArrayList<Integer> result = new ArrayList<>();
        for (Integer query : B) {
            int index = query - 1;
            if (intervalsValuesCache.containsKey(index)) {
                result.add(intervalsValuesCache.get(index));
            } else {
                Integer value = findInInterval(index, intervals);
                intervalsValuesCache.put(index, value);
                result.add(value);
            }
        }

        return result;
    }

    private TreeMap<Integer, Integer> calculateProductsFrequences(List<Integer> array) {
        TreeMap<Integer, Integer> productsFrequences = new TreeMap<Integer, Integer>(Collections.reverseOrder());
        Map<Integer, Integer> productsOfDivisorsCache = new HashMap<>();

        // [8, 6, 9, 1]
        // 8 - 2
        // 6 - 1
        // 9 - 6
        // 1 - 1
        int length = array.size();
        for (int i = 0; i < length; ++i) {
            int currentNumber = array.get(i);
int greaterThanRightCount = 1;
            int rightIndex = i + 1;
            while (rightIndex < length && currentNumber >= array.get(rightIndex)) {
                greaterThanRightCount++;
                rightIndex++;
            }

            int greaterThanLeftCount = 1;
            int leftIndex = i - 1;
            while (leftIndex >= 0 && currentNumber > array.get(leftIndex)) {
                greaterThanLeftCount++;
                leftIndex--;
            }

            Integer frequency = greaterThanRightCount * greaterThanLeftCount;

            Integer productOfDivisors = null;
            if (productsOfDivisorsCache.containsKey(currentNumber)) {
                productOfDivisors = productsOfDivisorsCache.get(currentNumber);
                int previousFrequency = productsFrequences.get(productOfDivisors);
                productsFrequences.put(productOfDivisors, previousFrequency + frequency);
            } else {
                productOfDivisors = findProductOfDivisors(currentNumber);
                productsOfDivisorsCache.put(currentNumber, productOfDivisors);
                productsFrequences.put(productOfDivisors, frequency);
            }
        }

        return productsFrequences;
    }
    
    // <0, 45, Bla>, <46, 54, Foo>, <55, 68, EE>
    private List<Interval> generateIntervals(TreeMap<Integer, Integer> productsFrequences) {
        List<Interval> indexes = new ArrayList<>();

        Integer sum = 0;
        for (SortedMap.Entry<Integer, Integer> pair : productsFrequences.entrySet()) {
            indexes.add(new Interval(sum, sum + pair.getValue() - 1, pair.getKey()));
            sum += pair.getValue();
        }

        return indexes;
    }

    private Integer findInInterval(int index, List<Interval> intervals) {
        int start = 0;
        int end = intervals.size() - 1;

        while (start <= end) {
            int medium = (start + end) / 2;
            Interval interval = intervals.get(medium);

            if (index < interval.start) {
                end = medium - 1;
            } else if (index > interval.end) {
                start = medium + 1;
            } else {
                return interval.value;
            }
        }
        return 0;
    }

    private Integer findProductOfDivisors(Integer number) {
        double productOfDivisors = 1.0 * number;
        int max = number;
        for (int divisor = 2; divisor < max; ++divisor) {
            int greaterDivisor = number / divisor;
            max = greaterDivisor;
            
            if (number % divisor == 0) {
                if (greaterDivisor == divisor) {
                    productOfDivisors = (productOfDivisors % 1000000007) * (divisor % 1000000007);
                    break;
                } else {
                    productOfDivisors = (productOfDivisors % 1000000007) 
                        * (divisor % 1000000007) 
                        * (greaterDivisor % 1000000007);
                }
            }
        }

        productOfDivisors %= 1000000007;
        return (int) productOfDivisors;
    }
}

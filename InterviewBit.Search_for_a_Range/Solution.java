public class Solution {
    // DO NOT MODIFY THE LIST
    public ArrayList<Integer> searchRange(final List<Integer> list, int target) {
        // Solution 1.
        // Binary search. Find position of value
        // not found? [-1, -1]
        // found?
        //   go to the left until start or != target
        //   go to the right until end or != target
        // Before all check first element and last element on equality

        // Solution 2.
        // Binary search. Then binary search for left part and for right part.

        // Find algorithm complexity of [8, 8, 8, 8], 8 => 
        //   O(logN)? is it not O(N)?

        // Solution 3
        // Find number that is min, but greater than target
        // Find number that is max, but less than target

        // Solution 4
        // Binary search. find target.
        // Divide into 2 arrays
        // Binary search find place for target - 1
        // Binary search find place for target + 1
        // Failed! Because possible ([4, 4, 4, 5, 5], 5)
        if (list.size() == 0) {
            return createResult(-1, -1);
        }
        if (list.size() == 1) {
            return list.get(0) == target ? createResult(0, 0) : createResult(-1, -1);
        }
        if (list.get(0) == list.get(list.size() - 1)) {
            return list.get(0) == target ? createResult(0, list.size() - 1) : createResult(-1, -1);
        }

        int leftIndex = firstOccurence(list, target);
        int rightIndex = lastOccurence(list, target);

        return createResult(leftIndex, rightIndex);
    }

    public static int firstOccurence(List<Integer> list, int target) {
        int result = -1,
            start = 0, 
            end = list.size() - 1;

        while (start <= end) {
            int medium = start + (end - start) / 2;
            int value = list.get(medium);

            if (target == value) {
                result = medium;
                end = medium - 1;
            } else if (target > value) {
                start = medium + 1;
            } else {
                end = medium - 1;
            }
        }

        return result;
    }

    public static int lastOccurence(List<Integer> list, int target) {
        int result = -1,
            start = 0,
            end = list.size() - 1;
        
        while (start <= end) {
            int medium = start + (end - start) / 2;
            int value = list.get(medium);
            
            if (target == value) {
                result = medium;
                start = medium + 1;
            } else if (target > value) {
                start = medium + 1;
            } else {
                end = medium - 1;
            }
        }

        return result;
    }

    public static ArrayList<Integer> createResult(int from, int to) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(from);
        result.add(to);
        return result;
    }
}

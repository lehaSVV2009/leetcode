class Solution {
    // Quick sort - O(NlogN)
    // Take last (but usually random) number
    // Move all the values less than this number to the left of this number
    // Move this number to the end of this left partition
    // Then greater numbers will be on the right side of this number
    // Do the same for the left partition and the right partition
    // And for their left and right partition (recursion)
    // Divide and Conquer +
    // Stability -
    // Recursive +
    public int[] sortArray(int[] numbers) {
        quickSort(0, numbers.length - 1, numbers);
        return numbers;
    }

    public void quickSort(int start, int end, int[] numbers) {
        if (start < end) {
            int partitionIndex = findPartitionIndex(start, end, numbers);
            quickSort(start, partitionIndex - 1, numbers);
            quickSort(partitionIndex + 1, end, numbers);
        }
    }

    private int findPartitionIndex(int start, int end, int[] numbers) {
        int partitionIndex = start;
        
        int pivot = numbers[end];

        for (int i = start; i < end; ++i) {
            if (numbers[i] < pivot) {
                swap(i, partitionIndex, numbers);
                partitionIndex++;
            }
        }
        swap(end, partitionIndex, numbers);
        
        return partitionIndex;
    }

    private void swap(int i, int j, int[] numbers) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    // Merge sort - O(NlogN)
    // Recursively divide array on 1-2 elements arrays (like binary search by middle)
    // Sort 2 elements arrays
    // Concat 1-2 elements sorted arrays to 3-4 elements arrays
    // Sort 3-4 elements arrays
    // Concat 3-4 elements sorted arrays to 6-8 elements arrays
    // Sort 6-8 elements arrays
    // etc.
    // Divide and Conquer +
    // Stability -
    // Recursive +
    public int[] mergeSortArray(int[] numbers) {
        return mergeSortArray(0, numbers.length - 1, numbers);
    }

    private int[] mergeSortArray(int start, int end, int[] numbers) {
        int difference = (end - start);

        if (difference == 0) {
            int[] array = new int[1];
            array[0] = numbers[start];
            return array;
        }

        if (difference == 1) {
            int[] array = new int[2];
            if (numbers[start] < numbers[end]) {
                array[0] = numbers[start];
                array[1] = numbers[end];
            } else {
                array[0] = numbers[end];
                array[1] = numbers[start];
            }
            return array;
        }

        int middle = (end + start) / 2;

        int[] sortedLeft = mergeSortArray(start, middle, numbers);
        int[] sortedRight = mergeSortArray(middle + 1, end, numbers);

        return mergeSortedArrays(sortedLeft, sortedRight);
    }

    private int[] mergeSortedArrays(int[] sortedA, int[]sortedB) {
        int[] array = new int[sortedA.length + sortedB.length];

        int aIndex = 0;
        int bIndex = 0;
        int i = 0;

        while (i != sortedA.length + sortedB.length) {
            if (aIndex >= sortedA.length) {
                array[i] = sortedB[bIndex];
                bIndex++;
            } else if (bIndex >= sortedB.length) {
                array[i] = sortedA[aIndex];
                aIndex++;
            } else if (sortedA[aIndex] < sortedB[bIndex]) {
                array[i] = sortedA[aIndex];
                aIndex++;
            } else {
                array[i] = sortedB[bIndex];
                bIndex++;
            }

            i++;
        }
        
        return array;
    }

    // Insertion sort - O(N^2)
    // Swap number to left until left number is smaller
    // Stability + 
    // Recursive -
    public int[] insertionSortArray(int []numbers) {
        if (numbers.length == 1) {
            return numbers;
        }

        for (int i = 1; i < numbers.length; ++i) {
            int j = i - 1;
            int number = numbers[i];
            while (j >= 0 && number < numbers[j]) {
                numbers[j + 1] = numbers[j];
                j--;
            }
            numbers[j + 1] = number;
        }
        return numbers;
    }

    // Selection sort - O(N^2)
    // n times find minimum value, when found - swap min to the left of array
    // Stability +
    // Recursive -
    public int[] selectionSortArray(int[] numbers) {
        for (int i = 0; i < numbers.length; ++i) {
            int minIndex = selectionFindMinIndex(i, numbers);
            int temp = numbers[i];
            numbers[i] = numbers[minIndex];
            numbers[minIndex] = temp;
        }
        return numbers;
    }

    private int selectionFindMinIndex(int start, int[] numbers) {
        int minIndex = start;
        int minValue = numbers[start];
        while (start < numbers.length) {
            if (numbers[start] < minValue) {
                minIndex = start;
                minValue = numbers[start];
            }
            start++;
        }
        return minIndex;
    }

    // Bubble sort - O(N^2)
    // n times find minimum value replacing
    // Stability +
    // Recursive - 
    public int[] bubbleSortArray(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] > nums[j]) {
                    int number = nums[i];
                    nums[i] = nums[j];
                    nums[j] = number;
                }
            }
        }
        return nums;
    }
}
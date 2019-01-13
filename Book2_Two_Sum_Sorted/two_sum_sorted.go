package taskbook2

func twoSumSorted(sortedNumbers []int, target int) []int {
	numbersLength := len(sortedNumbers)

	// Skip invalid array
	if numbersLength < 2 {
		return []int{}
	}

	// Skip if target is less than sum of smallest numbers
	if sortedNumbers[0]+sortedNumbers[1] > target {
		return []int{}
	}

	// Skip if target is greater than sum of largest numbers
	if sortedNumbers[numbersLength-1]+sortedNumbers[numbersLength-2] < target {
		return []int{}
	}

	cache := make(map[int]int)

	for index, number := range sortedNumbers {
		difference := target - number

		// Try to find index of difference number in cache
		if prevIndex, ok := cache[difference]; ok {
			return []int{prevIndex, index}
		}

		// Try to find index of difference number by bynary search
		binarySearchedIndex := binarySearchWithCaching(sortedNumbers, 0, numbersLength-1, difference, cache)
		if binarySearchedIndex != -1 {
			return []int{binarySearchedIndex, index}
		}

		// Put currently checked number into cache for further findings
		cache[number] = index
	}

	return []int{}
}

func binarySearchWithCaching(sortedNumbers []int, start int, end int, element int, cache map[int]int) int {
	if start < 0 || end < 0 {
		return -1
	}

	if sortedNumbers[start] == element {
		return start
	}

	if sortedNumbers[end] == element {
		return end
	}

	middlePosition := (start + end) / 2 // TODO replace with byte operation like (end-start) >>> 2
	middleElement := sortedNumbers[middlePosition]

	// Put current number into numbers cache if it was not evaluated before
	if _, ok := cache[middleElement]; !ok {
		cache[middleElement] = middlePosition
	}

	if element > middleElement {
		return binarySearchWithCaching(sortedNumbers, middlePosition, end-1, element, cache)
	}
	if element < middleElement {
		return binarySearchWithCaching(sortedNumbers, start, middlePosition-1, element, cache)
	}
	return middlePosition
}

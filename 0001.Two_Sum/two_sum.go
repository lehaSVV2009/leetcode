package task0001

func twoSum(numbers []int, target int) []int {
	for firstArgIndex, number := range numbers {
		difference := target - number
		for secondArgIndex := firstArgIndex + 1; secondArgIndex < len(numbers); secondArgIndex++ {
			if difference == numbers[secondArgIndex] {
				return []int{firstArgIndex, secondArgIndex}
			}
		}
	}
	return []int{}
}

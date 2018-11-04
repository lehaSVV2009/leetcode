package task0001

func twoSum2(numbers []int, target int) []int {
	numberIndexMap := make(map[int]int)
	for index, number := range numbers {
		difference := target - number

		if prevIndex, ok := numberIndexMap[difference]; ok {
			return []int{prevIndex, index}
		}

		numberIndexMap[number] = index
	}

	return []int{}
}

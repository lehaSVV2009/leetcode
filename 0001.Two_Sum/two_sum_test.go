package task0001

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func Test_two_sum_1_bruteforce(t *testing.T) {
	// given
	numbers := []int{0, 2, 5, 1}
	target := 3

	// when
	result := twoSum(numbers, target)

	// then
	assert.Equal(t, []int{1, 3}, result)
}

func Test_two_Sum_2_map(t *testing.T) {
	// given
	numbers := []int{0, 2, 5, 1}
	target := 3

	// when
	result := twoSum2(numbers, target)

	// then
	assert.Equal(t, []int{1, 3}, result)
}

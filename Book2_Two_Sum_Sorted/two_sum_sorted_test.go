package taskbook2

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func Test_two_sum_sorted(t *testing.T) {
	// given
	sortedNumbers := []int{0, 1, 2, 5}
	target := 3

	// when
	result := twoSumSorted(sortedNumbers, target)

	// then
	assert.Equal(t, []int{2, 1}, result)
}

func Test_two_sum_sorted_not_found(t *testing.T) {
	// given
	sortedNumbers := []int{1, 2, 6, 11, 23, 34, 56, 67, 92}
	target := 4

	// when
	result := twoSumSorted(sortedNumbers, target)

	// then
	assert.Equal(t, []int{}, result)
}

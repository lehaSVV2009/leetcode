package taskbook2

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func Test_two_sum_sorted(t *testing.T) {
	// given
	numbers := []int{0, 2, 5, 1}
	target := 3

	// when
	result := twoSumSorted(numbers, target)

	// then
	assert.Equal(t, []int{1, 3}, result)
}

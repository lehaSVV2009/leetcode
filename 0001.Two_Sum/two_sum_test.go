package task_0001

import (
	"testing"
	"github.com/stretchr/testify/assert"
)

func Test_Two_Sum(t *testing.T) {
	// given
	numbers := []int{0, 2, 5, 1}
	target := 3

	// when
  result := TwoSum(numbers, target)

	// then
	assert.ElementsMatch(t, result, []int{0, 3})
}

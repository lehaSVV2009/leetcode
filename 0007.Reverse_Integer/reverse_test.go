package task0007

import (
	"testing"

	"github.com/stretchr/testify/assert"

	"strconv"
)

var table = []struct {
	in  int
	out int
}{
	{123, 321},
	{-123, -321},
	{120, 21},
	{55555, 55555},
	{123456, 654321},
	{2147483647, 0},
	{-2147483648, 0},
	{7463847412, 2147483647},
	{8463847412, 0},
	{-9463847412, 0},
}

func Test_reverse(suite *testing.T) {
	for _, row := range table {
		suite.Run("should reverse "+strconv.Itoa(row.in)+" to "+strconv.Itoa(row.out), func(t *testing.T) {
			result := reverse(row.in)
			assert.Equal(t, row.out, result)
		})
	}
}

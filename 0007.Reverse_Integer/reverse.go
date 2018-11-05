package task0007

var maxIntDividedBy10 = 214748364
var minIntDividedBy10 = -214748364

func willOverflowAfterMultiple10(number int, addendum int) bool {
	// overflow maxint check
	if number > maxIntDividedBy10 || (number == maxIntDividedBy10 && addendum > 7) {
		return true
	}
	// overflow minint check
	return number < minIntDividedBy10 || (number == minIntDividedBy10 && addendum < -8)
}

func reverse(x int) int {
	result := 0

	// optimization to not check small values on overflow
	canOverflow := x > 1000000000 || x < -1000000000

	for x != 0 {
		remainder := x % 10
		if canOverflow && willOverflowAfterMultiple10(result, remainder) {
			return 0
		}
		result = result*10 + remainder
		x /= 10
	}

	return result
}

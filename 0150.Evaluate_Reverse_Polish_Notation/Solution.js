/**
 * @param {string[]} tokens
 * @return {number}
 */
var evalRPN = function(tokens) {
  // Reversed polish notation?
  // Always valid, right?
  // Operators count = numbers count - 1
  // empty array? - null
  // one value array? - 2
  // out of memory?

  // 4 5 + -> 4 + 5 = 9
  // 4 5 - -> 4 - 5 = -1
  // 4 5 6 * / -> 4 / (5 * 6)
  // ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"] =>
  // (10 * (6 / ((9 + 3) * -11))) + 17 + 5

  // stack or queue
  // 4 5 /
  // result = null
  // foreach
  //   if number
  //     push to stack
  //     continue
  //   if operator
  //     if result = null
  //        result = pop from stacklast value
  //     stack_value = pop from stack last value
  //     result = stack_value op result

  var stack = [];

  tokens.forEach(token => {
    if (isOperator(token)) {
      var right = stack.pop();
      var left = stack.pop();
      stack.push(eval(left, token, right));
    } else {
      stack.push(Number(token));
    }
  });

  return stack.pop();
};

function isOperator(token) {
  return ["+", "-", "/", "*"].includes(token);
}

function eval(arg1, operator, arg2) {
  switch (operator) {
    case "+":
      return arg1 + arg2;
    case "-":
      return arg1 - arg2;
    case "*":
      return arg1 * arg2;
    case "/":
      return Math.trunc(arg1 / arg2);
    default:
      throw new Error("Unknown operator" + operator);
  }
}

// Solution 1
// array inside + headIndex
// store min variable
// What to do with getMin() and pop()? on push store to sorted array?? Not O(1) for push
// push(x) -> ?O(1)
// pop() -> ?O(1)
// top() -> ?O(1)
// getMin() -> ???

/**
 * initialize your data structure here.
 */
var MinStack = function() {
  this.stack = [];
  this.min = [];
};

/**
 * @param {number} x
 * @return {void}
 */
MinStack.prototype.push = function(x) {
  this.stack.push(x);
  if (this.min.length === 0) {
    this.min.push(x);
  } else {
    this.min.push(Math.min(x, this.min[this.min.length - 1]));
  }
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function() {
  this.stack.pop();
  this.min.pop();
};

/**
 * @return {number}
 */
MinStack.prototype.top = function() {
  return this.stack.length === 0 ? null : this.stack[this.stack.length - 1];
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function() {
  return this.min.length === 0 ? null : this.min[this.min.length - 1];
};

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */

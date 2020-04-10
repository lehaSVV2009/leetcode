// top if no elements?
// pop if no elements?
// getMin if no elements?

// Solution 1
// Simple stack (array), but with getMin method, that goes through all items in stack

// Solution 2
// Store minValue. 
// How?
// minValue variable. But what to do if pop is called? recalculate after push and pop?
// minValue as array?
// minValue as stack of current minValue ()
// push:
//   if current value less than top of minStack than current value is added to minStack
//   else top value to min stack
//   O(1)
// pop:
//   pop both stack and minStack
// getMin:
//   top of minStack

/**
 * initialize your data structure here.
 */
var MinStack = function() {
  this.stack = [];
  this.minStack = [];
};

/** 
* @param {number} x
* @return {void}
*/
MinStack.prototype.push = function(x) {
  this.stack.push(x);
  if (this.minStack.length === 0 || x <= this.minStack[this.minStack.length - 1]) {
      this.minStack.push(x);
  }
};

/**
* @return {void}
*/
MinStack.prototype.pop = function() {
  const popped = this.stack.pop();
  
  if (popped === this.minStack[this.minStack.length - 1]) {
      this.minStack.pop();
  }

  return popped;
};

/**
* @return {number}
*/
MinStack.prototype.top = function() {
  return this.stack[this.stack.length - 1];
};

/**
* @return {number}
*/
MinStack.prototype.getMin = function() {
  return this.minStack[this.minStack.length - 1];
};

/** 
* Your MinStack object will be instantiated and called as such:
* var obj = new MinStack()
* obj.push(x)
* obj.pop()
* var param_3 = obj.top()
* var param_4 = obj.getMin()
*/
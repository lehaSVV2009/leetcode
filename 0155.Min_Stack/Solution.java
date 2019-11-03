class Solution {
    
    private Deque<Integer> stack = new ArrayDeque<Integer>();
    private Deque<Integer> min = new ArrayDeque<Integer>();
    
    public void push(int x) {
        stack.push(x);
        min.push(min.size() == 0 ? x : Math.min(x, min.peek()));
    }

    public void pop() {
        if (stack.size() > 0) {
            stack.pop();
            min.pop();
        }
    }

    public int top() {
        return stack.size() == 0 ? -1 : stack.peek();
    }

    public int getMin() {
        return min.size() == 0 ? -1 : min.peek();
    }
}

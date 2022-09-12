class StackItem {
    private int val;
    private int minVal;
    
    public StackItem(int v, int mV) {
        this.val = v;
        this.minVal = mV;
    }
    
    public int getVal() {
        return val;
    }
    
    public int getMinVal() {
        return minVal;
    }
}

class MinStack {

    private Stack<StackItem> stack;
    
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()) {
            stack.push(new StackItem(val, val));
        } else {
            int minVal = stack.peek().getMinVal();
            if(val < minVal) minVal = val;
            stack.push(new StackItem(val, minVal));
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().getVal();
    }
    
    public int getMin() {
        return stack.peek().getMinVal();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
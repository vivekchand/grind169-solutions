class MyQueue {
    Stack<Integer> s1 = new Stack();
    Stack<Integer> s2 = new Stack();
    Integer front = -1;
    
    public MyQueue() {
        
    }
    
    public void push(int x) {
        if(s1.isEmpty())
            front = x;
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(x);
        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }
    
    public int pop() {
        int res = s1.pop();
        if(!s1.isEmpty()) 
            front = s1.peek();
        return res;
    }
    
    public int peek() {
        return front;
    }
    
    public boolean empty() {
        return s1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
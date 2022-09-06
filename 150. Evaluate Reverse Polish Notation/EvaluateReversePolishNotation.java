class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();
        
        for(String token : tokens) {
            if(token.equals("+")) {
                int b = numStack.pop();
                int a = numStack.pop();
                int res = a + b;
                numStack.push(res);
            } else if(token.equals("-")) {
                int b = numStack.pop();
                int a = numStack.pop();
                int res = a - b;
                numStack.push(res);
            } else if(token.equals("*")) {
                int b = numStack.pop();
                int a = numStack.pop();
                int res = a * b;
                numStack.push(res);
            } else if(token.equals("/")) {
                int b = numStack.pop();
                int a = numStack.pop();
                int res = a / b;
                numStack.push(res);
            } else {
                numStack.push(Integer.parseInt(token));
            }
        }
        return numStack.pop();
    }
}
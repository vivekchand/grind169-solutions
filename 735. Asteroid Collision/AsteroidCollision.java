class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < asteroids.length; i++) {
            int curr = asteroids[i];
            
            // if the current asteroid is moving to the right or stack is empty
            if (curr > 0 || stack.isEmpty()) {
                stack.push(curr);
            }
            // current asteroid is moving to the left
            else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(curr)) {
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(curr);
                }
                else if (stack.peek() == Math.abs(curr)) {
                    stack.pop();
                }
            }
        }
        
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return result;
    }
}

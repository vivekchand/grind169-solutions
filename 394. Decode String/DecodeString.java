class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int num = 0;
        
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                numStack.push(num);
                strStack.push(currentString);
                currentString = new StringBuilder();
                num = 0;
            } else if (c == ']') {
                StringBuilder temp = currentString;
                currentString = strStack.pop();
                int repeatTimes = numStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    currentString.append(temp);
                }
                num = 0;
            } else {
                currentString.append(c);
            }
        }
        
        return currentString.toString();
    }
}

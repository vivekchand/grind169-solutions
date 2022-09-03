class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder res = new StringBuilder();
        int carry = 0;
        while(i >= 0 || j >=0) {
            int sum = carry;
            if(i >= 0) {
                sum +=  a.charAt(i--) - '0';
            }
            if(j >= 0) {
                sum +=  b.charAt(j--) - '0';
            }            
            res.append(sum % 2);
            carry = sum / 2;
        }
        if(carry != 0) {
            res.append(1);
        }
        return res.reverse().toString();
    }
}
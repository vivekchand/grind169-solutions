class Solution {
   public int myAtoi(String str) {
       int res = 0;
       int sign = 1;
       int i = 0;
       int n = str.length();
      
       while (i < n && str.charAt(i) == ' ') {
           i++;
       }
      
       if (i < n && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
           sign = str.charAt(i) == '+' ? 1 : -1;
           i++;
       }
      
       while (i < n && Character.isDigit(str.charAt(i))) {
           int digit = str.charAt(i) - '0';
           if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && digit > 7)) {
               return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
           }
           res = res * 10 + digit;
           i++;
       }
      
       return sign * res;
   }
}

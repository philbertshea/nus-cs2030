package Leetcode;

public class PalindromeFast {
    class Solution {
        public boolean isPalindrome(int x) {
            boolean result = true;
            String xString = Integer.toString(x);
            int i = 0;
           while(i < xString.length()/2 && result == true){
               if(xString.charAt(i) != xString.charAt(xString.length() - i - 1)){
                   result = false;
               }
               i++;
           }
           return result;
        }
    }
}

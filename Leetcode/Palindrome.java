/*
 * Given an integer x, return true if x is a 
palindrome
, and false otherwise.

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */

package Leetcode;

import java.util.*;

public class Palindrome {
    public static boolean isPalindrome(int x) {
        System.out.println("\n\n Test " + x);
        int numOfDigits = 0;
        int front = 0;
        int back = 0;

        // If negative, the number will never be a palindrome. [cannot have xxx-]
        if (x < 0) {
            return false;
        }
        if (x == 0 || x == 1) {
            return true;
        }

        // Max is 2^31 which has 10 digits.
        for (int i = 1; i < 11; i++) {
            if (x < Math.pow(10, i)) {
                numOfDigits = i;
                break;
            }
        }

        System.out.println(numOfDigits);

        front = (int) (x % 10);
        back = (int) (x / Math.pow(10, numOfDigits - 1));
        System.out.println("Front digit: " + front + " Back digit: " + back);

        if (front != back) {

            System.out.println("First not last");
            return false;
        }

        System.out.println("First is last");

        for (int j = 2; j <= numOfDigits / 2; j++) {
            front = (int) (x % Math.pow(10, j) / Math.pow(10, j - 1));
            back = (int) (x / Math.pow(10, numOfDigits - j) % 10);
            System.out.println("Front digit: " + front + " Back digit: " + back);

            if (front != back) {
                System.out.println("Not equal!");
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(1234321));
        System.out.println(isPalindrome(1000000001));
    }
}

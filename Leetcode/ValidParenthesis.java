/*
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

Input: s = "()"
Output: true

Input: s = "()[]{}"
Output: true

Input: s = "(]"
Output: false
 */

package Leetcode;

import java.util.*;

public class ValidParenthesis {
    public static boolean isValid(String s) {
        List<Character> match = new ArrayList<>();
        // Add ( / [ / { if entered.
        // If ) / ] / } is entered, check with the last element to see whether it is the
        // same type.
        // If same type, remove the open character.
        // If not the same type, return false.

        // At the end of iteration through the array, if the list is empty, return true.

        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {

            if ("()[]{}".indexOf(array[i]) == -1) {
                return false;
            }

            if ("([{".indexOf(array[i]) != -1) {
                match.add(array[i]);
            } else if (match.size() == 0) {
                return false;
            } else if (array[i] == ')') {
                if (match.get(match.size() - 1) != '(') {
                    return false;
                } else {
                    match.remove(match.size() - 1);
                }
            } else if (array[i] == ']') {
                if (match.get(match.size() - 1) != '[') {
                    return false;
                } else {
                    match.remove(match.size() - 1);
                }
            } else if (array[i] == '}') {
                if (match.get(match.size() - 1) != '{') {
                    return false;
                } else {
                    match.remove(match.size() - 1);
                }
            }
        }

        return match.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("[]"));
        System.out.println(isValid("((()))"));
        System.out.println(isValid("([{}])"));
        System.out.println(isValid("(([{}]])))"));
    }
}

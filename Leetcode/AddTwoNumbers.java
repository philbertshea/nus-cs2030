/** 2. Add Two Numbers
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 int val;
 ListNode next;
 ListNode() {}
 ListNode(int val) { this.val = val; }
 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/*
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Input: l1 = [0], l2 = [0]
Output: [0]

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 */

package Leetcode;

import java.util.*;

public class AddTwoNumbers {

    public static ListNode createListNode(List<Integer> sumList) {
        if (sumList.size() == 1) {
            System.out.println("Last Element i.e. the first digit");
            return new ListNode(sumList.get(0));
        } else {
            int toAdd = sumList.get(0);
            System.out.println("Add Element " + toAdd);
            sumList.remove(0);
            return new ListNode(toAdd, createListNode(sumList));
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        System.out.println("\n\n Add : " + l1 + " " + l2);
        long sum = 0;
        ListNode temp = new ListNode();
        List<Integer> no1 = new ArrayList<>();
        List<Integer> no2 = new ArrayList<>();
        List<Integer> sumList = new ArrayList<>();

        temp = l1;
        while (temp.next != null) {
            no1.add(temp.val);
            temp = temp.next;
        }
        if (temp.val != 0 || no1.isEmpty()) {
            // primitive types do not have null values. So if it is not initialised, an int
            // variable will have value of 0.
            // Since question assures us that there are no leading zeroes, we can ignore it.
            no1.add(temp.val);
        }

        temp = l2;
        while (temp.next != null) {
            no2.add(temp.val);
            temp = temp.next;
        }
        if (temp.val != 0 || no2.isEmpty()) {
            // primitive types do not have null values. So if it is not initialised, an int
            // variable will have value of 0.
            // Since question assures us that there are no leading zeroes, we can ignore it.
            no2.add(temp.val);
        }

        System.out.println("\nWe get: " + no1 + " " + no2);

        // Combine into two numbers.
        for (int i = 0; i < no1.size(); i++) {
            sum = sum + no1.get(i) * (long) Math.pow(10, i);
            System.out.println(i + " no1 add to: " + sum);
        }

        for (int j = 0; j < no2.size(); j++) {
            System.out.println("Add : " + no2.get(j) + " * " + Math.pow(10, j));
            sum = sum + no2.get(j) * (long) Math.pow(10, j);
            System.out.println(j + " no2 add to: " + sum);
        }

        System.out.println("Sum is " + sum);

        // If sum is 0, return 0
        if (sum == 0) {
            return new ListNode(0);
        }

        // After obtaining the sum, break the digits up.
        int digit = 0;
        for (int j = 1; j <= 100; j++) {

            digit = (int) (sum % Math.pow(10, j) / Math.pow(10, j - 1));
            sumList.add(digit);
            if (sum < Math.pow(10, j)) {
                break;
            }
        }

        System.out.println(sumList);


        return createListNode(sumList);
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        System.out.println(addTwoNumbers(l1, l2));

        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(0);
        addTwoNumbers(l3, l4);

        ListNode l5 = new ListNode(9,
                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l6 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        addTwoNumbers(l5, l6);

        ListNode l7 = new ListNode(9);
        ListNode l8 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))))));
        addTwoNumbers(l7, l8);

        System.out.println("HI!");
        ListNode l9 = new ListNode(1, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(1)))))))))))))))))))))))))))))));
        ListNode l10 = new ListNode(5, new ListNode(6, new ListNode(4)));
        addTwoNumbers(l9, l10);
    }
}

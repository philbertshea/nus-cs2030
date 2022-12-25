package Leetcode;

import java.util.*;

/*
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, List<Integer>> numToIndex = new HashMap<>();
        for (int k = 0; k < nums.length; k++) {
            if (numToIndex.containsKey(nums[k])) {
                if (numToIndex.get(nums[k]).size() != 1) {
                    continue;
                }
                int existing = numToIndex.get(nums[k]).get(0);
                numToIndex.put(nums[k], Arrays.asList(existing, k));
            } else {
                numToIndex.put(nums[k], Arrays.asList(k));
            }

        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + nums[i + 1] > target) {
                break;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    if (nums[i] == nums[j]) {
                        int[] ans = { numToIndex.get(nums[i]).get(0), numToIndex.get(nums[j]).get(1) };
                        return ans;
                    } else {
                        int[] ans = { numToIndex.get(nums[i]).get(0), numToIndex.get(nums[j]).get(0) };
                        return ans;
                    }
                } else if (nums[i] + nums[j] > target) {
                    break;
                }
            }
        }
        int[] ans = { 0, 0 };
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int[] ans = twoSum(nums, 9);
        for (int x : ans) {
            System.out.println(x);
        }
    }
}

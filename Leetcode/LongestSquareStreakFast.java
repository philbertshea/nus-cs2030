package Leetcode;

import java.util.*;

public class LongestSquareStreakFast {
    class Solution {
        public int longestSquareStreak(int[] nums) {
          Arrays.sort(nums);
          int max = -1;
          Set<Integer> set = new HashSet<>();
          for (int num: nums) set.add(num);
          for (int i = 0; i < nums.length; i++) {
            int num =  nums[i];
            int count = 1;

            // Function of a set: Contains! Just use the contains method!
            while (set.contains((int) Math.pow(num, 2))){
              count++;
              num = (int) Math.pow(num, 2);
              max = Math.max(max, count);
            }
          }
          return max;
        }
      }
}

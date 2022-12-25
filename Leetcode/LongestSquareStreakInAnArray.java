// 2501. Longest Square Streak in an array
// E.g. numsNew = [2,6,4,12,16]
// Longest is 3, return 3. 2, 4, 16

package Leetcode;

import java.util.*;

public class LongestSquareStreakInAnArray {
    static int allMax = 0;

    public static void searchSquare(Integer[] numsNew, List<Integer> streak, int lastPos) {
        if (streak.size() < 5) {
            int lastEl = numsNew[lastPos];
            System.out.println("Lastel: " + lastEl);
            for (int j = 1; j < numsNew.length - lastPos; j++) {
                if (numsNew[lastPos + j] == lastEl * lastEl) {
                    System.out.println("Square found. " + lastEl + " squared to " + numsNew[lastPos + j]);
                    streak.add(numsNew[lastPos + j]); // Problem is that we cannot use streak.length because it cannot
                                                   // differentiate null spaces and filled spaces in the array.
                    System.out.println("Search again. \n\n");
                    searchSquare(numsNew, streak, lastPos + j);
                    break;
                }
            }
            if (allMax < streak.size()) {
                allMax = streak.size();
            }
        } else {
            allMax = 5;
        }

    }

    public static int longestSquareStreak(int[] nums) {
        List<Integer> streak = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int x: nums) {
            set.add(x);
        }
        Integer[] numsNew = set.toArray(new Integer[set.size()]);
        Arrays.sort(numsNew);
        

        int i = 0;
        while (numsNew[i] * numsNew[i] <= numsNew[numsNew.length - 1]) {
            streak.clear();
            System.out.println("Scan num" + numsNew[i]);
            streak.add(numsNew[i]);
            System.out.println("Streak is: " + streak);
            searchSquare(numsNew, streak, i);
            i = i + 1;
            if (i == numsNew.length - 1) {
                break;
            }
        }
        System.out.println(allMax);
        return allMax > 1 ? allMax : -1;

    }

    public static void main(String[] args) {
        int[] numsNew = { 4,3,6,16,8,2 };
        System.out.println(longestSquareStreak(numsNew));
    }
}

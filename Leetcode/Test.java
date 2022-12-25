package Leetcode;
class Solution {
    public boolean anyMatch(List<Integer> list, List<List<Integer>> all) {
        for (List<Integer> li : all) {
            for (int i = 0; i < 3; i++) {
                if (li.contains(list.get(i))) {
                    li.remove(li.indexOf(list.get(i)));
                } else {
                    break;
                }
            }
            if (li.size() == 0) {
                return true;
            }
        }
        return false;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> all = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        if (!anyMatch(list, all)) {
                            all.add(list);
                        }
                    }
                }
            }
        }
        return all;
    }
}
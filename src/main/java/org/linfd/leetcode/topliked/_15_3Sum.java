package org.linfd.leetcode.topliked;

import java.util.*;

/**
 * #15 3Sum
 * <p>
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * <p>
 * Note:
 * The solution set must not contain duplicate triplets.
 * <p>
 * <p>
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class _15_3Sum {

    /**
     * Best Answer
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        Integer last = null;
        int firstIdx, lastIdx, sum;
        for(int i = 0; i < nums.length - 2; i++) {
            if (Objects.equals(last, nums[i])) continue;

            int cur = nums[i];
            firstIdx = i + 1;
            lastIdx = nums.length - 1;

            while (firstIdx < lastIdx) {
                sum = cur + nums[firstIdx] + nums[lastIdx];

                if (sum == 0) {
                    List<Integer> ans = new ArrayList<>();
                    ans.add(cur);
                    ans.add(nums[firstIdx]);
                    ans.add(nums[lastIdx]);
                    res.add(ans);
                }

                if (sum < 0) {
                    //remove duplicate
                    while (firstIdx < nums.length -2 && nums[firstIdx] == nums[firstIdx + 1]) firstIdx ++;
                    firstIdx ++;
                } else {
                    //remove duplicate
                    while (lastIdx > 0 && nums[lastIdx] == nums[lastIdx - 1]) lastIdx --;
                    lastIdx --;
                }
            }

            last = nums[i];
        }
        return res;
    }


//    /**
//     * Original Answer
//     * @param nums
//     * @return
//     */
//    public static List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> res = new ArrayList<List<Integer>>();
//        Set<String> duplicate = new HashSet<>();
//
//        Arrays.sort(nums);
//        Integer last = null;
//        for(int i = 0; i < nums.length - 2; i++){
//            if(Objects.equals(last, nums[i])) continue;
//
//            int subLength = nums.length - i - 1;
//            int[] subNums = new int[subLength];
//            System.arraycopy(nums, i + 1, subNums, 0, subLength);
//            twoSum(subNums, -nums[i], res, duplicate);
//            last = nums[i];
//        }
//        return res;
//    }
//
//    private static void twoSum(int[] nums, int target, List<List<Integer>> res, Set<String> duplicate) {
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            Integer difference = target - nums[i];
//            if(set.contains(difference)) {
//                List<Integer> ans = new ArrayList<>();
//
//                //remove duplicate
//                String key = new StringBuilder().append(-target).append(difference).append(nums[i]).toString();
//                if(!duplicate.contains(key)){
//                    ans.add(-target);
//                    ans.add(difference);
//                    ans.add(nums[i]);
//                    res.add(ans);
//                }
//            }
//            set.add(nums[i]);
//        }
//    }
//
//    public static void main(String[] args){
//        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
//        List<List<Integer>> res = threeSum(nums);
//        for (List<Integer> re : res) {
//            re.forEach(r -> {
//                System.out.print(r);
//                System.out.print(",");
//            });
//            System.out.println();
//        }
//    }


}

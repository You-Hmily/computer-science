package org.hmily.cs.leetcode.problems.TwoSum_1;

import java.util.ArrayList;

public class Solution {

    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     *
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     * Example:
          Given nums = [2, 7, 11, 15], target = 9,
          Because nums[0] + nums[1] = 2 + 7 = 9,
          return [0, 1].
     */
    public static int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        ArrayList arrayList = new ArrayList();
        for (int i = 0;i<length;i++){
            int num1 = nums[i];
            for (int k = i+1;k<length;k++){
                int num2 = nums[k];
                if (num1+num2 == target){
                    arrayList.add(i);
                    arrayList.add(k);
                }
            }
        }
        int[] indexArr = new int[arrayList.size()];
        for (int i = 0;i<arrayList.size();i++){
            indexArr[i]= (int) arrayList.get(i);
        }
        return indexArr;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] ints= twoSum(nums,target);
        System.out.println(ints.toString());
    }

}

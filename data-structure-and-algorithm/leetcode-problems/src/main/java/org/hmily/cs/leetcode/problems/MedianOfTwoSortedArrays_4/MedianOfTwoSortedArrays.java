package org.hmily.cs.leetcode.problems.MedianOfTwoSortedArrays_4;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;

public class MedianOfTwoSortedArrays {

    /**
     * There are two sorted arrays nums1 and nums2 of size m and n respectively.
     * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
     * You may assume nums1 and nums2 cannot be both empty.
     *
     * Example 1:
     *   nums1 = [1, 3]
     *   nums2 = [2]
     *   The median is 2.0
     *
     * Example 2:
     *   nums1 = [1, 2]
     *   nums2 = [3, 4]
     *   The median is (2 + 3)/2 = 2.5
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] newArr = mergeArray(nums1,nums2);
        int newLength = newArr.length;
        if ( newLength % 2 ==0){
            int index1 = newLength/2;
            int index2 = index1-1;
            double median = newArr[index1]+newArr[index2];
            return median/2.0;
        }
        int index = (newLength+1)/2;
        return newArr[index-1];
    }

    public static int[] mergeArray(int[] nums1, int[] nums2){
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] newArr = new int[length1+length2];
        int index = 0;
        int newIndex = 0;
        while (true){
            if (index<length1 && index<length2){
                int num1 = nums1[index];
                int num2 = nums2[index];
                if (num1>num2){
                    newArr[newIndex++]=num2;
                    newArr[newIndex++]=num1;
                }else{
                    newArr[newIndex++]=num1;
                    newArr[newIndex++]=num2;
                }
            }else if (index < length1 && index >= length2){
                int num1 = nums1[index];
                newArr[newIndex++]=num1;
            }else if (index >= length1 && index < length2){
                int num2 = nums2[index];
                newArr[newIndex++]=num2;
            }
            if (index >= length1 && index >= length2){
                break;
            }
            index++;
        }
        return sortNewArr(newArr);
    }

    private static int[] sortNewArr(int[] arr){
        for (int i=0;i<arr.length;i++){
            for (int k = i+1;k<arr.length;k++){
                if (arr[i]>arr[k]){
                    int temp = arr[i];
                    arr[i] = arr[k];
                    arr[k] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
       int[] nums1 =new int[]{1,3};
       int[] nums2 =new int[]{2};

       double median = findMedianSortedArrays(nums1,nums2);

       System.out.println(median);

    }



}

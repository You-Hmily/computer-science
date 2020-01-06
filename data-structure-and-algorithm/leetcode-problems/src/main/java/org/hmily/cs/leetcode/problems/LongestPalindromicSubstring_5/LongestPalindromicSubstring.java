package org.hmily.cs.leetcode.problems.LongestPalindromicSubstring_5;

public class LongestPalindromicSubstring {


    /**
     * Given a string s, find the longest palindromic substring in s.
     * You may assume that the maximum length of s is 1000.
     *
     * Example 1:
     *   Input: "babad"
     *   Output: "bab"
     *   Note: "aba" is also a valid answer.
     * Example 2:
     *   Input: "cbbd"
     *   Output: "bb"
     */
    public static String longestPalindrome(String s) {
        if (s == null){
            return null;
        }
        char[] chars = s.toCharArray();
        int charsLength = chars.length;
        if (charsLength == 0||charsLength == 1){
            return s;
        }
        String subStr = null;
        int length = 0;
        int index = 0;
        for (int i=0;i<charsLength;i++){
            char c1 = chars[i];
            for (int k = i+1;k<charsLength;k++){
                index = k;
                char c2 = chars[k];
                String newStr = null;
                if (c1 == c2){
                    index++;
                    if ( k+1 >= charsLength){
                        newStr= s.substring(i);
                    }else {
                        newStr = s.substring(i,k+1);
                    }
                    int newLength = newStr.length();
                    if (newLength<=3){
                        subStr = newStr;
                        length = newLength;
                    }
                }
            }
            if (subStr == null){
                subStr = s.substring(i,i+1);
                index = 0;
            }
            if (index == charsLength && i==0){
                return s;
            }
            if (length ==3){
                break;
            }
        }
        return subStr;
    }


    public static void main(String[] args) {
        String s = longestPalindrome("babad");
        System.out.println(s);
    }
}

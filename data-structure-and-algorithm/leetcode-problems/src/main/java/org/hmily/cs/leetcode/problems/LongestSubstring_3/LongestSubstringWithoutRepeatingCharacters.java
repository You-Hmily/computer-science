package org.hmily.cs.leetcode.problems.LongestSubstring_3;

import com.sun.deploy.util.StringUtils;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        int length = lengthOfLongestSubstring("au");
        System.out.println(length);
    }


    /**
     * Given a string, find the length of the longest substring without repeating characters.
     *
     * Example 1:
          Input: "abcabcbb"
          Output: 3
          Explanation: The answer is "abc", with the length of 3.

       Example 2:
          Input: "bbbbb"
          Output: 1
          Explanation: The answer is "b", with the length of 1.

       Example 3:
          Input: "pwwkew"
          Output: 3
          Explanation: The answer is "wke", with the length of 3.
                       Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        if (length == 1){
            return length;
        }
        Map<Character,Character> repeatMap = new HashMap<Character,Character>();
        int maxLength = 0;
        int newMaxLenth = 0;
        for (int i=0;i<length;i++){
            char c = chars[i];
            repeatMap.put(c,c);
            for (int k = i+1;k<length;k++){
                char ck = chars[k];
                Object repObj = repeatMap.get(ck);
                if (repObj == null){
                    repeatMap.put(ck,ck);
                }else {
                    break;
                }
            }
            newMaxLenth = repeatMap.size();
            repeatMap.clear();
            if (newMaxLenth>maxLength){
                maxLength = newMaxLenth;
            }
        }
        return maxLength;
    }

}

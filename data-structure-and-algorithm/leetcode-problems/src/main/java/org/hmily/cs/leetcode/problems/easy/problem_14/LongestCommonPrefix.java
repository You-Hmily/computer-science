package org.hmily.cs.leetcode.problems.easy.problem_14;


/**
 * Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.

 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        String result = "";
        if(strs.length==0){
            return result;
        }
        if(strs.length==1){
            return strs[0];
        }
        String str1 = strs[0];
        for(int i=0;i<str1.length();i++){
            Character c1 = getChar(str1, i);
            boolean equalsFlag = true;
            for(int j=1;j<strs.length;j++){
                Character c2 = getChar(strs[j], i);
                if (c2==null){
                    equalsFlag = false;
                    break;
                }
                if(!c1.equals(c2)){
                    equalsFlag = false;
                    break;
                }
            }
            if(!equalsFlag){
                 return result;
            }
            result+=c1;
        }
        return result;
    }


    private static Character getChar(String str,int index){
        if(index>=str.length()){
            return null;
        }
        return str.charAt(index);
    }



}
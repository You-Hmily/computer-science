package org.hmily.cs.leetcode.problems.easy.problem_7;

import java.util.Stack;

public class ReverseInteger{
      
    public static int reverse(int x){
        if(x == Integer.MIN_VALUE) return 0;
        int neg = 1;
        if (x<0){
            neg = -1;
        }
        x = neg * x;
        int ret = 0;
        while(x>0){
            int n = ret;
            n *= 10;
            n += x%10;
            x /= 10;
            if(n/10 != ret){
                return 0;
            }
            ret = n;

        }
        return ret*neg;
    }

    public static void main(String[] args){
           System.out.println(reverse(-123));
    }
}



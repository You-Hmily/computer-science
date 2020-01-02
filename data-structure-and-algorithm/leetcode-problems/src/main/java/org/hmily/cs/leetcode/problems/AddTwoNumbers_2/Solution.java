package org.hmily.cs.leetcode.problems.AddTwoNumbers_2;


import org.w3c.dom.NodeList;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {


    public static void main(String[] args) {
        // [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]
        //[5,6,4]
        ListNode l1 = createListNode("1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1");
        // [1,9,9,9,9,9,9,9,9,9]
        ListNode l2 = new ListNode(5);
        ListNode n1 = new ListNode(6);
        ListNode n2 = new ListNode(4);
        l2.next = n1;
        n1.next = n2;
        ListNode listNode = addTwoNumbers(l1,l2);
        System.out.println(listNode);
    }

    private static ListNode createListNode(String s){
        ListNode listNode = null;
        ListNode nextNode = null;
        String[] strs = s.split(",");
        int index = 0;
        for (String s1:strs){
            int num = Integer.parseInt(s1);
            ListNode newNode = new ListNode(num);
            if (index == 0){
                listNode = newNode;
                nextNode = listNode;
            }else {
                nextNode.next = newNode;
                nextNode = newNode;
            }
            index++;
        }
        return listNode;
    }

    /**
     You are given two non-empty linked lists representing two non-negative integers.
     The digits are stored in reverse order and each of their nodes contain a single digit.
     Add the two numbers and return it as a linked list.

     You may assume the two numbers do not contain any leading zero, except the number 0 itself.

     Example:
       Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
       Output: 7 -> 0 -> 8
       Explanation: 342 + 465 = 807.
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long num1 = convertListNodeToNumber(l1);
        long num2 = convertListNodeToNumber(l2);
        long num = num1 + num2;
        return convertNumberToListNode(num);
    }

   public static long convertListNodeToNumber(ListNode listNode){
        long num = listNode.val;
        long i = 1;
        while (listNode.next != null){
            listNode = listNode.next;
            if (listNode.val != 0){
                num = listNode.val * i * 10 + num;
            }
            i = i*10;
        }
        return num;
   }

   public static ListNode convertNumberToListNode(long num){
        if (num<10){
            return new ListNode((int) num);
        }
        ListNode listNode = new ListNode((int) (num % 10));
        num = num / 10;
        ListNode nextNode = listNode;
        while (num>0){
            int i = (int) (num % 10);
            ListNode newNode = new ListNode(i);
            nextNode.next = newNode;
            nextNode = newNode;
            num = num / 10;
        }
        return listNode;
   }


    /**
     * 链表节点
     */
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}

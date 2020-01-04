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

        int value  = 2 % 10;

        System.out.println(value);
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
        ListNode newList = new ListNode(0);
        int carry = 0;
        ListNode tail = newList;
        while (l1 != null || l2 != null || carry != 0){
            int value  = carry;
            if (l1 != null){
                value += l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                value += l2.val;
                l2 = l2.next;
            }
            int digit = value % 10;
            carry = value/10;
            ListNode newNode = new ListNode(digit);
            tail.next = newNode;
            tail = tail.next;
        }
        return newList.next;
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

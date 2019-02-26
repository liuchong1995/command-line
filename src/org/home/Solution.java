package org.home;

/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.chrono.IsoChronology;
import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode temp = new ListNode(-1);
        ListNode res = temp;
        Stack<ListNode> s = new Stack<>();
        while (head != null){
            s.push(head);
            if (head.next != null){
                s.push(head.next);
                temp.next = s.pop();
                temp.next.next = s.pop();
                temp = temp.next.next;
                head = head.next.next;
            } else{
                temp.next = s.pop();
                break;
            }
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode test = new ListNode(-1);
        ListNode t = test;
        for (int i = 1; i < 5; i++) {
            test.next = new ListNode(i);
            test= test.next;
        }
        t = t.next;
        ListNode restt = swapPairs(t);
        System.out.println();
    }
}

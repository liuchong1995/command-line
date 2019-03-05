package org.home.linkedlist.l24;

import org.home.LinkedListHelper;
import org.home.ListNode;

class Solution {
    public ListNode swapPairs(ListNode head) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead;
        while(p.next != null && p.next.next != null ){
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;
            node2.next = node1;
            node1.next = next;
            p.next = node2;
            p = node1;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] tt = {1,2,3,4,5};
        ListNode ttt = LinkedListHelper.generate(tt);
        System.out.println(new Solution().swapPairs(ttt));
    }
}
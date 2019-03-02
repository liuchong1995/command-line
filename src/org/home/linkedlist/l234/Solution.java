package org.home.linkedlist.l234;

import org.home.LinkedListHelper;
import org.home.ListNode;

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;
        if (head.next == null)
            return true;
        ListNode slow = head, fast = head;
        while (fast != null){
            fast = fast.next;
            if (fast != null && fast.next!=null){
                fast = fast.next;
                slow = slow.next;
            }
            else
                break;
        }
        ListNode reverse = reverse(slow.next);
        slow.next = reverse;
        while (reverse != null){
            if (head.val != reverse.val)
                return false;
            else {
                head = head.next;
                reverse = reverse.next;
            }
        }
        return true;

    }

    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        int[] test = {1,2};
        System.out.println(new Solution().isPalindrome(LinkedListHelper.generate(test)));
    }
}
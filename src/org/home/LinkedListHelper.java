package org.home;

/**
 * @Author: LiuChong
 * @Date: 2019-03-02 19:09
 * @Description:
 */
public class LinkedListHelper {

    private LinkedListHelper() {
    }

    public static ListNode generate(int[] arr){
        if (arr == null && arr.length == 0)
            return null;
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    public static void print(ListNode head){
        ListNode cur = head;
       while (cur != null){
           System.out.print(String.format("%d => ",cur.val));
           cur = cur.next;
       }
        System.out.print("null");
        System.out.println();
    }
}

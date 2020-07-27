package org.linfd.leetcode.topliked;

/**
 * #2 Add Two Nums
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 */

public class _2_AddTwoNums {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummyHead = new  ListNode(0);
        ListNode curr = dummyHead;
        while(l1 != null || l2 != null){
            int p = l1 == null ? 0 : l1.val;
            int q = l2 == null ? 0 : l2.val;

            int sum = p + q + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if(carry > 0){
            curr.next = new ListNode(carry);
        }

        return dummyHead.next;
    }

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }
}

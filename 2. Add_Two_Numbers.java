/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = rAdd(l1, l2, false);
        return head;
    }
    public ListNode rAdd(ListNode curr1, ListNode curr2, boolean carry) {
        if (curr1 == null && curr2 == null) {
            return (carry? new ListNode(1) : null);
        }
        if (curr1 == null) {
            curr1 = new ListNode(0);
        }
        if (curr2 == null) {
            curr2 = new ListNode(0);
        }
        int sum = curr1.val + curr2.val + (carry? 1 : 0);
        carry = (sum > 9);
        return new ListNode(sum % 10, rAdd(curr1.next, curr2.next, carry));
    }
}
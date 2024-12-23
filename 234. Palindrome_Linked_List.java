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
    public boolean isPalindrome(ListNode head) {
        List<Integer> items = new ArrayList<Integer>();
        ListNode cur = head;
        items.add(cur.val);
        while (cur.next != null) {
            cur = cur.next;
            items.add(cur.val);
        }
        int i = 0;
        int j = items.size() - 1;
        while (j > i) {
            if (items.get(i) == items.get(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;


        
    }
}
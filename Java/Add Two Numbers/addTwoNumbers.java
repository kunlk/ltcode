/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode dummy = res;
        int carry = 0;
        int sum = 0;

        while(l1 != null && l2 != null){
            if( (l1.val + l2.val + carry) / 10 == 1){
                sum = (l1.val + l2.val + carry) % 10;
                carry = 1;
            }else{
                sum = l1.val + l2.val + carry;
                carry = 0;
            }

            res.next = new ListNode(sum);
            res = res.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            if((l1.val + carry) / 10 == 1){
                sum = (l1.val + carry) % 10;      
                carry = 1;
            }else{
                sum = l1.val + carry;
                carry = 0;
            }
            res.next = new ListNode(sum);
            res = res.next;
            l1 = l1.next;
        }

        while(l2 != null){
            if((l2.val + carry) / 10 == 1){
                sum = (l2.val + carry) % 10;      
                carry = 1;
            }else{
                sum = l2.val + carry;
                carry = 0;
            }
            res.next = new ListNode(sum);
            res = res.next;
            l2 = l2.next;
        }

        if(carry == 1)
            res.next = new ListNode(carry);

        return dummy.next;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
	    
    	ListNode prev = null;
	ListNode curr = head;
		
	while(curr != null){
	    ListNode temp = curr.next;
	    curr.next = prev;
	    prev = curr;
	    curr = temp;
	}
	return curr;
    }

    //recursive
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        return helper(head,prev);
    }

    private ListNode helper(ListNode head, ListNode newHead) {
        if(head == null)
            return newHead;
        ListNode tmp = head.next;
        head.next = newHead;
        newHead = head;
        head = tmp;
        
        return helper(head,newHead);
        
    }
}

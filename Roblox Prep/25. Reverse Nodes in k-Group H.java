/*
25. Reverse Nodes in k-Group
Hard

Given the head of a linked list, reverse the nodes of the list k at a time, and return the 
modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the 
number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

Example 1:

Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:

Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
*/

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
//Video Link: https://www.youtube.com/watch?v=FYsYAELWyRs
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        int count =0;
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        ListNode temp = dummy;
        
        while(temp.next!=null){
            temp = temp.next;
            count++;
        }
        
        temp = dummy;
        while(temp.next!=null){
            if(count<k) break;
            int nodes = k-1;
            ListNode tempnext = temp.next;
            ListNode first = temp.next;
            ListNode second = first.next;
            
            while(nodes-- > 0){
                ListNode next = second.next;
                second.next = first;
                first = second;
                second = next;
            }
            count-=k;
            temp.next = first;
            tempnext.next = second;
            temp = tempnext;
            
        }
        return dummy.next;
    }
}
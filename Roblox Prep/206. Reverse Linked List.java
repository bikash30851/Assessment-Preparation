/*
206. Reverse Linked List

Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:

Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
Example 2:

Input: head = [1,2]
Output: [2,1]
Example 3:

Input: head = []
Output: []
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

 class Solution {
    public ListNode reverseList(ListNode head) {
        //1--2--3--4--5

        ListNode dummyHead = null; //dummy = null
        while(head != null){
            ListNode nodeToAttachBehind = head;  //nodeToAttachBehind = 1
            head = head.next; //head = 2
            nodeToAttachBehind.next = dummyHead; //1-->null
            dummyHead = nodeToAttachBehind; //dummy = 1 slide dummyHead Back.
                       
        }
        return dummyHead;
        
    }
}

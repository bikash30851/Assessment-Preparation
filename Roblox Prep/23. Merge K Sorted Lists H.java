/*
23. Merge k Sorted Lists
Hard

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
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
    public ListNode mergeKLists(ListNode[] lists) {
        
        //Runtime O(n*m log(n*m));
        //Space O(n*m)
        //where n = max # of lists and m = max number of nodes in a list.
        
        //By default, the priority queue in Java is min Priority queue 
        //with natural ordering
       //Back --> 18 14 10 10-->front
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(ListNode head: lists){
            while(head != null){
                minHeap.add(head.val);
                head = head.next;
            }
            
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;
        while(!minHeap.isEmpty()){
            curr.next = new ListNode(minHeap.remove());
            curr = curr.next;            
        }
        return dummyHead.next;
        
    }
}
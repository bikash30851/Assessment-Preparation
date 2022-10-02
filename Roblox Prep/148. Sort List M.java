/*
148. Sort List
Medium

Given the head of a linked list, return the list after sorting it in ascending order.

Example 1:

Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:

Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
Example 3:

Input: head = []
Output: []
 
Constraints:

The number of nodes in the list is in the range [0, 5 * 104].
-105 <= Node.val <= 105
*/

 
class Solution {
    public ListNode sortList(ListNode head) {
        // Men cut log short==merge sort = O(n log n)
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right); 
        
    }
    public static ListNode merge(ListNode list1, ListNode list2){
        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;
        
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                curr.next = list1;
                list1 = list1.next;
                 curr = curr.next;
            }
            else{
                curr.next = list2;
                list2 = list2.next;
                curr = curr.next;
            }
          
        }
        
        curr.next = (list1 != null) ? list1: list2;
        return dummyHead.next;   
    }
    
       
    
    ListNode getMid(ListNode head) {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }
}
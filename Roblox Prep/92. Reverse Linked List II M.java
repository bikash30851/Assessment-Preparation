/*
92. Reverse Linked List II
Medium

Given the head of a singly linked list and two integers left and right where left <= right,
reverse the nodes of the list from position left to position right, and return the reversed 
list.

Example 1:

Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
Example 2:

Input: head = [5], left = 1, right = 1
Output: [5]
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
    public ListNode reverseBetween(ListNode head, int m, int n) {

        //Approach II iterative Approach of the Leetcode solution.
        if (head == null) return null;

        // Move the two pointers until they reach the proper starting point
        // in the list.
        ListNode cur = head, prev = null;
        //m>1 and m-- n-- will put the pointers in the right spots
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }

        // The two pointers that will fix the final connections.
        ListNode con = prev, tail = cur;
        
        //Pointers are at the starting place to reverse and now we start reversing.

        // Iteratively reverse the nodes until n becomes 0.
        ListNode third = null;
        while (n > 0) {
            third = cur.next;
            
            //creating reversed connections.
            cur.next = prev;
            //actually shifting the nodes
            prev = cur;
            cur = third;
            
            //decreasing n for every shift made.
            n--;
        }

        // Adjust the final connections as explained in the algorithm

        //pickup the part to reverse and rotate and connect the ends.
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;

        //we check if it is safe to return head in the if else above.
        return head;
    }
}
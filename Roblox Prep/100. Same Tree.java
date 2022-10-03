/*
100. Same Tree
Easy

Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

Example 1:

Input: p = [1,2,3], q = [1,2,3]
Output: true
Example 2:

Input: p = [1,2], q = [1,null,2]
Output: false
Example 3:

Input: p = [1,2,1], q = [1,1,2]
Output: false
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        //true if both null-first condition.
        if(p == null && q == null) return true;
        
        //moves to second condition now if one is null it is false cz both
        //are not null as checked in first condition. 
        if(p == null || q == null) return false;        
        
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        
    }
}

//there is an iterative solution using deque on leetcode.
//I haven't been through this though
class Solution {
    public boolean check(TreeNode p, TreeNode q) {
      // p and q are null
      if (p == null && q == null) return true;
      // one of p and q is null
      if (q == null || p == null) return false;
      if (p.val != q.val) return false;
      return true;
    }
  
    public boolean isSameTree(TreeNode p, TreeNode q) {
      if (p == null && q == null) return true;
      if (!check(p, q)) return false;
  
      // init deques
      ArrayDeque<TreeNode> deqP = new ArrayDeque<TreeNode>();
      ArrayDeque<TreeNode> deqQ = new ArrayDeque<TreeNode>();
      deqP.addLast(p);
      deqQ.addLast(q);
  
      while (!deqP.isEmpty()) {
        p = deqP.removeFirst();
        q = deqQ.removeFirst();
  
        if (!check(p, q)) return false;
        if (p != null) {
          // in Java nulls are not allowed in Deque
          if (!check(p.left, q.left)) return false;
          if (p.left != null) {
            deqP.addLast(p.left);
            deqQ.addLast(q.left);
          }
          if (!check(p.right, q.right)) return false;
          if (p.right != null) {
            deqP.addLast(p.right);
            deqQ.addLast(q.right);
          }
        }
      }
      return true;
    }
  }
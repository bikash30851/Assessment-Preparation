/*
687. Longest Univalue Path
Medium

Given the root of a binary tree, return the length of the longest path, where each node in the path has the same value. This path may or may not pass through the root.

The length of the path between two nodes is represented by the number of edges between them.

Example 1:

Input: root = [5,4,5,1,1,null,5]
Output: 2
Explanation: The shown image shows that the longest path of the same value (i.e. 5).
Example 2:

Input: root = [1,4,5,4,4,null,5]
Output: 2
Explanation: The shown image shows that the longest path of the same value (i.e. 4).
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
    public int longestUnivaluePath(TreeNode root) {
           int[] result = new int[1];
           if (root != null) {
               dfs(root, result);
           }
           return result[0];
       }

       // calculate longest univalue path from root to leaves
       // In addition, the maximum univalue path cross the root node is calculated and then global maximum is udpated.
       private int dfs(TreeNode root, int[] result) {
           int leftPath = root.left == null ? 0 : dfs(root.left, result);
           int rightPath = root.right == null ? 0 : dfs(root.right, result);
           int leftResult = (root.left != null && root.left.val == root.val) ? leftPath + 1 : 0;
           int rightResult = (root.right != null && root.right.val == root.val) ? rightPath + 1 : 0;
           result[0] = Math.max(result[0], leftResult + rightResult);
           return Math.max(leftResult, rightResult);
       }
   }

//fisher

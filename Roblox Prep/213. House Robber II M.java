/*
213. House Robber II
Medium

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
Example 2:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 3:

Input: nums = [1,2,3]
Output: 3
*/

class Solution {
    public int rob(int[] nums) {
        
        /**
         * This solution is identical to the above solution 1, the only difference is that instead of using an extra array, we use only two extra variables here to reduce the space complexity to O(1).
         * Time: O(n)
         * Space: O(1)
         * <p>
         * Just draw out how this rotation works on a piece of paper, it'll be easy to figure out how first, second and tmp variables keep shifting towards the right of the array.
         */
            if (nums.length == 1) {
                return nums[0];
            }
            return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
        }

        private int rob(int[] nums, int start, int end) {
            int first = nums[start];
            if (end - start <= 1) {
                return first;
            }
            int second = Math.max(nums[start], nums[start + 1]);
            int tmp;
            for (int i = start + 2; i < end; i++) {
                tmp = Math.max(second, first + nums[i]);
                first = second;
                second = tmp;
            }
            return Math.max(first, second);
     
        
    }
}
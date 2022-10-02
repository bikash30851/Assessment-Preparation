/*905. Sort Array By Parity
Given an integer array nums, move all the even integers at the beginning of the 
array followed by all the odd integers.

Return any array that satisfies this condition.

Example 1:

Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
Example 2:

Input: nums = [0]
Output: [0]
*/

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int[] output = new int[nums.length];
        
        //two pointers even pointing to the front and odd pointing to the back
        int even = 0;
        int odd = nums.length -1;

        for(int i = 0; i<nums.length; i++){
            //if even start adding from front and incerase index.
            if(nums[i]%2 == 0) {
                output[even++] = nums[i];
            }
            //if odd start adding from the back.
            else{
                output[odd--] = nums[i];
            }
           
        }
       return output; 
    }
}
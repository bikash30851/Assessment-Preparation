/*
645. Set Mismatch

You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.

You are given an integer array nums representing the data status of this set after the error.

Find the number that occurs twice and the number that is missing and return them in the form of an array.
*/

class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i + 1] == nums[i]) {
                    result[0] = nums[i];
                }
            }
            long temp = 0;
            for (int i = 0; i < nums.length; i++) {
                temp += i + 1;
                temp -= nums[i];
            }
            temp += result[0];
            result[1] = (int) temp;
            return result;
        
    }
}
/*
Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.

 

Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
*/

class Solution {
    public void reverseString(char[] s) {
        //iterate upto the half and swap front and back using temp.
        int hlen = s.length/2;
        int rlen = s.length;
        for(int i = 0; i<hlen; i++){
            char temp = s[i];
            s[i] = s[rlen-i-1];
            s[rlen-i-1] = temp;
        }
                        
    }
}
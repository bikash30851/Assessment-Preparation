/*
14. Longest Common Prefix
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        //set longest prefix as the first one.
        String output = strs[0];

        //loop through the array of strings and shorten the first one until 
        //it is found in the other ones i.e indexOf != 0
        for(int i = 1; i<strs.length; i++){
            while(strs[i].indexOf(output) != 0){
                output = output.substring(0, output.length()-1);
            }            
        }
       return output;
       
    }
}
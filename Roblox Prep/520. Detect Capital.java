/*
520. Detect Capital

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Given a string word, return true if the usage of capitals in it is right.

Example 1:

Input: word = "USA"
Output: true
Example 2:

Input: word = "FlaG"
Output: false
*/

class Solution {
    public boolean detectCapitalUse(String word) {
        //if first is capital,rest must be capital-CASE I
        //if first is capital rest must be small or the whole thing must be small CASE II
        //else casse //First letter doesn't matter rest must be smaller 

        int n = word.length();
        if (n == 1) {
            return true;
        }

        // case 1: All capital
        if (Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            for (int i = 2; i < n; i++) {
                if (Character.isLowerCase(word.charAt(i))) {
                    return false;
                }
            }
        //First letter doesn't matter rest must be smaller 
        } 
        else {
            for (int i = 1; i < n; i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
        }

        // if pass one of the cases
        return true;
    }
}
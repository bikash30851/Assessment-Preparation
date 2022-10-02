/*
856. Score of Parentheses
Medium

Given a balanced parentheses string s, return the score of the string.

The score of a balanced parentheses string is based on the following rule:

"()" has score 1.
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.

Example 1:

Input: s = "()"
Output: 1
Example 2:

Input: s = "(())"
Output: 2
Example 3:

Input: s = "()()"
Output: 2
*/

class Solution {
    public int scoreOfParentheses(String s) {
        //another solution using stack but less intuitive
    
    int score = 0;
    int depth = 0;
        
    for(int i = 0; i<s.length(); i++){
        if(s.charAt(i) == '('){
            depth++;
        }
        else{
            depth--;
        }
        if(s.charAt(i) == ')' && s.charAt(i-1) == '('){
            //Meat of the solution.
            score += Math.pow(2, depth);
        }    
    }
        return score;
    }
}

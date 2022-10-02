/*125. Valid Palindrome

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
and removing all non-alphanumeric characters, it reads the same forward and backward.
 Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
*/

//Character.isLetterOrDigit('');
//Character.isLowerCase('');

class Solution {
    public boolean isPalindrome(String s) {
        //using two pointers from front and the back.
        int i = 0;
        int j = s.length()-1;
        char[] c = s.toCharArray();
        //while front pointer is less then the back pointer.
        while(i<j){
            //increase front pointer when the character is not a letter or a digit.
            while(i<j && !Character.isLetterOrDigit(c[i])){
                i++;
            }
            //decrease back pointer when the character is not a letter or a digit.
            while(i<j && !Character.isLetterOrDigit(c[j])){
                j--;
            }
            //when they are both a letter or a digit check if they are the same LOWERCASE.
            if(Character.toLowerCase(c[i]) != Character.toLowerCase(c[j])){
                return false;
            }
            //update both the pointers.
            i++;
            j--;  
        }
        return true;
    }
}
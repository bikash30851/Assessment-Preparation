/*
345. Reverse Vowels of a String

Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

Example 1:

Input: s = "hello"
Output: "holle"
Example 2:

Input: s = "leetcode"
Output: "leotcede"
*/

class Solution {
    public String reverseVowels(String s) {
        //two pointer front and back
        //if front pointer not vowel move up
        //if back pointer not vowel move down
        //until they cross each other.
        //when both pointer vowel swap
        //need a temp variable to hold swap
        int i = 0;
        int j = s.length()-1;
        char[] c = s.toCharArray();
        while(i<j){
            while(i<j && !isVowel(c[i])){
                i++;
            }
            while(i<j && !isVowel(c[j])){
                j--;
            }
            if(isVowel(c[i]) && isVowel(c[j])){
                char temp = c[i];
                c[i] = c[j];
                c[j] = temp;
            }
            i++;
            j--;
            
        }
       
        return String.valueOf(c);      
        
    }
    
    //isVowel helper function to check vowels
    public static boolean isVowel(char c){
        if ( c == 'a' ||  c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' ||  c == 'E' || c == 'I' || c == 'O' || c == 'U') return true;
        return false;
    }
}


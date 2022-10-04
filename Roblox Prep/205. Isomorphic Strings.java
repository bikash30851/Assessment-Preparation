import java.util.HashMap;
import java.util.Map;

/*
205. Isomorphic Strings

Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
*/

class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        if(s.length() != t.length()) return false;
        
        Map<Character, Character> map= new HashMap<>();
        int i = 0;
        for(char c: s.toCharArray()){
            if(map.containsKey(c)){
                if(!(map.get(c).equals(t.charAt(i)))) return false;
            }
            else{
                if(map.containsValue(t.charAt(i))) return false;
            }
            map.put(c, t.charAt(i));
            
            i++;
        }
        return true; 
        
    }
}
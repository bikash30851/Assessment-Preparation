import java.util.HashMap;

/*
290. Word Pattern

Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

Example 1:

Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Example 2:

Input: pattern = "abba", s = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false
*/

class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        String[] sarr = s.split(" ");
        char[] carr = pattern.toCharArray();
        
        if(sarr.length != carr.length) return false;
        
        HashMap<Character, String> map = new HashMap<>();
        
        int idx = 0;
        for(char c: carr){
            if(map.containsKey(c)){
                //if there exists a mapping, word must be same as the mapping to the char,  
                //else false
                if(!(map.get(c).equals(sarr[idx]))) return false;
            }
            else{
                //not bijective meaning 2 same values for different keys. NOT UNIQUE
                if(map.containsValue(sarr[idx])){
                    return false;
                }
                map.put(c, sarr[idx]);              
            }
            idx++;
        }
        return true;
        
    }
}
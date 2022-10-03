import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
3. Longest Substring Without Repeating Characters

Given a string s, find the length of the longest substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //keep removing from the left when character present in right.
        //add only after the character has been removed, therefore a while loop.
        Set<Character> set = new HashSet<>();
        int begin = 0, end= 0;
        int result = 0;
        while(end<s.length()){
        //Not if but a while loop..need to remove from left until the character is present
            //in the set since the count is already updated in result Math.max below.
          while(set.contains(s.charAt(end))){
              set.remove(s.charAt(begin));   
              begin++;
          }
          set.add(s.charAt(end));
          result = Math.max(result, end-begin+1);
          end++;
      }
        return result;

    }
}


//sliding window algorithm
public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int begin = 0, end = 0, counter = 0, d = 0;

        while (end < s.length()) {
            // > 0 means repeating character
            //if(map[s.charAt(end++)]-- > 0) counter++;
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.get(c) > 1) counter++;
            end++;
            
            while (counter > 0) {
                //if (map[s.charAt(begin++)]-- > 1) counter--;
                char charTemp = s.charAt(begin);
                if (map.get(charTemp) > 1) counter--;
                map.put(charTemp, map.get(charTemp)-1);
                begin++;
            }
            d = Math.max(d, end - begin);
        }
        return d;
    }
}
	
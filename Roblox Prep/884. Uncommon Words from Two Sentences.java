import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
884. Uncommon Words from Two Sentences

A sentence is a string of single-space separated words where each word consists only of lowercase letters.

A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.

Given two sentences s1 and s2, return a list of all the uncommon words. You may return the answer in any order.

Example 1:

Input: s1 = "this apple is sweet", s2 = "this apple is sour"
Output: ["sweet","sour"]
Example 2:

Input: s1 = "apple apple", s2 = "banana"
Output: ["banana"]
*/

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        //the uncommon word appears only once .
        String f = s1+" " + s2;
        String[] c = f.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String word: c){
          map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        List<String> list1 = new ArrayList<>();
        for(String word: map.keySet()){
            if(map.get(word) == 1){
                list1.add(word);
            }
        }
                return list1.toArray(new String[list1.size()]);
        
    }
}
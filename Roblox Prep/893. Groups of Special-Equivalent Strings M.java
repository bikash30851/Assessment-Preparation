import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
893. Groups of Special-Equivalent Strings
Medium

You are given an array of strings of the same length words.

In one move, you can swap any two even indexed characters or any two odd indexed characters of a string words[i].

Two strings words[i] and words[j] are special-equivalent if after any number of moves, words[i] == words[j].

For example, words[i] = "zzxy" and words[j] = "xyzz" are special-equivalent because we may make the moves "zzxy" -> "xzzy" -> "xyzz".
A group of special-equivalent strings from words is a non-empty subset of words such that:

Every pair of strings in the group are special equivalent, and
The group is the largest size possible (i.e., there is not a string words[i] not in the group such that words[i] is special-equivalent to every string in the group).
Return the number of groups of special-equivalent strings from words.

Example 1:

Input: words = ["abcd","cdab","cbad","xyzz","zzxy","zzyx"]
Output: 3
Explanation: 
One group is ["abcd", "cdab", "cbad"], since they are all pairwise special equivalent, and none of the other strings is all pairwise special equivalent to these.
The other two groups are ["xyzz", "zzxy"] and ["zzyx"].
Note that in particular, "zzxy" is not special equivalent to "zzyx".
Example 2:

Input: words = ["abc","acb","bac","bca","cab","cba"]
Output: 3
*/

class Solution {
    public int numSpecialEquivGroups(String[] A) {
        
         Set<String> set = new HashSet<>();
        
        //outer loop to go through words in the array
            for (String str : A) {
                int[] odd = new int[26];
                int[] even = new int[26];
                //inner for loop iterating through all the characters.
                for (int i = 0; i < str.length(); i++) {
                    //checking if index is odd or even
                    if (i % 2 == 0) {
                        even[str.charAt(i) - 'a']++;
                    } else {
                        odd[str.charAt(i) - 'a']++;
                    }
                }
                String key = Arrays.toString(even) + Arrays.toString(odd);
                set.add(key);
            }
            return set.size();
        
    }
}
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 819. Most Common Word
Easy

1391

2737

Add to List

Share
Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned. It is guaranteed there is at least one word that is not banned, and that the answer is unique.

The words in paragraph are case-insensitive and the answer should be returned in lowercase.

Example 1:

Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
Output: "ball"
Explanation: 
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"), 
and that "hit" isn't the answer even though it occurs more because it is banned.
Example 2:

Input: paragraph = "a.", banned = []
Output: "a"
 */

 //go through again
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {

        // 1). replace the punctuations with spaces,
        // and put all letters in lower case
        String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();

        // 2). split the string into words
        //+ for 1 or more
        String[] words = normalizedStr.split("\\s+"); 

        Set<String> bannedWords = new HashSet<>();
        for (String word : banned)
            bannedWords.add(word);

        Map<String, Integer> wordCount = new HashMap();
        // 3). count the appearance of each word, excluding the banned words
        for (String word : words) {
            if (!bannedWords.contains(word))
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // 4). return the word with the highest frequency
        return Collections.max(wordCount.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
/*
771. Jewels and Stones

You're given strings jewels representing the types of stones that are jewels, and stones 
representing the stones you have. Each character in stones is a type of stone you have. 
You want to know how many of the stones you have are also jewels.

Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:

Input: jewels = "aA", stones = "aAAbbbb"
Output: 3
Example 2:

Input: jewels = "z", stones = "ZZ"
Output: 0
*/

class Solution {
    public int numJewelsInStones(String jewels, String stones) {

        //make map with value 1 for char in jewels.
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: jewels.toCharArray()){
            map.put(c, 1);
        }
        int sum = 0;

        //check it in the stones.
        for(char c: stones.toCharArray()){
            if(map.containsKey(c)){
                sum+=map.get(c);
            }
        }
        return sum;
        
    }
}
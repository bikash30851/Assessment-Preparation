import java.util.Arrays;
import java.util.HashSet;

/*
349. Intersection of Two Arrays

Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
*/
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
       //converting arrays to set
      HashSet<Integer> set1 = new HashSet<Integer>();
      for (Integer n : nums1) set1.add(n);
        
      HashSet<Integer> set2 = new HashSet<Integer>();
      for (Integer n : nums2) set2.add(n);
  
      if (set1.size() < set2.size()) return set_intersection(set1, set2);
        
      else return set_intersection(set2, set1);
        
    }
      
      public int[] set_intersection(HashSet<Integer> set1,  HashSet<Integer> set2) {
          
      int [] output = new int[set1.size()];
      int idx = 0;
      for (Integer s : set1)
        if (set2.contains(s)) output[idx++] = s;
  
      return Arrays.copyOf(output, idx);
          //Arrays.copy of takes the length here idx is the length of the final array.
    }
  }
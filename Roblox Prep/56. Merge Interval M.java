import java.util.Arrays;
import java.util.LinkedList;

/*
56. Merge Intervals
Medium

Given an array of intervals where intervals[i] = [starti, endi], merge all 
overlapping intervals, and return an array of the non-overlapping intervals
that cover all the intervals in the input.

 
Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
*/

class Solution {
    public int[][] merge(int[][] intervals) {
        //Sort intervals according to the first element.
        //create a linkedlist
        //if list is empty add interval
        //if list has element, compare last of last and first of new
            //if last's last is smaller than new ones first, add it 
            //in the list as it is 
            //else, maximum of last's last and new's last since they overlap
            //and we need to merge.
        //output is supposed to be an array 
        //so return merged.toArray(new int[merged.size()][])
        
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        LinkedList<int[]> merged = new LinkedList<>();
        
        for(int[] interval: intervals){
                if(merged.isEmpty() || merged.getLast()[1] < interval[0]){
                    merged.add(interval);
                }    
                else {
                    merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
                }
        }
        return merged.toArray(new int[merged.size()][]);
        
    }
}


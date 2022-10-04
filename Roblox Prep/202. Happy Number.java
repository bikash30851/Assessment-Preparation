import java.util.HashSet;
import java.util.Set;

/*
202. Happy Number

Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

Example 1:

Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
Example 2:

Input: n = 2
Output: false
*/

class Solution {
    public boolean isHappy(int n) {
        //HashSet To detect cycle in the sums of digits. repeated numbers.
        Set<Integer> seen = new HashSet<>();
        while(n != 1){
            int current = n;
            int sum = 0;
            while(current != 0){//while we haven't gone through all the digits
                sum += (current%10)*(current % 10); //multiplying the last digit
                current /= 10;
            }
            if (seen.contains(sum)) return false; //meaning cycle/loop
            seen.add(sum);
            n = sum;
            
        }
        return true;
        
    }
}

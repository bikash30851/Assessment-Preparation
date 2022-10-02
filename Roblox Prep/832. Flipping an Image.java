/*
832. Flipping an Image

Given an n x n binary matrix image, flip the image horizontally, then invert it,
and return the resulting image.

To flip an image horizontally means that each row of the image is reversed.

For example, flipping [1,1,0] horizontally results in [0,1,1].
To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.

For example, inverting [0,1,1] results in [1,0,0].
 

Example 1:

Input: image = [[1,1,0],[1,0,1],[0,0,0]]
Output: [[1,0,0],[0,1,0],[1,1,1]]
Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
Example 2:

Input: image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
*/

/*
We can do this in place. In each row, the ith value from the left is equal to the inverse
of the ith value from the right.

We use (C+1) / 2 (with floor division) to iterate over all indexes i in the first half of
the row, including the center. */

class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int C = A[0].length;
         //bitwise operator ^ or XOR 
        // 0^1 = 1
        //1^1 = 0
        //0^0 = 0

        //one or the other true = true but not both true, both true = false
        for (int[] row: A)
            //iterating only to the half including the half.
            for (int i = 0; i < (C + 1) / 2; i++) {
                int tmp = row[i] ^ 1;
                //but swapping inverse from first with the inverse from last in each row.
                row[i] = row[C - 1 - i] ^ 1;
                row[C - 1 - i] = tmp;
            }

        return A;
    }
}
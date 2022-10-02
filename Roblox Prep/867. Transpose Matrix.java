/*
867. Transpose Matrix

Given a 2D integer array matrix, return the transpose of matrix.

The transpose of a matrix is the matrix flipped over its main diagonal,
switching the matrix's row and column indices.

Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[1,4,7],[2,5,8],[3,6,9]]
Example 2:

Input: matrix = [[1,2,3],[4,5,6]]
Output: [[1,4],[2,5],[3,6]]
*/

class Solution {
    public int[][] transpose(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        //new matrix with flipped dimensions.
        int[][] ans = new int[c][r];
        
        for(int i = 0; i<matrix.length; i++){
            for(int j =0; j<matrix[i].length; j++){
                //ji of new matrix == ij of old one for transposing(column = row)
                ans[j][i] = matrix[i][j];
            }
        }
        return ans;
        
    }
}

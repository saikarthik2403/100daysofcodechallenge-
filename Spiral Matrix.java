//Spiral Matrix
//https://leetcode.com/problems/spiral-matrix/
/*
Given an m x n matrix, return all elements of the matrix in spiral order.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
*/



class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int count = 0;
        int total = row * col;
        int startingRow = 0;
        int startingCol = 0;
        int endingRow = row - 1;
        int endingCol = col - 1;
        while (count < total) {
            for (int index = startingCol; count < total && index <= endingCol; index++) {
                ans.add(matrix[startingRow][index]);
                count++;
            }
            startingRow++;
            for (int index = startingRow; count < total && index <= endingRow; index++) {
                ans.add(matrix[index][endingCol]);
                count++;
            }
            endingCol--;
            for (int index = endingCol; count < total && index >= startingCol; index--) {
                ans.add(matrix[endingRow][index]);
                count++;
            }
            endingRow--;
            for (int index = endingRow; count < total && index >= startingRow; index--) {
                ans.add(matrix[index][startingCol]);
                count++;
            }
            startingCol++;
        }
        return ans;
    }
}






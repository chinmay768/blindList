public class SetZeroMatrix {
    public void setZeroes(int[][] matrix) {
        int[] markRow = new int[matrix.length];
        int[] markCol = new int[matrix[0].length];

        for (int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[0].length; col++) {
                if(matrix[row][col] == 0){
                    markRow[row] = 1;
                    markCol[col] = 1;
                }
            }
        }

        for (int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[0].length; col++) {
                if(markRow[row] == 1 || markCol[col] == 1){
                    matrix[row][col] = 0;
                }
            }
        }
    }


    public void setZeroesOptimal(int[][] matrix) {
        int firstCol = 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;

                    if(j != 0) matrix[0][j] = 0;
                    else firstCol = 0;
                }
            }
        }


        for (int i = 1; i < matrix.length; i++){
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(matrix[0][0] == 0) {
            for (int j = 0; j< matrix[0].length; j++){
                matrix[0][j] = 0;
            }
        }

        if (firstCol == 0) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}

/*
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.



Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]


Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1
 */


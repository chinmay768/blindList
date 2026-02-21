public class RotateImage_48 {


    public void rotateNaive(int[][] matrix) {
        int[][] rotatedMatrix = new int[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                rotatedMatrix[j][matrix.length - i - 1] = matrix[i][j];
            }
        }

        for (int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                matrix[i][j] = rotatedMatrix[i][j];
            }
        }
    }

    public static void rotate(int[][] matrix) {
        //Transpose
        int n = matrix.length;
        for(int i = 1; i < n; i++) {
            for (int j = 0; j <= i - 1; j++){
                swap(matrix, i, j, j, i);
            }
        }

        //Reversse
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n / 2; j++){
                swap(matrix, i, j, i, n - 1 - j);
            }
        }
    }

    public static void swap(int[][] matrix, int i1, int j1, int i2, int j2){
        int temp = matrix[i1][j1];

        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = temp;
    }


    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);

        int n = matrix.length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}

/*
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.



Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
Example 2:


Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 */

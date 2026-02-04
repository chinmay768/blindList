import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_54 {

    public static List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        List<Integer> res = new ArrayList<>();

        while (top <= bottom && left <= right){
            for (int i = left; i <= right; i++){
                res.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++){
                res.add(matrix[i][right]);
            }
            right--;

            if(top <= bottom){
                for (int i = right; i >= left; i--){
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if(left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{7},{9},{6}};

        System.out.println(spiralOrder(matrix));
    }
}

7
9
6
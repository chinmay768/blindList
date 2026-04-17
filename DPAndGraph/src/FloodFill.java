public class FloodFill {

    public static void dfs(int[][] image, int i, int j, int startingCol, int targetCol) {
        if(image[i][j] == startingCol) image[i][j] = targetCol;
        else return;

        int[] delX = {-1, 0, 1, 0};
        int[] delY = {0, 1, 0, 1};

        for (int k = 0; k < 4; k++) {
            int adjrow = i + delX[k];
            int adjCol = j + delY[k];
            if(isValid(image, adjrow, adjCol)){
                dfs(image, adjrow, adjCol, startingCol, targetCol);
            }
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;
        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }

    public static boolean isValid(int[][] image, int i, int j) {
        int n = image.length;
        int m = image[0].length;
        return !(i < 0 || i >= n || j < 0 || j >= m);
    }

    public static void main(String[] args) {

    }
}

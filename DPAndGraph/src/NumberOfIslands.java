import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    static class Pair {
        int row;
        int col;

        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public static void bfs(int i, int j, int[][] vis, char[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(i, j));
        vis[i][j] = 1;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int row = curr.row;
            int col = curr.col;

            for (int k = 0; k < 4; k++) {
                int adjRow = row + dr[k];
                int adjCol = col + dc[k];

                if(isValidIdx(adjRow, adjCol, grid) && vis[adjRow][adjCol] != 1 && grid[adjRow][adjCol] == '1'){
                    vis[adjRow][adjCol] = 1;
                    q.offer(new Pair(adjRow, adjCol));
                }
            }
        }
    }

    public static int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];

        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == '1' && vis[i][j] != 1){
                    bfs(i, j, vis, grid);
                    res++;
                }
            }
        }

        return res;
    }

    private static boolean isValidIdx(int i, int j, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if(i >= 0 && i < n && j >= 0 && j < m){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

    }
}

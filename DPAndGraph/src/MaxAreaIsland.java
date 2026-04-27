import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaIsland {

    private static class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(visited[i][j] != 1 && grid[i][j] == 1) {
//                    maxArea = Math.max(maxArea, dfs(grid, i, j, visited));
                    maxArea = Math.max(maxArea, bfs(grid, i, j, visited));
                }
            }
        }
        return maxArea;
    }

    public static int dfs(int[][] grid, int i, int j, int[][] visited) {
        if(grid[i][j] == 0 || visited[i][j] == 1) return 0;

        visited[i][j] = 1;

        int[] dX = {-1, 0, 1, 0};
        int[] dY = {0, 1, 0, -1};

        int area = 0;

        for (int k = 0; k < 4; k++) {
            int newX = i + dX[k];
            int newY = j + dY[k];

            if(newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length) {
                continue;
            }

            area += dfs(grid, newX, newY, visited);
        }

        return 1 + area;
    }

    public static int bfs(int[][] grid, int i, int j, int[][] visited) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(i, j));
        visited[i][j]  = 1;
        int area = 0;

        while (!q.isEmpty()) {
            Pair currPair = q.poll();
            area++;

            int[] dX = {-1, 0, 1, 0};
            int[] dY = {0, 1, 0, -1};

            for (int k = 0; k < 4; k++) {
                int newX = currPair.i + dX[k];
                int newY = currPair.j + dY[k];

                if(newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length || grid[newX][newY] == 0 || visited[newX][newY] == 1) {
                    continue;
                }

                q.offer(new Pair(newX, newY));
                visited[newX][newY] = 1;
            }
        }

        return area;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };


        System.out.println(maxAreaOfIsland(grid));
    }
}

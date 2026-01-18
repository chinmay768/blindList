import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands_200 {

    private class Pair {
        int i;
        int j;
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public void bfs(int i, int j, int[][] visited, char[][] grid) {
        visited[i][j] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(i, j));

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

       while (!q.isEmpty()) {
           Pair curr = q.poll();

           for (int k = 0; k < 4; k++) {
               int adjRow = curr.i + dr[k];
               int adjCol = curr.j + dc[k];

               if(isValid(grid, adjRow, adjCol) && visited[adjRow][adjCol] != 1 && grid[adjRow][adjCol] == '1'){
                   visited[adjRow][adjCol] = 1;
                   q.offer(new Pair(adjRow, adjCol));
               }
           }
       }
    }

    private boolean isValid(char[][] grid, int adjRow, int adjCol){
        return adjRow >= 0 && adjRow < grid.length && adjCol >= 0 && adjCol < grid[0].length;
    }

    public int numIslands(char[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int islandsCnt = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(visited[i][j] != 1 && grid[i][j] == '1'){
                    bfs(i, j, visited, grid);
                    islandsCnt++;
                }
            }
        }

        return islandsCnt;
    }

    public static void main(String[] args) {

    }
}













/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.



Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
 */

import java.util.Arrays;

public class UniquePaths_62 {

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++){
            Arrays.fill(dp[i], -1);
        }

//        return uniquePathsRecursive(0, 0, m, n);
        return uniquePathsDP(0, 0, m, n, dp);
    }

    //TC: 2^(m*n)
    //SC: O(path len)
    public static int uniquePathsRecursive(int i, int j, int m, int n) {
        if(i < 0 || i >= m || j < 0 || j >= n) return 0; // Invalid Cases

        if(i == m - 1 && j == n - 1) { // Base case
            return 1;
        }

        int count = 0;
        count += uniquePathsRecursive(i, j + 1, m, n);

        count += uniquePathsRecursive(i + 1, j, m, n);

        return count;
    }

    public static int uniquePathsDP(int i, int j, int m, int n, int[][] dp) {
        if(i < 0 || i >= m || j < 0 || j >= n) return 0; // Invalid Cases

        if(i == m - 1 && j == n - 1) { // Base case
            return 1;
        }

        if(dp[i][j] != -1) return dp[i][j];

        int count = 0;
        count += uniquePathsDP(i, j + 1, m, n, dp);

        count += uniquePathsDP(i + 1, j, m, n, dp);

        return dp[i][j] = count;
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 2;

        System.out.println(uniquePaths(m, n));
    }
}

/*
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.



Example 1:


Input: m = 3, n = 7
Output: 28
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
 */
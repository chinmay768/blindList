import java.util.Arrays;

public class PerfectSquares {

    public static int numSquaresRec(int n) {
        if(n == 0) return 0;

        int minCount = Integer.MAX_VALUE;

        for (int i = 1; i * i <= n; i++){
            minCount = Math.min(minCount, 1 + numSquaresRec(n - (i * i)));
        }

        return minCount;
    }

    public static int numSquaresDP(int n, int[] dp) {
        if(n == 0) return 0;

        if(dp[n] != -1) return dp[n];
        int minCount = Integer.MAX_VALUE;

        for (int i = 1; i * i <= n; i++){
            minCount = Math.min(minCount, 1 + numSquaresRec(n - (i * i)));
        }

        return dp[n] = minCount;
    }

    public static int numSquaresTabulation(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // Base Case


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++){
                dp[i] = Math.min(dp[i], 1 + dp[i - (j * j)]);
            }
        }

        return dp[n];
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
//        return numSquaresRec(n);
        return numSquaresDP(n, dp);
    }

    public static void main(String[] args) {

    }
}

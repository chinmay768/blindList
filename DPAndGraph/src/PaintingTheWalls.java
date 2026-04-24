import java.util.Arrays;

public class PaintingTheWalls {

    public static int paintWalls(int[] cost, int[] time) {
        int[][] dp = new int[time.length][time.length + 1];

        for (int i = 0; i< dp.length; i++){
            Arrays.fill(dp[i], -1);
        }

        return paintWallsRecDP(cost, time, 0, cost.length, dp);
    }

    public static int paintWallsRec(int[] cost, int[] time, int i, int remaining) {

        if(remaining <= 0) return 0;

        if(i == cost.length) return 1_000_000_000;

        // Take
        int take = cost[i] + paintWallsRec(cost, time, i + 1, remaining - 1 - time[i]);

        // Not Take
        int skip = paintWallsRec(cost, time, i + 1, remaining);

        return Math.min(take, skip);
    }

    public static int paintWallsRecDP(int[] cost, int[] time, int i, int remaining, int[][] dp) {
        if(remaining <= 0) return 0;

        if(i == cost.length) return 1_000_000_000;

        if(dp[i][remaining] != -1) return dp[i][remaining];

        // Take
        int take = cost[i] + paintWallsRecDP(cost, time, i + 1, remaining - 1 - time[i], dp);

        // Not Take
        int skip = paintWallsRecDP(cost, time, i + 1, remaining, dp);

        return dp[i][remaining] =  Math.min(take, skip);
    }

    public static void main(String[] args) {
        int[] cost = {1,2,3,2};
        int[] time = {1,2,3,2};

        System.out.println( paintWalls(cost, time));
    }
}

import java.util.Arrays;

public class CoinChange_322 {


    public static int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i], 0);
        }
//        return coinChangeRecursion(coins, amount, coins.length - 1);
        return coinChangeRecursionDp(coins, amount, coins.length - 1, dp);
    }

    //TC: O(2^n)
    public static int coinChangeRecursion(int[] coins, int amount, int idx) {
        if(idx == 0){
            if(amount % coins[idx] == 0) return amount / coins[idx];
            return (int)1e9;
        }

        int notTake = coinChangeRecursion(coins, amount, idx - 1);
        int take = Integer.MAX_VALUE;
        if(coins[idx] <= amount) take = 1 + coinChangeRecursion(coins, amount - coins[idx], idx);

        return Math.min(take, notTake);
    }

    //TC: O(n * k)  O(n * k)  k = amt
    public static int coinChangeRecursionDp(int[] coins, int amount, int idx, int[][] dp) {
        if(idx == 0){
            if(amount % coins[idx] == 0) return amount / coins[idx];
            return (int)1e9; // Don't use Integer.MAX_VALUE because +1 will result in -ve and will fail in math.min
        }

        if(dp[idx][amount] != -1) return dp[idx][amount];

        int notTake = coinChangeRecursionDp(coins, amount, idx - 1, dp);
        int take = Integer.MAX_VALUE;
        if(coins[idx] <= amount) take = 1 + coinChangeRecursionDp(coins, amount - coins[idx], idx, dp);

        return dp[idx][amount] = Math.min(take, notTake);
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;

        System.out.println(coinChange(coins, amount));
    }
}

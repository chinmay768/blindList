import java.util.Arrays;

public class ClimbingStairs_70 {

    public static int climbStairsRecursion(int n) {
        if(n < 0) return 0;
        if(n == 0) return 1;

        //Take steps
        int oneStep = climbStairsRecursion(n - 1);
        int twoSteps = climbStairsRecursion(n - 2);

        return oneStep + twoSteps;
    }

    public static int climbStairs(int n){
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return climbStairsRecursionDP(n, dp);
    }

    //TC: O(n)  SC: O(n)
    public static int climbStairsRecursionDP(int n, int[] dp) {
        if(n < 0) return 0;
        if(n == 0) return 1;

        if(dp[n] != -1) return dp[n];

        //Take steps
        int oneStep = climbStairsRecursion(n - 1);
        int twoSteps = climbStairsRecursion(n - 2);

        return dp[n] = oneStep + twoSteps;
    }

    //TC: O(n)   SC: O(1)
    public static int climbStairsRecursionTabulation(int n) {
        if(n <= 1) return 1;

        int prev2 = 1;
        int prev1 = 1;

        for(int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }


    public static void main(String[] args) {
        System.out.println(climbStairsRecursionTabulation(3));
    }
}

/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?



Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 */
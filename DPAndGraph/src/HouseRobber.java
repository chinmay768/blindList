import java.lang.reflect.Array;
import java.util.Arrays;

public class HouseRobber {

    public static int houseRobberRecursion(int i, int[] nums){
        if(i == 0) {
            return nums[i];
        }

        if(i < 0) return 0;

        int take = nums[i] + houseRobberRecursion(i - 2, nums);

        int notTake = houseRobberRecursion(i - 1, nums);

        return Math.max(take, notTake);
    }

    public static int houseRobberDP(int i, int[] nums, int[] dp){
        if(i == 0) {
            return nums[i];
        }

        if(i < 0) return 0;

        if(dp[i] != -1) return dp[i];

        int take = nums[i] + houseRobberDP(i - 2, nums, dp);

        int notTake = houseRobberDP(i - 1, nums, dp);

        return dp[i] = Math.max(take, notTake);
    }

    public static int houseRobberTabulation(int[] nums){
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int neg = 0;

        for (int i = 1; i < nums.length; i++) {
            int take = nums[i];
            if(i > 1) take += dp[i - 2];

            int notTake = dp[i- 1];

            dp[i] = Math.max(take, notTake);
        }

        return dp[nums.length - 1];
    }

    public static int houseRobberTabulationSpaceOpt(int[] nums){
        int prev = nums[0];
        int prev2 = 0;

        for (int i = 1; i < nums.length; i++) {
            int take = nums[i];
            if(i > 1) take += prev2;

            int notTake = prev;

            prev2 = prev;
            prev =  Math.max(take, notTake);
        }

        return prev;
    }

    public static int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
//        return houseRobberDP(nums.length - 1, nums, dp);
        return houseRobberTabulation(nums);
    }



    public static void main(String[] args) {
        int[] arr = {2,1};

        System.out.println(rob(arr));
    }
}

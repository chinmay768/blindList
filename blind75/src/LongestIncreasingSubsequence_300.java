import java.util.Arrays;

public class LongestIncreasingSubsequence_300 {

    public static int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length + 1];
        for (int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
//        return LISUsingRecursion(nums, 0, -1);
//        return LISUsingDP(nums, 0, -1, dp);
        return LISUsingBinarySearch(nums);
    }

    //TC: O(2^n)  // SC: O(n)
    public static int LISUsingRecursion(int[] nums, int i, int prevIdx) {
        if(i >= nums.length) return 0;

        int take = 0;
        // Take
        if(prevIdx == -1 || nums[i] > nums[prevIdx]){
            take = LISUsingRecursion(nums, i + 1, i) + 1;
        }

        //Not Take
        int notTake = 0;
        notTake = LISUsingRecursion(nums, i + 1, prevIdx);

        return Math.max(take, notTake);
    }

    //TC: O(n * n)   // SC: O(n * m) + O(n)
    public static int LISUsingDP(int[] nums, int i, int prevIdx, int[][] dp) {
        if(i >= nums.length) return 0;

        if(dp[i][prevIdx + 1] != -1) return dp[i][prevIdx + 1];

        int take = 0;
        // Take
        if(prevIdx == -1 || nums[i] > nums[prevIdx]){
            take = LISUsingDP(nums, i + 1, i, dp) + 1;
        }

        //Not Take
        int notTake = 0;
        notTake = LISUsingDP(nums, i + 1, prevIdx, dp);

        return dp[i][prevIdx + 1] = Math.max(take, notTake);
    }

    public static int LISUsingBinarySearch(int[] nums){
        int[] lis = new int[nums.length];
        int k = 0;

        for (int i = 0; i < nums.length; i++) {

            if(k == 0 || lis[k - 1] < nums[i]){
                lis[k] = nums[i];
                k++;
            }else{
                int targetIdx = binarySearchLowerBound(lis, nums[i], k - 1);
                lis[targetIdx] = nums[i];
            }
        }

        return k;
    }

    private static int binarySearchLowerBound(int[] lis, int num, int end){
        //Either same or the nearest greater
        int start = 0;
        int targetIdx = -1;

        while (start <= end){
            int mid = start + (end - start)  / 2;

            if(lis[mid] >= num) {
                targetIdx = mid;
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }

        return targetIdx;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,6,2,5,4,19,5,6,7,12};
        System.out.println(lengthOfLIS(arr));
    }
}

/*
Given an integer array nums, return the length of the longest strictly increasing subsequence.



Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1


Constraints:

1 <= nums.length <= 2500
-104 <= nums[i] <= 104
 */
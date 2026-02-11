import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence_128 {

    // TC: O(nLogn)     SC: O(1)
    public int longestConsecutiveBetter(int[] nums) {
        Arrays.sort(nums);

        int maxLen = Integer.MIN_VALUE;
        int prevVal = Integer.MIN_VALUE;
        int currLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if(prevVal == nums[i] - 1){
                currLen++;
                prevVal = nums[i]; // Cant keep prevVal common bc it should not be updated in case of same elements
            }else if(prevVal != nums[i]) {
                // PrevNot one smaller than curr
                currLen = 1;
                prevVal = nums[i];
            }

            maxLen = Math.max(maxLen, currLen);
        }

        return maxLen == Integer.MIN_VALUE? 0 : maxLen;
    }

    public int longestConsecutiveOptimal(int[] nums) {
        Set<HashSet> set = new HashSet<>();


    }

    public static void main(String[] args) {

    }
}

/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.



Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
Example 3:

Input: nums = [1,0,1,2]
Output: 3


Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
 */
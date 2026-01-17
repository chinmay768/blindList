import java.util.HashMap;
import java.util.Map;

public class LongestSubarraySumEqualsK {

    public static int longestSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> preSumMap = new HashMap<>();
        preSumMap.put(0, -1);
        int maxLen = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];

            if(preSumMap.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - preSumMap.get(sum - k));
            }

            if(!preSumMap.containsKey(sum)){
                preSumMap.put(sum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {

    }
}

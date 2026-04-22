import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

    public static Map<String, String> map = new HashMap<>();

    public static int numDecodingsRec(String s, int i) {
        if(i == s.length()) return 1;
        if(s.charAt(i) == '0') return 0;

        int countWays = 0;
        // take one
        int num = Integer.parseInt(s.substring(i, i + 1));
        countWays += numDecodingsRec(s, i + 1);

        //take two
        if(i < s.length() - 1 && Integer.parseInt(s.substring(i, i + 2)) <= 26) {
            countWays += numDecodingsRec(s, i + 2);
        }

        return countWays;
    }

    public static int numDecodingsDP(String s, int i, int[] dp) {
        if(i == s.length()) return 1;
        if(s.charAt(i) == '0') return 0;

        if(dp[i] != -1) return dp[i];
        int countWays = 0;
        // take one
        int num = Integer.parseInt(s.substring(i, i + 1));
        countWays += numDecodingsDP(s, i + 1, dp);

        //take two
        if(i < s.length() - 1 && Integer.parseInt(s.substring(i, i + 2)) <= 26) {
            countWays += numDecodingsDP(s, i + 2, dp);
        }

        return countWays;
    }

    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return numDecodingsDP(s, 0, dp);
//        return numDecodingsRec(s, 0);
    }

    public static void main(String[] args) {

//        for (int i = 1; i <= 26; i++) {
//            map.put(String.valueOf(i), String.valueOf((char) ('A' + i - 1)));
//        }
    }
}

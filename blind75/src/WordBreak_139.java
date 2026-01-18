import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak_139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wd = new HashSet<>(wordDict);
//        wd.addAll(wordDict);
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i], -1);
        }

        return wordBreakDP(0, 0, s, wd, dp);
    }

    public boolean wordBreakRecursive(int start, int end, String s, Set<String> wordDict) {
        if(end == s.length() - 1){
            return wordDict.contains(s.substring(start, end + 1));
        }

        if(wordDict.contains(s.substring(start, end + 1))){
            return wordBreakRecursive(end + 1, end + 1, s, wordDict);
        }

        return wordBreakRecursive(start, end + 1, s, wordDict);
    }

    public boolean wordBreakDP(int start, int end, String s, Set<String> wordDict, int[][] dp) {
        if(dp[start][end] != -1) return dp[start][end] == 1;

        if(end == s.length() - 1){
            return wordDict.contains(s.substring(start, end + 1));
        }

        if(wordDict.contains(s.substring(start, end + 1))){
            if(wordBreakDP(end + 1, end + 1, s, wordDict, dp)){
                dp[start][end] = 1;
                return true;
            }
        }

        dp[start][end] = wordBreakDP(start, end + 1, s, wordDict,dp)? 1 : 0;
        return dp[start][end] == 1;
    }

    public static void main(String[] args) {

    }
}


/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.



Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false


Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
 */

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring_76 {

    public static String minWindow(String s, String t) {
        int minSize = Integer.MAX_VALUE;
        int[] window = new int[2];

        Map<Character, Integer> targetMap = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            targetMap.put(t.charAt(i), targetMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        Map<Character, Integer> currMap = new HashMap<>();

        int startIdx = 0;
        int currIdx = 0;
        int currMatch = 0;
        int requiredMatch = targetMap.size();
        while (currIdx < s.length()){
            Character currCh =  s.charAt(currIdx);
            if(targetMap.containsKey(currCh)){
                currMap.put(currCh, currMap.getOrDefault(currCh, 0) + 1);

                if(currMap.get(currCh).equals(targetMap.get(currCh))){ //  Note always compare char and string using equals
                    currMatch++;
                }
            }

            while (currMatch == requiredMatch){
                Character startCh = s.charAt(startIdx);
                if(targetMap.containsKey(startCh)){
                    currMap.put(startCh, currMap.get(startCh) - 1);

                    if(currMap.get(startCh) < targetMap.get(startCh)) currMatch--;
                }

                if(minSize > currIdx - startIdx + 1){
                    minSize = currIdx - startIdx + 1;
                    window = new int[]{startIdx, currIdx};
                }

                startIdx++;
            }

            currIdx++;
        }

        return minSize == Integer.MAX_VALUE ? "" : s.substring(window[0] , window[1] + 1);
    }

    public static void main(String[] args) {
        String s =
                "ADOBECODEBANC";

        String t =
                "ABC";

        System.out.println(minWindow(s, t));
    }

}


/*
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.



Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.


Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.
 */
import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters_3 {

    public int lengthOfLongestSubstring(String s) {
        int[] visited = new int[256];
        Arrays.fill(visited, -1);

        int left = 0;
        int right = 0;
        int maxLen = 0;
        while (right < s.length()) {
            int lastSeenIdx = visited[s.charAt(right)];

            if(lastSeenIdx != -1 && lastSeenIdx >= left) {
                left = lastSeenIdx + 1;
            }

            visited[s.charAt(right)] = right;
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }

    public static void main(String[] args) {

    }
}


/*
Given a string s, find the length of the longest substring without duplicate characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 */
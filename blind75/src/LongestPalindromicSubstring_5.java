public class LongestPalindromicSubstring_5 {

    // TC: O(n^2) SC: O(1)
    public static String longestPalindromeOptimal(String s) {
        int l, r;
        int maxLen = 0;
        String res = "";


        for (int i = 0; i < s.length(); i++){
            l = i;
            r = i;

            // Odd Len Palidrome
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }

            String palindrome = s.substring(l + 1, r);
            if(maxLen < palindrome.length()) {
                res = palindrome;
                maxLen = palindrome.length();
            }

            // Even len palidrome
            l = i - 1;
            r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }

            palindrome = s.substring(l + 1, r);
            if(maxLen < palindrome.length()) {
                res = palindrome;
                maxLen = palindrome.length();
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "babad";

        System.out.println(longestPalindromeOptimal(s));
    }
}

/*
Given a string s, return the longest palindromic substring in s.



Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"


Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
 */
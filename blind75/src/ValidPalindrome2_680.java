public class ValidPalindrome2_680 {

    public static boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start <= end) {
            if(s.charAt(start) != s.charAt(end)){
                return isPalindrome(s.substring(start + 1, end + 1)) || isPalindrome(s.substring(start, end));
            }

            start++;
            end--;
        }

        return true;
    }

    private static boolean isPalindrome(String s){
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {

    }
}

/*
Given a string s, return true if the s can be palindrome after deleting at most one character from it.

Example 1:

Input: s = "aba"
Output: true
Example 2:

Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.
Example 3:

Input: s = "abc"
Output: false


Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
 */
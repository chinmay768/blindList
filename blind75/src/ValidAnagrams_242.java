import java.util.Arrays;

public class ValidAnagrams_242 {

    //TC: (nlogN + n)  SC:
    public static boolean isAnagramNaive(String s, String t) {
        if(s.length() != t.length()) return false;

        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        Arrays.sort(s1);
        Arrays.sort(t1);

        for (int i = 0; i < s1.length; i++){
            if(s1[i] != t1[i]) return false;
        }

        return true;
    }

    public static boolean isAnagramOptimal(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] countArr = new int[26];

        for (char ch : s.toCharArray()) {
            countArr[ch - 'a']++;
        }

        for (char ch : t.toCharArray()){
            countArr[ch - 'a']--;
        }

        for (int i = 0; i < countArr.length; i++){
            if(countArr[i] != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {

    }
}

/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.



Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false



Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 */
